package com.dasoops.dasserver.cq.entity.dto.cq.event.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title CQGroupUploadNoticeEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.notice.CQGroupUploadNoticeEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 群文件上传
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
