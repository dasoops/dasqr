package com.dasoops.dasqr.plugin

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.dasqr.core.listener.DslListenerHost

open class TestListenerHost : DslListenerHost({
    group("test") {
        "throw" {
            throw SimpleProjectExceptionEntity("test exception")
        }
    }
})