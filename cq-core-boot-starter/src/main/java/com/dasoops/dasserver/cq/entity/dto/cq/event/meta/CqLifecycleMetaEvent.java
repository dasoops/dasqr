package com.dasoops.dasserver.cq.entity.dto.cq.event.meta;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CqLifecycleMetaEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.meta.CqLifecycleMetaEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 生命周期
 * @see CqMetaEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqLifecycleMetaEvent extends CqMetaEvent {
    /**
     * 事件子类型
     * enable、disable、connect分别表示插件启用、插件停用、WebSocket 连接成功
     */
    @JSONField(name = "sub_type")
    private String subType;
}
