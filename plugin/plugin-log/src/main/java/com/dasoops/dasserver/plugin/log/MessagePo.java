package com.dasoops.dasserver.plugin.log;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @Title: MessagePo
 * @ClassPath com.dasoops.dasserver.plugin.log.MessagePo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 消息Po
 */
@Document("message")
@Data
public class MessagePo {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private ObjectId id;

    /**
     * 时间戳
     */
    private Long time;

    /**
     * 事件类型
     */
    private String postType;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 接收者id
     */
    private Long selfId;

    /**
     * 消息id
     */
    private Long messageId;

    /**
     * 群组id
     */
    private Long groupId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 消息内容
     */
    private String message;

}
