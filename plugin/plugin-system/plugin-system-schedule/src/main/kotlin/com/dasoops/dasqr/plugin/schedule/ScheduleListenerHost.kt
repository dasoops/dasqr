package com.dasoops.dasqr.plugin.schedule

import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder

/**
 * 定时器Listenerhost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [ScheduleListenerHost]
 */
open class ScheduleListenerHost : DslListenerHost() {
    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("refresh schedule") {
            case("refresh schedule") quoteReply {
                ScheduleRunner.INSTANCE.init()
                "ok"
            }
        }
    }
}