package com.dasoops.dasserver.cq.entity.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQGroupUploadNoticeEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.notice.CQGroupUploadNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 群文件上传
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqFriendRecallNoticeEvent extends CqNoticeEvent {
    /**
     * 被撤回的消息 ID
     */
    @JSONField(name = "message_id")
    private long messageId;
}
