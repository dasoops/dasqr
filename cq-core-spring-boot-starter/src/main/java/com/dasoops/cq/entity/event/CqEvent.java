package com.dasoops.cq.entity.event;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CqEvent
 * @ClassPath com.dasoops.cq.entity.event.CqEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 事件上报
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
