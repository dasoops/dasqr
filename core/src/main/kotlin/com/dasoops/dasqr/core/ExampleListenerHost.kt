package com.dasoops.dasqr.core

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventHandler
import org.slf4j.LoggerFactory

/**
 * listener host example
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-30
 */
object ExampleListenerHost : DasqrListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)

    @EventHandler
    fun throwException(event: Event) {
        log.info("ExampleListenerHost")
    }
}