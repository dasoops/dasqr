package com.dasoops.dasqr.core.exception

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import kotlin.coroutines.CoroutineContext

/**
 * 自定义异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@IgnoreResourcesScan
interface ExceptionHandler {
    /**
     * 处理异常
     * @param [context] 协程上下文
     * @param [exception] 异常
     */
    fun handleException(context: CoroutineContext, exception: Throwable)
}