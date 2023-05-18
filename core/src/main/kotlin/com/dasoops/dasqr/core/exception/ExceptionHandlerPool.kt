package com.dasoops.dasqr.core.exception

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.ExceptionConfig
import com.dasoops.dasqr.core.runner.InitRunner
import org.slf4j.LoggerFactory

/**
 * 异常处理器池接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
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
    fun init(config: ExceptionConfig)

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        lateinit var INSTANCE: ExceptionHandlerPool

        fun goInit() {
            log.info("init exceptionHandlerPool")
            val exceptionHandlerPool = Finder.get<ExceptionHandlerPool>(
                Config.INSTANCE.dasqr.plugin.scanPath, Config.INSTANCE.dasqr.plugin.excludeClass
            )
            log.info("use exceptionHandlerPool: ${exceptionHandlerPool.javaClass.name}")
            exceptionHandlerPool.init(Config.INSTANCE.dasqr.exception)
            INSTANCE = exceptionHandlerPool
        }
    }
}