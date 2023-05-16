package com.dasoops.dasqr.core.listener

import com.dasoops.dasqr.core.config.Config

/**
 * 配置监听器主机
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [ConfigListenerHost]
 */
open class ConfigListenerHost : DslListenerHost({
    group("refreshConfig") {
        case("refresh config") quoteReply {
            Config.INSTANCE.init()
            "ok"
        }
    }
})