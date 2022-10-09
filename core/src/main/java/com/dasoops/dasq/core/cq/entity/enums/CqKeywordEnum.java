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


    ;

    final String simpleName;
    final String humpName;

    CqKeywordEnum(String simpleName, String humpName) {
        this.simpleName = simpleName;
        this.humpName = humpName;
    }

    public String getHumpName() {
        return humpName;
    }

    public String getSimpleName() {
        return simpleName;
    }
}
