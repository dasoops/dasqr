package com.dasoops.cq.entity.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQGroupBanNoticeEvent
 * @ClassPath com.dasoops.cq.entity.event.notice.CQGroupBanNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 群禁言
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupBanNoticeEvent extends CqNoticeEvent {
    /**
     * 事件子类型
     * ban、lift_ban分别表示禁言、解除禁言
     */
    @JSONField(name = "sub_type")
    private String subType;
    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private long groupId;
    /**
     * 操作者 QQ 号
     */
    @JSONField(name = "operator_id")
    private long operatorId;
    /**
     * 禁言时长
     * 单位秒
     */
    @JSONField(name = "duration")
    private long duration;
}
