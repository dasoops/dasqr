package com.dasoops.dasqr.plugin.log.message

import com.dasoops.dasqr.core.DasqrListenerHost
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.events.GroupMessageEvent
import org.slf4j.LoggerFactory

open class ReplyListenerHost : DasqrListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)
    private val messageLogDao = ReplyDao.INSTANCE

    @EventHandler(EventPriority.LOW)
    suspend fun handle(event: GroupMessageEvent) {

    }
}