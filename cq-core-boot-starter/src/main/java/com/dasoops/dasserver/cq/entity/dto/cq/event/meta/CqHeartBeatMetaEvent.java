package com.dasoops.dasserver.cq.entity.dto.cq.event.meta;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQHeartBeatMetaEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.meta.CQHeartBeatMetaEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 心跳
 * @see CqMetaEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqHeartBeatMetaEvent extends CqMetaEvent {
    /**
     * 状态信息
     */
    @JSONField(name = "status")
    private CqStatus status;

    /**
     * 到下次心跳的间隔，单位毫秒
     */
    @JSONField(name = "interval")
    private Long interval;
}
