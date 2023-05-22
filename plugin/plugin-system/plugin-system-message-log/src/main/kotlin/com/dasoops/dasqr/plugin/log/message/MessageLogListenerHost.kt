package com.dasoops.dasqr.plugin.log.message

import com.dasoops.dasqr.core.listener.DasqrSimpleListenerHost
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.internalId
import org.slf4j.LoggerFactory

/**
 * 消息日志监听器主机
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/11
 * @see [MessageLogListenerHost]
 */
open class MessageLogListenerHost : DasqrSimpleListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)

    @EventHandler(EventPriority.HIGHEST)
    open fun handle(event: MessageEvent) {
        MessageLogDao.add(MessageLogDo {
            messageType = MessageType.getOrNull(event) ?: return
            senderId = event.sender.id
            if (event.sender is Member) {
                senderGroupId = (event.sender as Member).group.id
            }
            senderName = event.senderName
            dutyBotId = event.bot.id
            messageInternalId = event.message.internalId[0]
            message = event.message.toString()
            rawMessage = event.message.contentToString()
        })
    }
}