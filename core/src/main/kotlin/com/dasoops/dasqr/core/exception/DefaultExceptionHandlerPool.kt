package com.dasoops.dasqr.core.exception

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DefaultImpl
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.ExceptionConfig
import org.slf4j.LoggerFactory

/**
 * 异常处理器池
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@DefaultImpl
object DefaultExceptionHandlerPool : ExceptionHandlerPool {
    /**
     * 处理器集合
     */
    private val handleSet: LinkedHashSet<ExceptionHandler> = LinkedHashSet()

    private val log = LoggerFactory.getLogger(javaClass)

    override fun init(config: ExceptionConfig) {
        Resources.scan(ExceptionHandler::class.java.classLoader, *config.scanPath.toTypedArray()).filter {
            ExceptionHandler::class.java.isAssignableFrom(it) &&
                    config.excludeClass?.contains(it.javaClass.name) != true
        }.forEach { clazz ->
            handleSet.add(clazz.kotlin.objectInstance as ExceptionHandler)
            log.info("load exception handler: ${clazz.name}")
        }
    }

    override fun handle(exception: Throwable) =
        handleSet.forEach {
            it.handle(exception)
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