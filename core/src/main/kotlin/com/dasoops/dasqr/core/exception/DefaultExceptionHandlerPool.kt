package com.dasoops.dasqr.core.exception

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.util.DefaultImpl
import com.dasoops.dasqr.core.util.Loader
import org.slf4j.LoggerFactory

/**
 * 异常处理器池
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@DefaultImpl
open class DefaultExceptionHandlerPool : ExceptionHandlerPool {
    /**
     * 处理器集合
     */
    private val handleSet: LinkedHashSet<ExceptionHandler> = LinkedHashSet()

    private val log = LoggerFactory.getLogger(javaClass)

    override fun init() {
        Loader.getAll<ExceptionHandler>(Config.INSTANCE.dasqr.exception.excludeClass).forEach {
            handleSet.add(it)
            log.info("load exception handler: ${it::class.java.name}")
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