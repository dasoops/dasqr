package com.dasoops.cq.entity.event.request;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqGroupRequestEvent
 * @ClassPath com.dasoops.cq.entity.event.request.CqGroupRequestEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 加群请求／邀请
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
