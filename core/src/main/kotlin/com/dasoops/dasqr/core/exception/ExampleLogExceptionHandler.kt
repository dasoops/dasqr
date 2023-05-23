package com.dasoops.dasqr.core.exception

import cn.hutool.core.exceptions.ExceptionUtil
import org.slf4j.LoggerFactory

/**
 * 简单打个日志的异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object ExampleLogExceptionHandler : ExceptionHandler {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun handle(exception: Throwable) {
        log.error("coroutine exception handler catch exception: ", exception)
    }
}