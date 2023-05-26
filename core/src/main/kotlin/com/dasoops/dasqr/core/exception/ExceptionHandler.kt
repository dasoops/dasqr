package com.dasoops.dasqr.core.exception

/**
 * 自定义异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
interface ExceptionHandler {
    /**
     * 处理异常
     * @param [context] 协程上下文
     * @param [exception] 异常
     */
    fun handle(exception: Throwable)
}