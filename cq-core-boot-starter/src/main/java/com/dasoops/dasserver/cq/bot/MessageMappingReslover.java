package com.dasoops.dasserver.cq.bot;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageParamResloveExceptionEnum;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.cq.entity.result.PluginResult;
import com.dasoops.dasserver.cq.utils.DqCodeUtil;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Title: MessageParamReslover
 * @ClassPath com.dasoops.dasserver.cq.bot.MessageParamReslover
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/08
 * @Version 1.0.0
 * @Description: 消息映射解析器
 */
public class MessageMappingReslover {

    public static <T extends BaseParam<? extends BaseDo>> PassObj resloveParamAndHandle(CqPlugin cqPlugin, CqTemplate cqTemplate, CqMessageEvent messageEvent, String defaultMethodName, EventTypeEnum eventTypeEnum) {
        //开始选择方法,优先判断包含注解的方法,都不符合再调用继承的,再不符合直接调用CqPlugin的默认实现
        Class<? extends CqPlugin> clazz = cqPlugin.getClass();
        Method[] pluginMethods = clazz.getMethods();
        for (Method pluginMethod : pluginMethods) {
            //检查是否需要解析
            String matchKeyword = checkNeedReslove(pluginMethod, messageEvent, defaultMethodName, eventTypeEnum);
            if (matchKeyword == null) {
                continue;
            }
            //开始反射获取实体类
            //获取全部类型
            Class<?>[] paramClazzs = pluginMethod.getParameterTypes();
            //有泛型的类
            //过滤,获取MessageParam类型的
            //忽略类型检查,实际已经过滤了
            Type[] types = pluginMethod.getGenericParameterTypes();
            List<ParameterizedType> messageParamTypeList = Arrays.stream(types)
                    .filter(type -> type instanceof ParameterizedType)
                    .map(type -> (ParameterizedType) type)
                    .filter(type -> ((Class<?>) type.getRawType()).isAssignableFrom(MappingMessage.class))
                    .toList();

            int messageParamSize = messageParamTypeList.size();
            Object[] params;
            if (messageParamSize > 1) {
                //超出限制,无法注入,抛出异常
                throw new LogicException(MessageParamResloveExceptionEnum.MESSAGE_PARAM_COUNT_OUT_OF_LIMIT);
            } else if (messageParamSize == 0) {
                //为0,不需要注入param,直接开始注入其他参数
                params = buildParams(paramClazzs, cqTemplate, messageEvent);
            } else {
                ParameterizedType messageParamParameterizedType = messageParamTypeList.get(0);
                //构建MessageParam对象
                //已经经过类型检查
                @SuppressWarnings("all")
                Class<MappingMessage<T>> messageParamClazz = (Class<MappingMessage<T>>) messageParamParameterizedType.getRawType();
                //实例化对象
                MappingMessage<T> mappingMessage = ReflectUtil.newInstance(messageParamClazz);
                //获取泛型类型
                //已经经过类型检查
                @SuppressWarnings("all")
                Class<T> genericParameterClazz = (Class<T>) messageParamParameterizedType.getActualTypeArguments()[0];
                //注入属性
                injectionValue(mappingMessage, eventTypeEnum, pluginMethod.getAnnotation(MessageMapping.class), messageEvent, genericParameterClazz, matchKeyword);
                //构建参数集合
                params = buildParams(paramClazzs, cqTemplate, messageEvent, mappingMessage);
            }
            //执行方法
            Object result;
            //捕获断言抛出的参数异常
            try {
                result = pluginMethod.invoke(cqPlugin, params);
//                result = ReflectUtil.invoke(cqPlugin, pluginMethod, params);
            } catch (LogicException e) {
                //非参数解析异常直接抛出,由wsHandler处理
                if (!e.getExceptionEnum().equals(CqExceptionEnum.PARAM_RESLOVE_ERROR)) {
                    throw e;
                }
                //参数解析异常使用快速失败处理
                result = PluginResult.fastFail();
            } catch (InvocationTargetException e) {
                if (!(e.getTargetException() instanceof LogicException logicException)) {
                    throw new LogicException(e.getTargetException());
                }
                //非参数解析异常直接抛出,由wsHandler处理
                if (!logicException.getExceptionEnum().equals(CqExceptionEnum.PARAM_RESLOVE_ERROR)) {
                    throw logicException;
                }
                //参数解析异常使用快速失败处理
                result = PluginResult.fastFail();
            } catch (IllegalAccessException e) {
                throw new LogicException(e);
            }
            PassObj passObj = resloveInvokeResult(cqTemplate, messageEvent, result);
            if (passObj != null) {
                return passObj;
            }
            return PassObj.block();
        }
        return null;
    }

