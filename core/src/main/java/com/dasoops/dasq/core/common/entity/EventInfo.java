package com.dasoops.dasq.core.common.entity;

import lombok.Data;

/**
 * @Title: AuthorInfo
 * @ClassPath com.dasoops.dasq.core.common.interceptor.AuthorInfo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 作者信息
 */
@Data
public class EventInfo {

    /**
     * 事件时间戳
     */
    private Long time;

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 作者群id
     */
    private Long groupId;

    /**
     * 消息类型(0:群组;1:用户;2:消息类型;-1:未知)
     */
    private Integer messageType;

}
