package com.dasoops.cq.bot;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.core.util.Assert;
import com.dasoops.cq.CqPlugin;
import com.dasoops.cq.entity.event.message.CqDiscussMessageEvent;
import com.dasoops.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.cq.entity.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.cq.entity.event.meta.CqLifecycleMetaEvent;
import com.dasoops.cq.entity.event.notice.*;
import com.dasoops.cq.entity.event.request.CqFriendRequestEvent;
import com.dasoops.cq.entity.event.request.CqGroupRequestEvent;
import com.dasoops.cq.utils.EventUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;


/**
 * @Title: EventHandler
 * @ClassPath com.dasoops.cq.bot.EventHandler
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

    private final CqPlugin defaultPlugin = new CqPlugin();

    public EventHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 消息处理
     *
     * @param cq        cq
     * @param eventJson 事件json
     */
    public void handle(CqTemplate cq, JSONObject eventJson) {
        EventUtil.set(eventJson);
        Assert.allNotNull(cq.getPluginList());

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
                    //非阻塞赋值,后续调用使用改对象的参数
                    if (!(passObj = getPlugin(pluginClass).onPrivateMessage(cq, (CqPrivateMessageEvent) passObj.getParam().orElse(null))).isPass()) {
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
                    if (!(passObj = getPlugin(pluginClass).onGroupMessage(cq, (CqGroupMessageEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "discuss": {
                var event = eventJson.to(CqDiscussMessageEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onDiscussMessage(cq, (CqDiscussMessageEvent) passObj.getParam().orElse(null))).isPass()) {
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
                    if (!(passObj = getPlugin(pluginClass).onGroupUploadNotice(cq, (CqGroupUploadNoticeEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "group_admin": {
                var event = eventJson.to(CqGroupAdminNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onGroupAdminNotice(cq, (CqGroupAdminNoticeEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "group_decrease": {
                var event = eventJson.to(CqGroupDecreaseNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onGroupDecreaseNotice(cq, (CqGroupDecreaseNoticeEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "group_increase": {
                var event = eventJson.to(CqGroupIncreaseNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onGroupIncreaseNotice(cq, (CqGroupIncreaseNoticeEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "group_ban": {
                var event = eventJson.to(CqGroupBanNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onGroupBanNotice(cq, (CqGroupBanNoticeEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "friend_add": {
                var event = eventJson.to(CqFriendAddNoticeEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onFriendAddNotice(cq, (CqFriendAddNoticeEvent) passObj.getParam().orElse(null))).isPass()) {
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
                    if (!(passObj = getPlugin(pluginClass).onFriendRequest(cq, (CqFriendRequestEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "group": {
                var event = eventJson.to(CqGroupRequestEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onGroupRequest(cq, (CqGroupRequestEvent) passObj.getParam().orElse(null))).isPass()) {
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
                    if (!(passObj = getPlugin(pluginClass).onHeartBeatMeta(cq, (CqHeartBeatMetaEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            case "lifecycle": {
                var event = eventJson.to(CqLifecycleMetaEvent.class);
                passObj = PassObj.pass(event);
                for (var pluginClass : cq.getPluginList()) {
                    if (!(passObj = getPlugin(pluginClass).onLifecycleMeta(cq, (CqLifecycleMetaEvent) passObj.getParam().orElse(null))).isPass()) {
                        break;
                    }
                }
                break;
            }
            default:
                break;
        }
    }

    private CqPlugin getPlugin(Class<? extends CqPlugin> pluginClass) {
        try {
            return applicationContext.getBean(pluginClass);
        } catch (Exception e) {
            log.error("已跳过 {} ，请检查 @Component", pluginClass.getSimpleName());
            return defaultPlugin;
        }
    }
}
