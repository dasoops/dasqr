package com.dasoops.dasqr.core.exception

import cn.hutool.core.exceptions.ExceptionUtil
import cn.hutool.extra.spring.SpringUtil
import com.dasoops.dasqr.core.mapping.ExceptionLogSimpleSql
//import com.dasoops.dasqr.core.mapping.ExceptionLogSimpleSql
import com.dasoops.dasqr.core.mapping.log.exception.ExceptionLogDo
import kotlin.coroutines.CoroutineContext

/**
 * sql日志异常处理程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-25
 */
object SqlLogExceptionHandler : ExceptionHandler {
    val exceptionLogSimpleSql: ExceptionLogSimpleSql = SpringUtil.getBean(ExceptionLogSimpleSql::class.java)

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        val rootCause = ExceptionUtil.getRootCause(exception)
        exceptionLogSimpleSql.save(
            ExceptionLogDo().apply {
                stackInfo = exception.stackTraceToString()
                topMessage = rootCause.message ?: "no message"
                exceptionType = rootCause.javaClass.name
            }
        )
    }
}