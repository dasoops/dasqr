package com.dasoops.dasserver.cq.bot;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.event.message.CqDiscussMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqLifecycleMetaEvent;
import com.dasoops.dasserver.cq.entity.event.notice.*;
import com.dasoops.dasserver.cq.entity.event.request.CqFriendRequestEvent;
import com.dasoops.dasserver.cq.entity.event.request.CqGroupRequestEvent;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.utils.CqAssert;
import com.dasoops.dasserver.cq.utils.EventUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.Optional;


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

    private final ApplicationContext applicationContext;

    //    private final CqPlugin defaultPlugin = new CqPlugin();
    private final AuthWrapper authWrapper;

    public EventHandler(ApplicationContext applicationContext, AuthWrapper authWrapper) {
        this.applicationContext = applicationContext;
        this.authWrapper = authWrapper;
    }

    /**
     * 消息处理
     *
     * @param cq        cq
     * @param eventJson 事件json
     */
    public void handle(CqTemplate cq, JSONObject eventJson) {
        EventUtil.set(eventJson);

        String postType = eventJson.getString("post_type");
        switch (postType) {
            case "message": {
                handleMessage(cq, eventJson);
                break;
            }
            case "notice": {
                handleNotice(cq, eventJson);
                break;
            }
            case "request": {
                handleRequest(cq, eventJson);
                break;
            }
            case "meta_event": {
                handleMeta(cq, eventJson);
                break;
            }
            default:
                break;
        }
    }

    private void handleMessage(CqTemplate cq, JSONObject eventJson) {
        String messageType = eventJson.getString("message_type");
        PassObj passObj;
        switch (messageType) {
            case "private": {
                var event = eventJson.to(CqPrivateMessageEvent.class);
                //初始化值,存入参数
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    //无权限返回为空,判断直接进入下一个
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    //非阻塞赋值,后续调用使用改对象的参数
                    passObj = authPluginOpt.get().onPrivateMessage(cq, (CqPrivateMessageEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        //阻塞直接break
                        break;
                    }
                }
                break;
            }

            case "group": {
                var event = eventJson.to(CqGroupMessageEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupMessage(cq, (CqGroupMessageEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "discuss": {
                var event = eventJson.to(CqDiscussMessageEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onDiscussMessage(cq, (CqDiscussMessageEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            default:
                break;
        }

    }

    private void handleNotice(CqTemplate cq, JSONObject eventJson) {

        String noticeType = eventJson.getString("notice_type");
        PassObj passObj;

        switch (noticeType) {
            case "group_upload": {
                var event = eventJson.to(CqGroupUploadNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupUploadNotice(cq, (CqGroupUploadNoticeEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "group_admin": {
                var event = eventJson.to(CqGroupAdminNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupAdminNotice(cq, (CqGroupAdminNoticeEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "group_decrease": {
                var event = eventJson.to(CqGroupDecreaseNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupDecreaseNotice(cq, (CqGroupDecreaseNoticeEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "group_increase": {
                var event = eventJson.to(CqGroupIncreaseNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupIncreaseNotice(cq, (CqGroupIncreaseNoticeEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "group_ban": {
                var event = eventJson.to(CqGroupBanNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupBanNotice(cq, (CqGroupBanNoticeEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "friend_add": {
                var event = eventJson.to(CqFriendAddNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onFriendAddNotice(cq, (CqFriendAddNoticeEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            default:
                break;
        }


    }

    private void handleRequest(CqTemplate cq, JSONObject eventJson) {

        String requestType = eventJson.getString("request_type");
        PassObj passObj;

        switch (requestType) {
            case "friend": {
                var event = eventJson.to(CqFriendRequestEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onFriendRequest(cq, (CqFriendRequestEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "group": {
                var event = eventJson.to(CqGroupRequestEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getAuthPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onGroupRequest(cq, (CqGroupRequestEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            default:
                break;
        }
    }

    private void handleMeta(CqTemplate cq, JSONObject eventJson) {

        String metaType = eventJson.getString("meta_event_type");
        PassObj passObj;

        switch (metaType) {
            case "heartbeat": {
                var event = eventJson.to(CqHeartBeatMetaEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onHeartBeatMeta(cq, (CqHeartBeatMetaEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            case "lifecycle": {
                passObj = PassObj.pass(eventJson.to(CqLifecycleMetaEvent.class));
                for (var pluginClass : cq.getPluginList()) {
                    Optional<CqPlugin> authPluginOpt = getPlugin(pluginClass);
                    if (authPluginOpt.isEmpty()) {
                        continue;
                    }
                    passObj = authPluginOpt.get().onLifecycleMeta(cq, (CqLifecycleMetaEvent) passObj.getEvent());
                    if (!(passObj.isPass())) {
                        break;
                    }
                }
                break;
            }
            default:
                break;
        }
    }


    /**
     * 获取可用插件
     *
     * @param pluginClass plugin类
     * @return {@link CqPlugin}
     */
    private Optional<CqPlugin> getAuthPlugin(Class<? extends CqPlugin> pluginClass) {
        if (authWrapper != null) {
            if (!authWrapper.auth(pluginClass.getName())) {
                return Optional.empty();
            }
        }

        return getPlugin(pluginClass);
    }

    /**
     * 获取可用插件
     *
     * @param pluginClass plugin类
     * @return {@link CqPlugin}
     */
    private Optional<CqPlugin> getPlugin(Class<? extends CqPlugin> pluginClass) {
        try {
            return Optional.of(applicationContext.getBean(pluginClass));
        } catch (Exception e) {
            CqAssert.ifNotNullOrElse(pluginClass, () -> {
                throw new CqLogicException(ExceptionEnum.PLUGIN_NOT_FOUNT, pluginClass.getName());
            }, () -> {
                throw new CqLogicException(ExceptionEnum.PLUGIN_NOT_FOUNT);
            });
            return Optional.empty();
        }
    }
}