    /**
     * 解析调用结果
     *
     * @param cqTemplate   cq模板
     * @param messageEvent 消息事件
     * @param result       结果
     * @return {@link PassObj}
     */
    @SuppressWarnings("unchecked")
    private static PassObj resloveInvokeResult(CqTemplate cqTemplate, CqMessageEvent messageEvent, Object result) {
        if (result == null) {
            return PassObj.block();
        }
        if (result instanceof PassObj passObj) {
            //自己处理passObj
            return passObj;
        } else if (result instanceof Boolean boolResult) {
            return boolResult ? PassObj.pass(messageEvent) : PassObj.block();
        } else if (result instanceof String resultStr) {
            //单句
            cqTemplate.sendMsg(messageEvent, resultStr);
            return PassObj.block();
        } else {
            //前面判断过了只有String,PassObj,PluginResult,List<? extends String>,这里是List<? extends String>
            List<String> messageList;
            if (result instanceof PluginResult pluginResult) {
                messageList = pluginResult.getMessageList();
            } else {
                //前面判断过了只有String,PassObj,PluginResult,List<? extends String>,这里是List<? extends String>
                messageList = (List<String>) result;
            }
            messageList.forEach(message -> cqTemplate.sendMsg(messageEvent, message));
        }
        return null;
    }

    /**
     * 检查是否需要解析
     *
     * @param pluginMethod      插件方法
     * @param messageEvent      消息事件
     * @param defaultMethodName 默认方法名称
     * @param eventTypeEnum     事件类型枚举
     * @return boolean
     */
    private static String checkNeedReslove(Method pluginMethod, CqMessageEvent messageEvent, String defaultMethodName, EventTypeEnum eventTypeEnum) {
        //检查是否有注解(需要解析),没有直接过
        if (!hasAnnotation(pluginMethod)) {
            return null;
        }
        //从注解获取type,根据type检查是否匹配
        MessageMapping annotation = pluginMethod.getAnnotation(MessageMapping.class);
        boolean typeIsMatch = typeIsMatch(defaultMethodName, eventTypeEnum, pluginMethod, annotation);
        if (!typeIsMatch) {
            return null;
        }
        //检查是否匹配解析规则,不匹配直接过
        String message = messageEvent.getMessage();
        String matchKeyword = checkMessageIsMatch(message, annotation);
        if (matchKeyword == null) {
            return null;
        }
        //检查返回值类型是否通过,不过抛异常,不惯着你直接抛,咱不做低声下气的人
        boolean returnTypeIsMatch = checkReturnType(pluginMethod);
        if (!returnTypeIsMatch) {
            throw new LogicException(MessageParamResloveExceptionEnum.RETURN_TYPE_IS_NOT_PASSOBJ);
        }
        return matchKeyword;
    }

    private static boolean checkReturnType(Method pluginMethod) {
        //是否属于void, PassObj, String, PluginResult, boolean
        Class<?> returnType = pluginMethod.getReturnType();
        if (returnType == void.class ||
                PassObj.class.isAssignableFrom(returnType) ||
                String.class.isAssignableFrom(returnType) ||
                PluginResult.class.isAssignableFrom(returnType) ||
                boolean.class.isAssignableFrom(returnType) ||
                Boolean.class.isAssignableFrom(returnType)

        ) {
            return true;
        }

        // 开始检查泛型 允许的类型 List<? extends String>
        // 是否继承于List
        if (!List.class.isAssignableFrom(pluginMethod.getReturnType())) {
            return false;
        }

        //检查是否多个泛型
        ParameterizedType parameterizedType = (ParameterizedType) pluginMethod.getGenericReturnType();
        Type[] argumentTypes = parameterizedType.getActualTypeArguments();
        if (argumentTypes.length > 1) {
            return false;
        }

        //检查泛型是否继承于String
        Class<?> clazz = (Class<?>) argumentTypes[0];
        if (!String.class.isAssignableFrom(clazz)) {
            return false;
        }

        return true;
    }

