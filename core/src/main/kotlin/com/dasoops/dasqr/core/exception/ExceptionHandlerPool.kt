package com.dasoops.dasqr.core.exception

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.runner.DasqrProperties
import org.slf4j.LoggerFactory
import kotlin.coroutines.CoroutineContext

/**
 * 异常处理器池
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object ExceptionHandlerPool {
    /**
     * 处理器集合
     */
    private val handleSet: LinkedHashSet<ExceptionHandler> = LinkedHashSet()

    private val log = LoggerFactory.getLogger(javaClass)

    fun load(){
        val exceptionProperties = DasqrProperties.exception
        if (exceptionProperties.scanPathList != null) {
            Resources.scan(ExceptionHandler::class.java.classLoader, *exceptionProperties.scanPathList.toTypedArray()).filter {
                        ExceptionHandler::class.java.isAssignableFrom(it) &&
                        exceptionProperties.excludeClass?.contains(it.javaClass.name) != true
            }.forEach { clazz ->
                handleSet.add(clazz.kotlin.objectInstance as ExceptionHandler)
                log.info("load exception handler: ${clazz.name}")
            }
        } else {
            log.error("exceptionHandler scan path list is null")
        }
    }

    fun handle(context: CoroutineContext, exception: Throwable) =
        handleSet.forEach {
            it.handleException(context, exception)
        }

    /**
     * 注册异常处理器
     * @param [exceptionHandler]
     */
    fun register(exceptionHandler: ExceptionHandler) =
        handleSet.add(exceptionHandler)

    /**
     * 移除异常处理器
     * @param [clazz]
     */
    fun <T : ExceptionHandler> remove(clazz: Class<T>) =
        handleSet.removeIf { it.javaClass == clazz }
}