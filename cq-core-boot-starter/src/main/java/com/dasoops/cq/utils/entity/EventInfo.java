package com.dasoops.cq.utils.entity;

import lombok.Data;

/**
 * @Title: MessageInfo
 * @ClassPath com.dasoops.cq.utils.entity.MessageInfo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 消息详情
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

}
