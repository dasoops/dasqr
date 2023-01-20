package com.dasoops.dasserver.cq.entity.dto.cq.event.message;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQDiscussMessageEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.message.CQDiscussMessageEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 讨论组消息
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
