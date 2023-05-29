package com.dasoops.dasqr.plugin

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.at
import net.mamoe.mirai.message.data.firstIsInstance

/**
 * 测试Listenerhost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/29
 * @see [TestListenerHost]
 */
open class TestListenerHost : DslListenerHost() {
    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("test") {
            "throw" {
                throw SimpleProjectExceptionEntity("test exception")
            }
        }
    }
}