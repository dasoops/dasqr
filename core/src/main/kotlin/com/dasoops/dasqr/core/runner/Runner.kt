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
    val level: RunnerLevel
        get() = RunnerLevel.LAST

    companion object {
        lateinit var runnerList: Collection<Runner>
        private val log = LoggerFactory.getLogger(this::class.java)
        suspend fun runBeforeAll() {
            log.info("go run custom runner (before all)")
            Finder.getAll<Runner>(listOf("com.dasoops.dasqr"), null)
                .filter { it.level == RunnerLevel.BEFORE_ALL }
                .forEach {
                    log.info("runner: ${it::class.qualifiedName}")
                    it.init()
                }
        }

        suspend fun runBeforeBotInit() {
            log.info("go run custom runner (before bot init)")
            runnerList = Finder.getAll<Runner>(
                Config.INSTANCE.dasqr.init.scanPath,
                Config.INSTANCE.dasqr.init.excludeClass
            )
            runnerList.filter { it.level == RunnerLevel.BEFORE_BOT_INIT }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }

        suspend fun runAfterBotInit() {
            log.info("go run custom runner (after bot init)")
            runnerList.filter { it.level == RunnerLevel.AFTER_BOT_INIT }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }

        suspend fun runLast() {
            log.info("go run custom runner (last)")
            runnerList.filter { it.level == RunnerLevel.LAST }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }
    }
}

enum class RunnerLevel {
    //最早(系统级,将在InitRunner开始执行后第一个加载)
    BEFORE_ALL,

    //将在bot加载前执行
    BEFORE_BOT_INIT,

    //将在bot加载后执行
    AFTER_BOT_INIT,

    //最后(将在bot加载后执行)
    LAST,
    ;
}

interface IRunner {
    suspend fun init()
}