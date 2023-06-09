package com.dasoops.dasqr.plugin.log.exception

import cn.hutool.core.exceptions.ExceptionUtil
import com.dasoops.dasqr.core.exception.ExceptionHandler

/**
 * sql日志异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-25
 */
open class SqlLogExceptionHandler : ExceptionHandler {

    override fun handle(exception: Throwable) {
        val rootCause = ExceptionUtil.getRootCause(exception)
        ExceptionLogDao.add(
            ExceptionLogDo {
                stackInfo = exception.stackTraceToString()
                topMessage = rootCause.message ?: "no message"
                exceptionType = rootCause.javaClass.name
            }
        )
    }
}