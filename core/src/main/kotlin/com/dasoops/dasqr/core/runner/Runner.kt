package com.dasoops.dasqr.core.runner

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.util.QuickServiceLoader
import org.slf4j.LoggerFactory

/**
 * 启动加载器
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Runner]
 */
interface Runner {
    val level: Level
        get() = Level.LAST

    suspend fun init()

    enum class Level {
        /**
         * 最早(系统级,将在InitRunner开始执行后第一个加载)
         * 该类无法被init.excludeClass排除,详情请查看Runner.runBeforeAll()
         */
        BEFORE_ALL,

        //将在bot加载前执行
        BEFORE_BOT_INIT,

        //将在bot加载后执行
        AFTER_BOT_INIT,

        //插件加载后执行
        AFTER_PLUGIN_INIT,

        //最后(将在bot加载后执行)
        LAST,
        ;
    }

    companion object {
        lateinit var runnerList: Collection<Runner>
        private val log = LoggerFactory.getLogger(this::class.java)

        suspend fun runBeforeAll() {
            log.info("go run custom runner (before all)")
            runnerList = QuickServiceLoader.getAll<Runner>()
            runnerList.filter { it.level == Level.BEFORE_ALL }
                .forEach {
                    log.info("runner: ${it::class.qualifiedName}")
                    it.init()
                }
        }

        suspend fun runBeforeBotInit() {
            log.info("go run custom runner (before bot init)")
            //排除加载类
            runnerList = runnerList.filter {
                !Config.INSTANCE.dasqr.init.excludeClass.contains(it::class.java.name)
            }
            runnerList.filter { it.level == Level.BEFORE_BOT_INIT }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }

        suspend fun runAfterBotInit() {
            log.info("go run custom runner (after bot init)")
            runnerList.filter { it.level == Level.AFTER_BOT_INIT }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }

        suspend fun runAfterPluginInit() {
            log.info("go run custom runner (after plugin init)")
            runnerList.filter { it.level == Level.AFTER_PLUGIN_INIT }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }

        suspend fun runLast() {
            log.info("go run custom runner (last)")
            runnerList.filter { it.level == Level.LAST }.forEach {
                log.info("runner: ${it::class.qualifiedName}")
                it.init()
            }
        }
    }
}