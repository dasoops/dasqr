package com.dasoops.dasqr.plugin

import net.mamoe.mirai.event.Event
import com.dasoops.dasqr.core.DasqrListenerHost
import net.mamoe.mirai.event.EventHandler
import org.slf4j.LoggerFactory

/**
 * listener host example
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-30
 */
object ExampleListenAerHost : DasqrListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)

    @EventHandler
    fun throwException(event: Event) {
        log.info("ExampleListAAaenerHosAAAt")
    }
}