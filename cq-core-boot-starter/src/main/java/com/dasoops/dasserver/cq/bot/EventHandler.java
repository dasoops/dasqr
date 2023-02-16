package com.dasoops.dasserver.cq.bot;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.*;
import com.dasoops.dasserver.cq.entity.dto.cq.event.CqEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqDiscussMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqLifecycleMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.notice.*;
import com.dasoops.dasserver.cq.entity.dto.cq.event.request.CqFriendRequestEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.request.CqGroupRequestEvent;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PostTypeEnum;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import com.dasoops.dasserver.cq.wrapper.AuthWrapper;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * @title EventHandler
 * @classPath com.dasoops.dasserver.cq.bot.EventHandler
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 事件处理器
 * 先根据 post_type 分类，消息/通知/请求/元事件
 * 然后交给对应的继续分类
 * 职责链模式调用插件，返回PassObj.block()停止
 */
@Slf4j
public class EventHandler {

    /**
     * 消息处理
     *
     * @param cqTemplate cq
     * @param eventJson  事件json
     */
    public void handle(CqTemplate cqTemplate, JSONObject eventJson) {
        EventInfo eventInfo = EventUtil.get();

        List<WsWrapper> wsWrapperList = WrapperGlobal.getWsWrapperList();
        boolean pass = wsWrapperList.stream().allMatch(wsWrapper -> wsWrapper.beforeHandleTextMessage(cqTemplate, eventInfo));
        if (!pass) {
            return;
        }

        PostTypeEnum postTypeEnum = eventInfo.getPostTypeEnum();
        EventTypeEnum eventTypeEnum = eventInfo.getEventTypeEnum();
        if (eventTypeEnum == null) {
            log.error("undefined event type: " + eventJson.toJSONString());
            throw new LogicException(CqExceptionEnum.UNDEFINED_EVENT_TYPE);
        }

        switch (postTypeEnum) {
            case MESSAGE -> {
                switch (eventTypeEnum) {
                    case MESSAGE_PRIVATE -> handleResloveMessage(cqTemplate, eventJson, CqPrivateMessageEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onPrivateMessage(cqTemplate, (CqPrivateMessageEvent) cqEvent), "onPrivateMessage", EventTypeEnum.MESSAGE_PRIVATE);
                    case MESSAGE_GROUP -> handleResloveMessage(cqTemplate, eventJson, CqGroupMessageEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupMessage(cqTemplate, (CqGroupMessageEvent) cqEvent), "onGroupMessage", EventTypeEnum.MESSAGE_GROUP);
                    case MESSAGE_DISCUSS -> handleMessage(cqTemplate, eventJson, CqDiscussMessageEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onDiscussMessage(cqTemplate, (CqDiscussMessageEvent) cqEvent));
                }
            }
            case MESSAGE_SENT -> {
                switch (eventTypeEnum) {
                    case MESSAGE_SENT_PRIVATE -> handleMessage(cqTemplate, eventJson, CqPrivateMessageEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onBotSentPrivateMessage(cqTemplate, (CqPrivateMessageEvent) cqEvent));
                    case MESSAGE_SENT_GROUP -> handleMessage(cqTemplate, eventJson, CqGroupMessageEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onBotSentGroupMessage(cqTemplate, (CqGroupMessageEvent) cqEvent));
                    case MESSAGE_SENT_DISCUSS -> handleMessage(cqTemplate, eventJson, CqDiscussMessageEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onBotSentDiscussMessage(cqTemplate, (CqDiscussMessageEvent) cqEvent));
                }
            }
            case NOTICE -> {
                switch (eventTypeEnum) {
                    case NOTICE_FRIEND_ADD -> handleMessage(cqTemplate, eventJson, CqFriendAddNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onFriendAddNotice(cqTemplate, (CqFriendAddNoticeEvent) cqEvent));
                    case NOTICE_GROUP_ADMIN -> handleMessage(cqTemplate, eventJson, CqGroupAdminNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupAdminNotice(cqTemplate, (CqGroupAdminNoticeEvent) cqEvent));
                    case NOTICE_GROUP_BAN -> handleMessage(cqTemplate, eventJson, CqGroupBanNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupBanNotice(cqTemplate, (CqGroupBanNoticeEvent) cqEvent));
                    case NOTICE_GROUP_DECREASE -> handleMessage(cqTemplate, eventJson, CqGroupDecreaseNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupDecreaseNotice(cqTemplate, (CqGroupDecreaseNoticeEvent) cqEvent));
                    case NOTICE_GROUP_INCREASE -> handleMessage(cqTemplate, eventJson, CqGroupIncreaseNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupIncreaseNotice(cqTemplate, (CqGroupIncreaseNoticeEvent) cqEvent));
                    case NOTICE_GROUP_UPLOAD -> handleMessage(cqTemplate, eventJson, CqGroupUploadNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupUploadNotice(cqTemplate, (CqGroupUploadNoticeEvent) cqEvent));
                    case NOTICE_GROUP_RECALL -> handleMessage(cqTemplate, eventJson, CqGroupRecallNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupRecallNotice(cqTemplate, (CqGroupRecallNoticeEvent) cqEvent));
                    case NOTICE_FRIEND_RECALL -> handleMessage(cqTemplate, eventJson, CqFriendRecallNoticeEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onFriendRecallNotice(cqTemplate, (CqFriendRecallNoticeEvent) cqEvent));
                    case NOTICE_GROUP_CARD -> handleMessage(cqTemplate, eventJson, CqGroupCardNoticeEvent.class, (cqPluginPrama, cqTemplateParam, cqEvent) -> cqPluginPrama.onGroupCardNotice(cqTemplate, (CqGroupCardNoticeEvent) cqEvent));
                }
            }
            case REQUEST -> {
                switch (eventTypeEnum) {
                    case REQUEST_FRIEND -> handleMessage(cqTemplate, eventJson, CqFriendRequestEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onFriendRequest(cqTemplate, (CqFriendRequestEvent) cqEvent));
                    case REQUEST_GROUP -> handleMessage(cqTemplate, eventJson, CqGroupRequestEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onGroupRequest(cqTemplate, (CqGroupRequestEvent) cqEvent));
                }
            }
            case META_EVENT -> {
                switch (eventTypeEnum) {
                    case META_EVENT_HEARTBEAT -> handleMetaEvent(cqTemplate, eventJson, CqHeartBeatMetaEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onHeartBeatMeta(cqTemplate, (CqHeartBeatMetaEvent) cqEvent));
                    case META_EVENT_LIFECYCLE -> handleMetaEvent(cqTemplate, eventJson, CqLifecycleMetaEvent.class, (cqPluginParam, cqTemplateParam, cqEvent) -> cqPluginParam.onLifecycleMeta(cqTemplate, (CqLifecycleMetaEvent) cqEvent));
                }
            }
            default -> log.error("not found reslove method");
        }
    }

