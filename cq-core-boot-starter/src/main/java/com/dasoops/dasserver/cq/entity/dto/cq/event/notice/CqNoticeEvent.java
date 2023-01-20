package com.dasoops.dasserver.cq.entity.dto.cq.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.event.CqEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQNoticeEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.notice.CQNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cqnotice事件
 * @see CqEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqNoticeEvent extends CqEvent {
    /**
     * 通知类型
     */
    @JSONField(name = "notice_type")
    private String noticeType;
    /**
     * 上传文件者QQ
     * 被任命管理员QQ
     * 进群/离开者QQ
     * 被禁言QQ
     * 新添加好友 QQ 号
     */
    @JSONField(name = "user_id")
    private long userId;
}
