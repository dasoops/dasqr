package com.dasoops.dasserver.cq.entity.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQGroupIncreaseNoticeEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.notice.CQGroupIncreaseNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 群成员增加
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupIncreaseNoticeEvent extends CqNoticeEvent {
    /**
     * 事件子类型
     * approve、invite分别表示管理员已同意入群、管理员邀请入群
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
}
