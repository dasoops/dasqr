package com.dasoops.cq.entity.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.cq.entity.entity.CqFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CQGroupUploadNoticeEvent
 * @ClassPath com.dasoops.cq.entity.event.notice.CQGroupUploadNoticeEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 群文件上传
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupUploadNoticeEvent extends CqNoticeEvent {
    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private long groupId;
    /**
     * 文件信息
     */
    @JSONField(name = "file")
    private CqFile file;
}
