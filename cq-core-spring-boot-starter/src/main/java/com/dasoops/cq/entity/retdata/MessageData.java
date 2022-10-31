package com.dasoops.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: MessageData
 * @ClassPath com.dasoops.cq.entity.retdata.MessageData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 消息数据
 */
@Data
public class MessageData {
    @JSONField(name = "message_id")
    private int messageId;
}
