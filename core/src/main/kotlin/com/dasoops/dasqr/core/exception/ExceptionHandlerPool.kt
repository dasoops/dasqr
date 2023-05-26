package com.dasoops.dasqr.core.exception

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.util.Loader
import org.slf4j.LoggerFactory

/**
 * 异常处理器池接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
interface ExceptionHandlerPool {
    /**
     * 处理
     * @param [exception] 异常
     */
    fun handle(exception: Throwable)

    /**
     * 初始化
     * @param [config] 配置
     */
    fun init()

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        lateinit var INSTANCE: ExceptionHandlerPool

        fun goInit() {
            log.info("init exceptionHandlerPool")
            val exceptionHandlerPool = Loader
                .getOne<ExceptionHandlerPool>(Config.INSTANCE.dasqr.plugin.excludeClass)
            log.info("use exceptionHandlerPool: ${exceptionHandlerPool.javaClass.name}")
            exceptionHandlerPool.init()
            INSTANCE = exceptionHandlerPool
        }
    }
}