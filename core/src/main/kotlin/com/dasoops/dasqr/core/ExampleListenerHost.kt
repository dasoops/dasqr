package com.dasoops.dasqr.core

import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.events.MessageEvent
import org.slf4j.LoggerFactory

/**
 * listener host example
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-30
 */
object ExampleListenerHost : DasqrListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)

    @EventHandler(EventPriority.HIGHEST)
    fun log(event: MessageEvent) {
        log.info("onMessage: " + event.message.toString())
    }
}