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

    init {
        val exceptionProperties = DasqrProperties.exception
        if (exceptionProperties.scanPathList != null) {
            Resources.scan(*exceptionProperties.scanPathList.toTypedArray()).filter {
                //是object
                it.kotlin.objectInstance != null
                        //不在排除类中
                        && DasqrProperties.exception.excludeClass?.contains(it.javaClass.name) != true
            }.forEach { clazz ->
                handleSet.add(clazz.kotlin.objectInstance as ExceptionHandler)
            }
        } else {
            log.error("exceptionHandler scan path list is null")
        }
    }

    fun handle(context: CoroutineContext, exception: Throwable) =
        handleSet.forEach {
            it.handleException(context, exception)
        }

    fun register(exceptionHandler: ExceptionHandler) =
        handleSet.add(exceptionHandler)


    fun <T : ExceptionHandler> remove(clazz: Class<T>) =
        handleSet.removeIf { it.javaClass == clazz }

}