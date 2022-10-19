package com.dasoops.dasq.core.dq.methodstrategy.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasq.core.cq.entity.dto.Sender;
import lombok.Data;

@Data
public class MsgData {
    private boolean group;
    @JSONField(name = "group_id")
    private int groupId;
    private String message;
    @JSONField(name = "message_id")
    private int messageId;
    @JSONField(name = "message_id_v2")
    private String messageIdV2;
    @JSONField(name = "message_seq")
    private int messageSeq;
    @JSONField(name = "message_type")
    private String messageType;
    @JSONField(name = "real_id")
    private int realId;
    private Sender sender;
    private int time;
}