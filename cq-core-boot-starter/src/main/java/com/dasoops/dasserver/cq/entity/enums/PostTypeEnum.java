package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: PostTypeEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.PostTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/05
 * @Version 1.0.0
 * @Description: 请求类型枚举
 */
@Getter
@AllArgsConstructor
public enum PostTypeEnum {

    /**
     * 消息
     */
    MESSAGE("message"),

    /**
     * 发送消息
     */
    MESSAGE_SENT("message_sent"),

    /**
     * 请求
     */
    REQUEST("request"),

    /**
     * 提醒
     */
    NOTICE("notice"),

    /**
     * 元事件
     */
    META_EVENT("meta_event"),

    /**
     * http请求
     */
    HTTP_REQUEST("httpRequest"),
    ;

    final String key;

}
