package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: MessageData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.MessageData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 消息数据
 */
@Data
public class MessageData {
    @JSONField(name = "message_id")
    private int messageId;
}