    /**
     * 处理消息的function接口,提供给上面的匿名内部类使用
     */
    private interface HandleFunction {
        /**
         * 执行
         *
         * @param cqPlugin   cqPlugin
         * @param cqTemplate cqTemplate
         * @param cqEvent    cqEvent
         * @return {@link PassObj}
         */
        PassObj handle(CqPlugin cqPlugin, CqTemplate cqTemplate, CqEvent cqEvent);
    }

    /**
     * 身份验证
     *
     * @param cqPlugin cq插件
     * @return boolean 是否通过权限验证
     */
    private boolean auth(CqPlugin cqPlugin) {
        List<AuthWrapper> authWrapperList = WrapperGlobal.getAuthWrapperList();
        if (authWrapperList != null && !WrapperGlobal.getAuthWrapperList().isEmpty()) {
            //全部通过才是通过
            return authWrapperList.stream().allMatch(authWrapper -> authWrapper.auth(cqPlugin.getRawPlugin().getClass().getName()));
        }
        //没有权限增强直接通过
        return true;
    }

    /**
     * 处理消息(必须身份验证)
     *
     * @param cqTemplate cqTemplate
     * @param eventJson  事件json对象
     * @param clazz      clazz
     */
    private void handleMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqEvent> clazz, HandleFunction func) {
        handleMessage(cqTemplate, eventJson, clazz, func, true);
    }

    /**
     * 处理元事件(无需身份验证)
     *
     * @param cqTemplate cqTemplate
     * @param eventJson  事件json对象
     * @param clazz      clazz
     */
    private void handleMetaEvent(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqMetaEvent> clazz, HandleFunction func) {
        handleMessage(cqTemplate, eventJson, clazz, func, false);
    }

    /**
     * 处理消息
     *
     * @param cqTemplate      cqTemplate
     * @param eventJson       事件json对象
     * @param clazz           clazz
     * @param defaultFunction 默认方法
     * @param mustAuth        是否必须认证
     */
    private void handleMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqEvent> clazz, HandleFunction defaultFunction, boolean mustAuth) {
        handleMessage(cqTemplate, eventJson, clazz, defaultFunction, mustAuth, null, null);
    }

    /**
     * 处理需要解析的消息(必须验证)
     *
     * @param cqTemplate        cqTemplate
     * @param eventJson         事件json对象
     * @param clazz             clazz
     * @param defaultFunction   默认方法
     * @param defaultMethodName 默认调用方法名称
     * @param eventTypeEnum     消息类型枚举
     */
    private void handleResloveMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqMessageEvent> clazz, HandleFunction defaultFunction, String defaultMethodName, EventTypeEnum eventTypeEnum) {
        handleMessage(cqTemplate, eventJson, clazz, defaultFunction, true, defaultMethodName, eventTypeEnum);
    }

    /**
     * 处理需要解析的消息
     *
     * @param cqTemplate        cqTemplate
     * @param eventJson         事件json对象
     * @param clazz             clazz
     * @param defaultFunction   默认方法
     * @param mustAuth          是否必须认证
     * @param defaultMethodName 默认调用方法名称
     * @param eventTypeEnum     消息类型枚举
     */
    private void handleMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqEvent> clazz, HandleFunction defaultFunction, boolean mustAuth, String defaultMethodName, EventTypeEnum eventTypeEnum) {
        //实际只有俩会走这里,其余的不会走这个方法,所以通过硬编码实现,但是考虑到以后可能会改,所以先不删而是注释
        /*
        if (!messageTypeEnum.equals(MessageTypeEnum.MESSAGE_GROUP) && !messageTypeEnum.equals(MessageTypeEnum.MESSAGE_PRIVATE)) {
            throw new LogicException(MessageParamResloveExceptionEnum.MESSAGE_TYPE_NOT_MATCH);
        }
        */
        //方法内部变量
        PassObj passObj = PassObj.pass(eventJson.to(clazz));
        //执行链执行记录保存,用于日志打印,多生成一个变量,都怪idea或者编译器,不知道谁的锅,本来没必要的
        StringBuilder pluginChainStringBuilder = new StringBuilder();
        for (CqPlugin cqPlugin : CqPluginGlobal.getAll()) {
            //无权限返回为空,直接进入下一个判断
            if (mustAuth) {
                if (!auth(cqPlugin)) {
                    continue;
                }
            }
            //是否需要解析参数
            if (defaultMethodName != null && eventTypeEnum != null) {
                //解析插件注解,来进行方法注入和调用
                @SuppressWarnings("all")
                PassObj reslovePassObj = MessageMappingReslover.resloveParamAndHandle(cqPlugin, cqTemplate, ((Class<? extends CqMessageEvent>) clazz).cast(passObj.getEvent()), defaultMethodName, eventTypeEnum);
                if (reslovePassObj != null) {
                    passObj = reslovePassObj;
                } else {
                    //没有解析,说明不符合，调用默认的,gogogo
                    passObj = defaultFunction.handle(cqPlugin, cqTemplate, clazz.cast(passObj.getEvent()));
                }
            } else {
                //非message,不需要解析,直接调用,gogogo
                passObj = defaultFunction.handle(cqPlugin, cqTemplate, clazz.cast(passObj.getEvent()));
            }
            if (log.isDebugEnabled()) {
                if (pluginChainStringBuilder.length() > 0) {
                    pluginChainStringBuilder.append(" -> ");
                }
                String classPath = cqPlugin.getRawPlugin().getClass().getName();
                pluginChainStringBuilder.append(classPath.substring(classPath.lastIndexOf(".") + 1));
            }

            if (!(passObj.isPass())) {
                //阻塞直接短路
                log.debug("消息解析结束,执行器链:{}", pluginChainStringBuilder.append(" -> block"));
                return;
            }
        }
        if (eventTypeEnum != null && !eventTypeEnum.equals(EventTypeEnum.META_EVENT_HEARTBEAT) && !eventTypeEnum.equals(EventTypeEnum.META_EVENT_LIFECYCLE)) {
            log.debug("消息解析结束,执行器链:{}", pluginChainStringBuilder.append(" -> block"));
        }
    }

}
