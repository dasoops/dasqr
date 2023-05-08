package com.dasoops.dasqr.plugin.log.message

import cn.hutool.extra.spring.SpringUtil
import com.dasoops.dasqr.core.DasqrListenerHost
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.message.data.internalId
import org.slf4j.LoggerFactory

object MessageLogListenerHost : DasqrListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)
    private val messageLogDao = SpringUtil.getBean(MessageLogDao::class.java)

    @EventHandler(EventPriority.HIGHEST)
    fun handle(event: MessageEvent) {
        messageLogDao.add(MessageLog {
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