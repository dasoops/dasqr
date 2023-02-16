package com.dasoops.dasserver.cq.entity.dto.cq.event.request;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title CqGroupRequestEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.request.CqGroupRequestEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 加群请求／邀请
 * @see CqRequestEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupRequestEvent extends CqRequestEvent {
    /**
     * 请求子类型，分别表示加群请求、邀请机器人入群
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private long groupId;
}
