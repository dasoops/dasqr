package com.dasoops.dasqr.plugin

import com.dasoops.dasqr.core.MyLauncher
import com.dasoops.dasqr.core.listener.DslListenerHost

/**
 * 插件Listenerhost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [PluginListenerHost]
 */
open class PluginListenerHost : DslListenerHost({
    group("load plugin jar") {
        case(it) quoteReply {
            if (MyLauncher.fromLauncher) {
                MyLauncher.loadPluginList.joinToString(separator = System.lineSeparator())
            } else {
                "unload from launcher"
            }
        }
    }
})