package com.dasoops.dasqr.plugin.config

import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder

/**
 * 缓存listener host
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [CacheListenerHost]
 */
open class CacheListenerHost : DslListenerHost() {
    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("refresh cache") {
            case(it) quoteReply {
                Cache.clear()
                "ok"
            }
        }
    }
}