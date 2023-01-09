package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.entity.event.message.CqDiscussMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.dasserver.cq.entity.event.meta.CqLifecycleMetaEvent;
import com.dasoops.dasserver.cq.entity.event.notice.*;
import com.dasoops.dasserver.cq.entity.event.request.CqFriendRequestEvent;
import com.dasoops.dasserver.cq.entity.event.request.CqGroupRequestEvent;

/**
 * @Title: CqPlugin
 * @ClassPath com.dasoops.dasserver.cqTemplate.CqPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: cqTemplate插件, 提供消息接收功能拓展
 */
public class CqPlugin {

    /**
     * 收到私聊消息时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到群消息时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到讨论组消息时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onDiscussMessage(CqTemplate cqTemplate, CqDiscussMessageEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到bot发送私聊消息时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onBotSentPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到bot发送群消息时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onBotSentGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到bot发送讨论组消息时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onBotSentDiscussMessage(CqTemplate cqTemplate, CqDiscussMessageEvent event){
        return PassObj.pass(event);
    }

    /**
     * 群内有文件上传时调用此方法
     * 仅群文件上传表现为事件，好友发送文件在 酷Q 中没有独立的事件，而是直接表现为好友消息，请注意在编写业务逻辑时进行判断。
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupUploadNotice(CqTemplate cqTemplate, CqGroupUploadNoticeEvent event){
        return PassObj.pass(event);
    }

    /**
     * 群管理员变动时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupAdminNotice(CqTemplate cqTemplate, CqGroupAdminNoticeEvent event){
        return PassObj.pass(event);
    }

    /**
     * 群成员减少时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupDecreaseNotice(CqTemplate cqTemplate, CqGroupDecreaseNoticeEvent event){
        return PassObj.pass(event);
    }

    /**
     * 群成员增加时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupIncreaseNotice(CqTemplate cqTemplate, CqGroupIncreaseNoticeEvent event){
        return PassObj.pass(event);
    }

    /**
     * 群禁言时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupBanNotice(CqTemplate cqTemplate, CqGroupBanNoticeEvent event){
        return PassObj.pass(event);
    }

    /**
     * 好友添加时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onFriendAddNotice(CqTemplate cqTemplate, CqFriendAddNoticeEvent event){
        return PassObj.pass(event);
    }

    /**
     * 加好友请求时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onFriendRequest(CqTemplate cqTemplate, CqFriendRequestEvent event){
        return PassObj.pass(event);
    }

    /**
     * 加群请求/邀请时调用此方法
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onGroupRequest(CqTemplate cqTemplate, CqGroupRequestEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到心跳包时调用此方法
     * 心跳类型的元事件需要通过设置配置项 enable_heartbeat 为 true 开启，并可通过 heartbeat_interval 配置心跳间隔（单位毫秒）。
     *
     * @param cqTemplate 机器人对象
     * @param event      事件内容
     * @return 是否继续处理下一个插件, PassObj.block()表示不继续,PassObj.pass(event)表示继续
     */
    public PassObj onHeartBeatMeta(CqTemplate cqTemplate, CqHeartBeatMetaEvent event){
        return PassObj.pass(event);
    }

    /**
     * 收到生命周期消息
     *
     * @param cqTemplate cq模板
     * @param event      事件
     * @return {@link PassObj}
     */
    public PassObj onLifecycleMeta(CqTemplate cqTemplate, CqLifecycleMetaEvent event){
        return PassObj.pass(event);
    }
}
