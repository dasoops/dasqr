package com.dasoops.dasserver.cq.entity.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqGroupAdminNoticeEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.notice.CqGroupAdminNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 群管理员变动
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupAdminNoticeEvent extends CqNoticeEvent {
    /**
     * 事件子类型
     * set unset分别表示设置和取消管理员
     */
    @JSONField(name = "sub_type")
    private String subType;
    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private long groupId;
}
