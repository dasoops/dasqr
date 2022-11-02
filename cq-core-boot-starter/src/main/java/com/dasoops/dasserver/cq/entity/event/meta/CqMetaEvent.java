package com.dasoops.dasserver.cq.entity.event.meta;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.event.CqEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqMetaEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.meta.CqMetaEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description:
 * @see CqEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqMetaEvent extends CqEvent {
    /**
     * heartbeat	元事件类型
     */
    @JSONField(name = "meta_event_type")
    private String metaEventType;
}
