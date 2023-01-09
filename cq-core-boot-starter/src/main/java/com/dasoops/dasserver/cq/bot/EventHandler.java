package com.dasoops.dasserver.cq.bot;

import cn.hutool.core.util.EnumUtil;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.*;
import com.dasoops.dasserver.cq.entity.enums.CqEventColumnEnum;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PostTypeEnum;
import com.dasoops.dasserver.cq.entity.event.CqEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqDiscussMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqLifecycleMetaEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqMetaEvent;
import com.dasoops.dasserver.cq.entity.event.notice.*;
import com.dasoops.dasserver.cq.entity.event.request.CqFriendRequestEvent;
import com.dasoops.dasserver.cq.entity.event.request.CqGroupRequestEvent;
import com.dasoops.dasserver.cq.wrapper.AuthWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * @Title: EventHandler
 * @ClassPath com.dasoops.dasserver.cq.bot.EventHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 事件处理器
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
        try {
            EventUtil.set(eventJson);
            CqGlobal.setThreadLocal(cqTemplate);

            String postType = eventJson.getString(CqEventColumnEnum.POST_TYPE.getKey());
            PostTypeEnum postTypeEnum = EnumUtil.getBy(PostTypeEnum::getKey, postType);
            String eventType;
            //心跳的messageType键不一样
            switch (postTypeEnum) {
                case MESSAGE, MESSAGE_SENT -> eventType = eventJson.getString(CqEventColumnEnum.MESSAGE_TYPE.getKey());
                case NOTICE -> eventType = eventJson.getString(CqEventColumnEnum.NOTICE_TYPE.getKey());
                case REQUEST -> eventType = eventJson.getString(CqEventColumnEnum.REQUEST_TYPE.getKey());
                case META_EVENT -> eventType = eventJson.getString(CqEventColumnEnum.MESSAGE_EVENT_TYPE.getKey());
                default -> throw new LogicException(CqExceptionEnum.UNKNOWN_POST_TYPE);
            }
            EventTypeEnum eventTypeEnum = EnumUtil.getBy(EventTypeEnum::getKey, eventType);

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
                default -> log.error("not found reslove method({}:{})", postType, eventType);
            }
        } finally {
            EventUtil.remove();
            CqGlobal.removeThreadLocal();
        }
    }

    /**
     * 处理消息的function接口,提供给上面的匿名内部类使用
     */
    public interface HandleFunction {
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
            return authWrapperList.stream().allMatch(authWrapper -> authWrapper.auth(cqPlugin.getClass().getName()));
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
    public void handleMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqEvent> clazz, HandleFunction func) {
        handleMessage(cqTemplate, eventJson, clazz, func, true);
    }

    /**
     * 处理元事件(无需身份验证)
     *
     * @param cqTemplate cqTemplate
     * @param eventJson  事件json对象
     * @param clazz      clazz
     */
    public void handleMetaEvent(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqMetaEvent> clazz, HandleFunction func) {
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
    public void handleMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqEvent> clazz, HandleFunction defaultFunction, boolean mustAuth) {
        handleResloveMessage(cqTemplate, eventJson, clazz, defaultFunction, mustAuth, null, null);
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
    public void handleResloveMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqMessageEvent> clazz, HandleFunction defaultFunction, String defaultMethodName, EventTypeEnum eventTypeEnum) {
        handleResloveMessage(cqTemplate, eventJson, clazz, defaultFunction, true, defaultMethodName, eventTypeEnum);
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
    public void handleResloveMessage(CqTemplate cqTemplate, JSONObject eventJson, Class<? extends CqEvent> clazz, HandleFunction defaultFunction, boolean mustAuth, String defaultMethodName, EventTypeEnum eventTypeEnum) {
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
                    //没有解析,说明不符合，调用默认的
                    passObj = defaultFunction.handle(cqPlugin, cqTemplate, clazz.cast(passObj.getEvent()));
                }
            } else {
                //不需要解析,直接调用,gogogo
                passObj = defaultFunction.handle(cqPlugin, cqTemplate, clazz.cast(passObj.getEvent()));
            }
            if (log.isDebugEnabled()) {
                if (pluginChainStringBuilder.length() > 0) {
                    pluginChainStringBuilder.append(" -> ");
                }
                pluginChainStringBuilder.append(cqPlugin.getClass().getSimpleName());
            }

            if (!(passObj.isPass())) {
                //阻塞直接短路
                log.debug("消息解析结束,执行器链:{}", pluginChainStringBuilder.append("-> block"));
                return;
            }
        }
    }

}
