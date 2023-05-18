package com.dasoops.dasqr.core.runner

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.config.Config
import org.slf4j.LoggerFactory

/**
 * 启动加载器
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Runner]
 */
@IgnoreResourcesScan
interface Runner : IRunner {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
        suspend fun goInit() {
            log.info("go run custom runner")
            Finder.getAll<Runner>(Config.INSTANCE.dasqr.init.scanPath, Config.INSTANCE.dasqr.init.excludeClass)
                .forEach {
                    log.info("run custom runner：${it.javaClass.name}")
                    it.init()
                }
        }
    }
}

@IgnoreResourcesScan
interface SystemRunner : IRunner {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
        suspend fun goInit() {
            log.info("go run system runner")
            Finder.getAll<SystemRunner>(listOf("com.dasoops.dasqr"), emptyList()).forEach {
                log.info("run system runner：${it.javaClass.name}")
                it.init()
            }
        }
    }
}

interface IRunner {
    suspend fun init()
}