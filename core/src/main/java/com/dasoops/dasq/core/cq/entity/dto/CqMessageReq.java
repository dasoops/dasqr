package com.dasoops.dasq.core.cq.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CqMessageReq
 * @ClassPath com.dasoops.dasq.core.cq.entity.dto.CqMessageReq
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq消息请求
 */
@Data
public class CqMessageReq {

    @JSONField(name = "post_type")
    private String postType;

    @JSONField(name = "message_type")
    private String messageType;

    private Long time;

    @JSONField(name = "self_id")
    private Long selfId;

    @JSONField(name = "sub_type")
    private String subType;

    @JSONField(name = "raw_message")
    private String rawMessage;

    private Integer font;

    private Sender sender;

    @JSONField(name = "message_id")
    private Long messageId;

    @JSONField(name = "user_id")
    private Long userId;

    @JSONField(name = "target_id")
    private Long targetId;

    private String message;
}