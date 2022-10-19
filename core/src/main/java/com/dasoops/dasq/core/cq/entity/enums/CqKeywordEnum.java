package com.dasoops.dasq.core.cq.entity.enums;

/**
 * @Title: CqKeywordEnum
 * @ClassPath com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: cq关键词枚举
 * @see Enum
 */
public enum CqKeywordEnum {

    /**
     * 启用
     */
    ENABLE("enable", "1"),

    /**
     * 禁用
     */
    DISABLE("disable", "0"),

    /**
     * cq消息类型
     */
    MESSAGE_TYPE("messageType", "message_type"),

    /**
     * 事件信息
     */
    EVENT_INFO("eventInfo", "event_info"),
    /**
     * 消息类型
     */
    POST_TYPE("postType", "post_type"),

    /**
     * 群聊消息
     */
    MESSAGE_TYPE_GROUP("group", "0"),

    /**
     * 私聊消息
     */
    MESSAGE_TYPE_PRIVATE("private", "1"),

    /**
     * 消息类型消息后缀
     */
    MESSAGE_TYPE_MESSAGE_PREFIX("messageTypeMessagePrefix", "3"),

    /**
     * 群聊id
     */
    GROUP_ID("groupId", "group_id"),

    /**
     * 私聊id
     */
    USER_ID("userId", "user_id"),

    /**
     * 消息
     */
    MESSAGE("message", "message"),

    /**
     * 分隔符
     */
    URL_SEPARATOR("/", "/"),

    /**
     * 发送私聊消息
     */
    SEND_PRIVATE_MSG("sendPrivateMsg", "send_private_msg"),

    /**
     * 发送群聊消息
     */
    SEND_GROUP_MSG("sendGroupMsg", "send_group_msg"),

    /**
     * URL传参前缀
     */
    URL_PARAMETER_PREFIX("?", "?"),

    /**
     * URL传参前缀
     */
    URL_PARAMETER_SEPARATOR("&", "&"),

    /**
     * url参数键值分隔符
     */
    URL_PARAMETER_KEY_VALUE_SEPARATOR("=", "="),

    /**
     * url参数值前缀
     */
    URL_PARAMETER_VALUE_PREFIX("{", "{"),

    /**
     * url参数值后缀
     */
    URL_PARAMETER_VALUE_SUFFIX("}", "}"),

    /**
     * cq res data
     */
    CQ_RES_DATA("data", "data"),

    /**
     * cq res message id
     */
    CQ_RES_MESSAGE_ID("messageId", "message_id"),

    /**
     * cq res failed
     */
    CQ_RES_STATUS_FAILED("failed", "failed"),

    /**
     * cq res ok
     */
    CQ_RES_STATUS_OK("ok", "ok"),

    COMMON_PREFIX(".", "."),

    /**
     * 得到消息
     */
    GET_MESSAGE("getMsg", "get_msg"),

    ;

    final String simpleName;
    final String otherName;

    CqKeywordEnum(String simpleName, String otherName) {
        this.simpleName = simpleName;
        this.otherName = otherName;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getSimpleName() {
        return simpleName;
    }
}
