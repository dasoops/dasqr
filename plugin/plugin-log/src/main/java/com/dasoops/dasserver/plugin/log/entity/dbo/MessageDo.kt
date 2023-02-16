package com.dasoops.dasserver.plugin.log.entity.dbo

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId


/**
 * @title MessageDo
 * @classPath com.dasoops.dasserver.plugin.log.entity.dbo.MessageDo
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/31
 * @version 1.0.0
 * @description 消息对象
 * @see [MessageDo]
 */
@Document("message")
class MessageDo {

    @MongoId(targetType = FieldType.OBJECT_ID)
    var id: ObjectId? = null

    /**
     * 时间戳
     */
    var time: Long? = null

    /**
     * 事件类型
     */
    var postType: String? = null

    /**
     * 消息类型
     */
    var messageType: String? = null

    /**
     * 接收者id
     */
    var selfId: Long? = null

    /**
     * 消息id
     */
    var messageId: Long? = null

    /**
     * 群组id
     */
    var groupId: Long? = null

    /**
     * 用户id
     */
    var userId: Long? = null

    /**
     * 消息内容
     */
    var message: String? = null


}