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
    MESSAGE_TYPE("messageType"),

    /**
     * 事件信息
     */
    EVENT_INFO("eventInfo"),
    ;

    final String simpleName;

    CqKeywordEnum(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleName() {
        return simpleName;
    }
}
