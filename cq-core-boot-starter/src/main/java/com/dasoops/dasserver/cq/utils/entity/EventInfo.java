package com.dasoops.dasserver.cq.utils.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: MessageInfo
 * @ClassPath com.dasoops.dasserver.cq.utils.entity.MessageInfo
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
    @JSONField(name = "time")
    private Long time;

    /**
     * 消息id
     */
    @JSONField(name = "message_id")
    private String messageId;

    /**
     * 作者id
     */
    @JSONField(name = "author_id")
    private Long authorId;

    /**
     * 作者群id
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 上报类型
     */
    @JSONField(name = "post_type")
    private String postType;

    /**
     * 消息类型
     */
    @JSONField(name = "message_type")
    private String messageType;
}
