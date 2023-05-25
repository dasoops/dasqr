package com.dasoops.dasqr.plugin

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.dasqr.core.listener.DslListenerHost
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.at
import net.mamoe.mirai.message.data.firstIsInstance

open class TestListenerHost : DslListenerHost({
    group("test") {
        "throw" {
            throw SimpleProjectExceptionEntity("test exception")
        }
    }
})