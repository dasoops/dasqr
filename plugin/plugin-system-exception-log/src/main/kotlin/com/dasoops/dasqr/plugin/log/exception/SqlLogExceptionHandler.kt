package com.dasoops.dasqr.plugin.log.exception

import cn.hutool.core.exceptions.ExceptionUtil
import cn.hutool.extra.spring.SpringUtil
import com.dasoops.dasqr.core.exception.ExceptionHandler
import kotlin.coroutines.CoroutineContext

/**
 * sql日志异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-25
 */
object SqlLogExceptionHandler : ExceptionHandler {
    val dao: ExceptionLogDao = SpringUtil.getBean(ExceptionLogDao::class.java)

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        val rootCause = ExceptionUtil.getRootCause(exception)

        dao.add(
            ExceptionLog {
                stackInfo = exception.stackTraceToString()
                topMessage = rootCause.message ?: "no message"
                exceptionType = rootCause.javaClass.name
            }
        )
    }
}