package com.dasoops.dasserver.cq.entity.dto.cq.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CQGroupBanNoticeEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.notice.CQGroupBanNoticeEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 群禁言
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
