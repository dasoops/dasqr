package com.dasoops.dasqr.plugin.log.message

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.varchar

/**
 * 消息日志Dao
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object MessageLogDao : BaseDao<MessageLogDo, MessageLogs>(MessageLogs)

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object MessageLogs : DasTable<MessageLogDo>("core_message_log") {
    val senderId = long("sender_id").bindTo { it.senderId }
    val senderGroupId = long("sender_group_id").bindTo { it.senderGroupId }
    val senderName = varchar("sender_name").bindTo { it.senderName }
    val dutyBotId = long("duty_bot_id").bindTo { it.dutyBotId }
    val messageId = int("message_mirai_internal_id").bindTo { it.messageInternalId }
    val message = varchar("message").bindTo { it.message }
    val rawMessage = varchar("raw_message").bindTo { it.rawMessage }
    val messageType = dataEnum<MessageType>("message_type").bindTo { it.messageType }
}

interface MessageLogDo : DasEntity<MessageLogDo> {
    /**
     * 发送人QQ
     */
    var senderId: Long

    /**
     * 发送人所在群QQ(无则为)
     */
    var senderGroupId: Long

    /**
     * 异常类型
     */
    var senderName: String

    /**
     * 值守botQQ
     */
    var dutyBotId: Long

    /**
     * 消息id
     */
    var messageInternalId: Int

    /**
     * 消息
     */
    var message: String

    /**
     * 原始消息
     */
    var rawMessage: String

    /**
     * 类型
     */
    var messageType: MessageType

    companion object : DasEntity.Factory<MessageLogDo>()
}