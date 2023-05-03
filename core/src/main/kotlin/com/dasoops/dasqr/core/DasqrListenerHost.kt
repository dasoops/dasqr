package com.dasoops.dasqr.core

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import net.mamoe.mirai.event.SimpleListenerHost
import org.slf4j.LoggerFactory
import kotlin.coroutines.CoroutineContext

/**
 * 一个包含异常处理程序的ListenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@IgnoreResourcesScan
abstract class DasqrListenerHost : SimpleListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        ExceptionHandlerPool.handle(context, exception)
    }
}