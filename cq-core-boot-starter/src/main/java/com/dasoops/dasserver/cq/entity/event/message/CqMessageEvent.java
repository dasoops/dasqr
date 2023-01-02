package com.dasoops.dasserver.cq.entity.event.message;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.event.CqEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqMessageEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq消息事件
 * @see CqEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqMessageEvent extends CqEvent {
    /**
     * 消息类型
     */
    @JSONField(name = "message_type")
    private String messageType;
    /**
     * 消息 ID
     */
    @JSONField(name = "message_id")
    private int messageId;
    /**
     * 发送者 QQ 号
     */
    @JSONField(name = "user_id")
    private long userId;
    /**
     * 消息内容
     */
    @JSONField(name = "message")
    private String message;
    /**
     * 原始消息内容
     */
    @JSONField(name = "raw_message")
    private String rawMessage;
    /**
     * 字体
     */
    @JSONField(name = "font")
    private int font;
}