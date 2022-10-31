package com.dasoops.cq.entity.event.meta;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqLifecycleMetaEvent
 * @ClassPath com.dasoops.cq.entity.event.meta.CqLifecycleMetaEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 生命周期
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
