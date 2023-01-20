package com.dasoops.dasserver.cq.entity.dto.cq.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqGroupDecreaseNoticeEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.notice.CqGroupDecreaseNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 群成员减少
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupDecreaseNoticeEvent extends CqNoticeEvent {
    /**
     * 事件子类型
     * leave、kick、kick_me分别表示主动退群、成员被踢、机器人自己被踢
     */
    @JSONField(name = "sub_type")
    private String subType;
    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private long groupId;
    /**
     * 操作者 QQ 号（如果是主动退群，则和 user_id 相同）
     */
    @JSONField(name = "operator_id")
    private long operatorId;
}
