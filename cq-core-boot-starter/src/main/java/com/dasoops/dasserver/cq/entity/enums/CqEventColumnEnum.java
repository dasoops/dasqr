package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: CqColumn
 * @classPath com.dasoops.dasserver.cq.entity.enums.CqColumn
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/05
 * @version 1.0.0
 * @description cq消息字段
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum CqEventColumnEnum {

    /**
     * 该上报的类型
     */
    POST_TYPE("post_type"),

    /**
     * 消息类型
     */
    MESSAGE_TYPE("message_type"),

    /**
     * 元事件类型
     */
    MESSAGE_EVENT_TYPE("meta_event_type"),
    /**
     * 请求类型
     */
    REQUEST_TYPE("request_type"),
    /**
     * 通知类型
     */
    NOTICE_TYPE("notice_type"),
    /**
     * 用户id
     */
    USER_ID("user_id"),

    ;

    final String key;
}