    private static Object[] buildParams(Class<?>[] paramClazzs, CqTemplate cqTemplate, CqMessageEvent messageEvent, MappingMessage<? extends BaseParam<? extends BaseDo>> mappingMessage) {
        Object[] params = new Object[paramClazzs.length];
        for (int i = 0; i < paramClazzs.length; i++) {
            Class<?> paramClazz = paramClazzs[i];
            if (CqTemplate.class.isAssignableFrom(paramClazz)) {
                //注入cqTemplate
                params[i] = cqTemplate;
            } else if (paramClazz.isAssignableFrom(messageEvent.getClass())) {
                //注入原始消息对象
                params[i] = messageEvent;
            }
            //没这个参数直接过就行了
            if (mappingMessage == null) {
                continue;
            }
            if (MappingMessage.class.isAssignableFrom(paramClazz)) {
                //注入messageParam
                params[i] = mappingMessage;
            }
            //其余情况不需要注入,因为没东西注入,可能会搞个自定义注入器?那还要配套解析器欸
        }
        return params;
    }

    private static Object[] buildParams(Class<?>[] paramClazzs, CqTemplate cqTemplate, CqMessageEvent messageEvent) {
        return buildParams(paramClazzs, cqTemplate, messageEvent, null);
    }

    private static boolean typeIsMatch(String defaultMethodName, EventTypeEnum messageType, Method
            pluginMethod, MessageMapping annotation) {
        MessageMappingTypeEnum messageMappingTypeEnum = annotation.type();
        switch (messageMappingTypeEnum) {
            //根据方法名匹配
            case FORM_METHOD_NAME -> {
                //名称与默认调用的方法的名称不同直接短路
                String name = pluginMethod.getName();
                if (!name.equals(defaultMethodName)) {
                    return false;
                }
            }
            //匹配私聊消息
            case PRIVATE -> {
                if (!messageType.equals(EventTypeEnum.MESSAGE_PRIVATE)) {
                    return false;
                }
            }
            //匹配群组
            case GROUP -> {
                if (!messageType.equals(EventTypeEnum.MESSAGE_GROUP)) {
                    return false;
                }
            }
            //匹配所有
            //枚举都用完了编译器还报错,非得default
            //这箭头更离谱,default也报
            default -> {
            }
        }
        return true;
    }

    private static boolean hasAnnotation(Method pluginMethod) {
        return pluginMethod.isAnnotationPresent(MessageMapping.class);
    }


    private static <T extends BaseParam<? extends BaseDo>> void injectionValue(final MappingMessage<T> mappingMessageParam, EventTypeEnum eventTypeEnum, MessageMapping annotation, CqMessageEvent messageEvent, Class<T> genericParameterClazz, String matchKeyword) {
        //设置isGroup
        boolean isGroup = eventTypeEnum.equals(EventTypeEnum.MESSAGE_GROUP);
        mappingMessageParam.setIsGroup(isGroup);
        mappingMessageParam.setUserId(messageEvent.getUserId());
        if (isGroup) {
            mappingMessageParam.setGroupId(((CqGroupMessageEvent) messageEvent).getGroupId());
        }
        mappingMessageParam.setMatchKeyword(matchKeyword);

        //获取泛型实例对象
        T param = ReflectUtil.newInstance(genericParameterClazz);
        //获取字段,根据注解判断是否需要注入
        Field[] paramFields = param.getClass().getDeclaredFields();
        //长度为0 没有参数 直接返回就可以
        if (paramFields.length == 0) {
            return;
        }
        //获取排序后的需要注入的字段集合
        List<Field> sortedNeedSetFieldList = getSortedNeedSetField(paramFields);
        //调用dq码工具类获取paramString
        String message = messageEvent.getMessage();
        List<String> paramStringList = DqCodeUtil.getParamStr(message, getMatchPrefix(message, annotation), getMatchSuffix(message, annotation), annotation.separator(), annotation.ignoreDbc(), annotation.skipCq(), annotation.trim());
        //开始调用set方法注入字段,考虑可选参数情况,取小的set,多的不赋值了
        int paramNeedSetFieldCount = sortedNeedSetFieldList.size();
        int insertParamCount = paramStringList.size();
        for (int i = 0; i < Math.min(paramNeedSetFieldCount, insertParamCount); i++) {
            Field field = sortedNeedSetFieldList.get(i);
            InjectionParam injectionParam = field.getAnnotation(InjectionParam.class);
            int order = injectionParam.order();
            String paramString = paramStringList.get(order);
            ReflectUtil.setFieldValue(param, field, paramString);
        }
        mappingMessageParam.setParam(param);
    }

