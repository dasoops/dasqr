package com.dasoops.dasqr.core.plugin

import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import com.dasoops.dasqr.core.loader.DasqrRunner

/**
 * 插件Listenerhost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [PluginListenerHost]
 */
open class PluginListenerHost : DslListenerHost() {
    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("load plugin jar") {
            case(it) quoteReply {
                if (DasqrRunner.load) {
                    DasqrRunner.loadPluginList.joinToString(separator = System.lineSeparator())
                } else {
                    "unload from launcher"
                }
            }
        }
    }
}