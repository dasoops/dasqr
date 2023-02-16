package com.dasoops.dasserver.cq.entity.dto.cq.event.meta;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.event.CqEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title CqMetaEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.meta.CqMetaEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description
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