    private static List<Field> getSortedNeedSetField(Field[] paramFields) {
        //对字段过滤
        List<Field> sortedNeedSetFieldList = Arrays.stream(paramFields)
                //过滤掉不需要注入的字段
                .filter(field -> field.isAnnotationPresent(InjectionParam.class))
                //排序
                .sorted(Comparator.comparingInt(field -> field.getAnnotation(InjectionParam.class).order())).toList();
        //检查是否有断层/超出限制的order
        checkOrder(sortedNeedSetFieldList);
        return sortedNeedSetFieldList;
    }

    private static void checkOrder(List<Field> sortFieldList) {
        int fieldCount = sortFieldList.size();
        if (fieldCount == 0) {
            return;
        }
        //获取最大order
        Field maxOrderField = sortFieldList.get(fieldCount - 1);
        InjectionParam maxOrderFieldInjectionParam = maxOrderField.getAnnotation(InjectionParam.class);
        int maxOrder = maxOrderFieldInjectionParam.order();
        //最大order > 需要注入的字段size - 1 即为存在
        if (maxOrder > fieldCount - 1) {
            throw new LogicException(MessageParamResloveExceptionEnum.HAS_SAME_OR_LACK_ORDER);
        }
    }

    /**
     * 检查消息是否匹配
     * 目前只包含prefix,后续可能会支持contains,suffix?
     *
     * @param message    消息
     * @param annotation 注释
     * @return boolean
     */
    private static String checkMessageIsMatch(String message, MessageMapping annotation) {
        if (annotation.ignoreDbc()) {
            message = Convert.toDBC(message);
        }
        //前缀匹配
        for (String prefix : annotation.prefix()) {
            if (annotation.ignoreDbc()) {
                prefix = Convert.toDBC(prefix);
            }
            //匹配通过直接return
            if (StrUtil.startWith(message, prefix, annotation.ignoreCase())) {
                return prefix;
            }
        }
        //后缀匹配
        for (String suffix : annotation.suffix()) {
            if (annotation.ignoreDbc()) {
                suffix = Convert.toDBC(suffix);
            }
            if (StrUtil.endWith(message, suffix, annotation.ignoreCase())) {
                return suffix;
            }
        }
        //包含关键词匹配
        for (String keyword : annotation.contains()) {
            if (message.contains(keyword)) {
                return keyword;
            }
        }
        //全部不匹配
        return null;
    }

    private static String getMatchPrefix(String message, MessageMapping annotation) {
        if (annotation.ignoreDbc()) {
            message = Convert.toDBC(message);
        }
        for (String prefix : annotation.prefix()) {
            if (annotation.ignoreDbc()) {
                prefix = Convert.toDBC(prefix);
            }
            //匹配通过直接return
            if (StrUtil.startWith(message, prefix, annotation.ignoreCase())) {
                return prefix;
            }
        }
        return "";
    }

    private static String getMatchSuffix(String message, MessageMapping annotation) {
        if (annotation.ignoreDbc()) {
            message = Convert.toDBC(message);
        }
        for (String suffix : annotation.suffix()) {
            if (annotation.ignoreDbc()) {
                suffix = Convert.toDBC(suffix);
            }
            //匹配通过直接return
            if (StrUtil.endWith(message, suffix, annotation.ignoreCase())) {
                return suffix;
            }
        }
        return "";
    }


}
