package com.dasoops.dasqr.core.config

import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder

/**
 * 配置监听器主机
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [ConfigListenerHost]
 */
open class ConfigListenerHost : DslListenerHost() {
    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("refreshConfig") {
            case("refresh config") quoteReply {
                Config.INSTANCE.init()
                "ok"
            }
        }
    }
}