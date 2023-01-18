package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: MessageTypeEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.MessageTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/05
 * @Version 1.0.0
 * @Description: 消息类型枚举
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum EventTypeEnum {

    /**
     * 私聊消息
     */
    MESSAGE_PRIVATE("private"),
    /**
     * 群组消息
     */
    MESSAGE_GROUP("group"),
    /**
     * 讨论组消息
     */
    MESSAGE_DISCUSS("discuss"),
    /**
     * bot发送私聊消息
     */
    MESSAGE_SENT_PRIVATE("private"),
    /**
     * bot发送群组消息
     */
    MESSAGE_SENT_GROUP("group"),
    /**
     * bot发送讨论组消息
     */
    MESSAGE_SENT_DISCUSS("discuss"),
    /**
     * 群内文件上传
     */
    NOTICE_GROUP_UPLOAD("group_upload"),
    /**
     * 群消息撤回
     */
    NOTICE_GROUP_RECALL("group_recall"),
    /**
     * 群管理员变动
     */
    NOTICE_GROUP_ADMIN("group_admin"),
    /**
     * 群成员减少
     */
    NOTICE_GROUP_DECREASE("group_decrease"),
    /**
     * 群成员增加
     */
    NOTICE_GROUP_INCREASE("group_increase"),
    /**
     * 群禁言
     */
    NOTICE_GROUP_BAN("group_ban"),
    /**
     * 好友添加
     */
    NOTICE_FRIEND_ADD("friend_add"),
    /**
     * 私聊消息撤回
     */
    NOTICE_FRIEND_RECALL("friend_recall"),
    /**
     * 加好友请求
     */
    REQUEST_FRIEND("friend"),
    /**
     * 加群请求/邀请
     */
    REQUEST_GROUP("group"),
    /**
     * 收到心跳包
     */
    META_EVENT_HEARTBEAT("heartbeat"),
    /**
     * 收到生命周期消息
     */
    META_EVENT_LIFECYCLE("lifecycle"),
    /**
     * http请求
     */
    HTTP_REQUEST("httpRequest"),
    /**
     * 群成员名片更新
     */
    NOTICE_GROUP_CARD("group_card");

    final String key;

}
