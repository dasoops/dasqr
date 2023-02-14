package com.dasoops.dasserver.cq.entity.dto.cq.event.message;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CQDiscussMessageEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.message.CQDiscussMessageEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 讨论组消息
 * @see CqMessageEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqDiscussMessageEvent extends CqMessageEvent {
    /**
     * 讨论组 ID
     */
    @JSONField(name = "discuss_id")
    private long discussId;
    /**
     * 发送人信息
     */
    @JSONField(name = "sender")
    private CqUser sender;
}
