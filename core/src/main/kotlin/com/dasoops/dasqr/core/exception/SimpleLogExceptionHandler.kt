package com.dasoops.dasqr.core.exception

import org.slf4j.LoggerFactory
import kotlin.coroutines.CoroutineContext

/**
 * 简单打个日志的异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object SimpleLogExceptionHandler : ExceptionHandler {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        log.error("coroutineContext handle exception: ", exception)
    }
}