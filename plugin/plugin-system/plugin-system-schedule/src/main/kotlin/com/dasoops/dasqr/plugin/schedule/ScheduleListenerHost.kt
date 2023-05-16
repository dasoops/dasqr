package com.dasoops.dasqr.plugin.schedule

import com.dasoops.dasqr.core.listener.DslListenerHost

/**
 * 定时器Listenerhost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [ScheduleListenerHost]
 */
open class ScheduleListenerHost : DslListenerHost({
    group("refresh schedule") {
        case("refresh schedule") quoteReply {
            ScheduleRunner.init()
            "ok"
        }
    }
})