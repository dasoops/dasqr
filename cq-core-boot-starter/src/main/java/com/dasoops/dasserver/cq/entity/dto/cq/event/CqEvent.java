package com.dasoops.dasserver.cq.entity.dto.cq.event;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: CqEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.CqEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 事件上报
 */
@Data
public class CqEvent {
    /**
     * 上报类型
     */
    @JSONField(name = "post_type")
    private String postType;

    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time")
    private long time;

    /**
     * 收到消息的机器人 QQ 号
     */
    @JSONField(name = "self_id")
    private long selfId;
}
