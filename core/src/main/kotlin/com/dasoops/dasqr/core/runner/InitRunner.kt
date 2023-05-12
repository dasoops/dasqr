package com.dasoops.dasqr.core.runner

import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import com.dasoops.dasqr.core.plugin.PluginPool
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.utils.LoggerAdapters
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.system.exitProcess

/**
 * 初始化
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@Component
class InitRunner : ApplicationRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(args: ApplicationArguments): Unit = runBlocking {
        try {
            //初始化配置项
            log.info("init config")
            val config = Finder.get<Config>(listOf("com.dasoops.dasqr"))
            config.init()
            Config.INSTANCE = config
            log.info("use config: ${config.javaClass.name}")

            //初始化日志
            if (config.mirai.log.useLog4j2) {
                LoggerAdapters.useLog4j2()
                log.info("useLog4j2")
            }

            //加载bot
            log.info("init IBot")
            IBot

            //加载插件
            log.info("init pluginPool")
            val pluginPool = Finder.get<PluginPool>(config.dasqr.plugin.scanPath)
            log.info("use pluginPool: ${pluginPool.javaClass.name}")
            pluginPool.init(config.dasqr.plugin)
            PluginPool.INSTANCE = pluginPool

            //加载异常处理
            log.debug("init exceptionHandlerPool")
            val exceptionHandlerPool = Finder.get<ExceptionHandlerPool>(config.dasqr.plugin.scanPath)
            log.info("use exceptionHandlerPool: ${exceptionHandlerPool.javaClass.name}")
            exceptionHandlerPool.init(config.dasqr.exception)
            ExceptionHandlerPool.INSTANCE = exceptionHandlerPool
            IBot.eventChannel.exceptionHandler {
                exceptionHandlerPool.handle(it)
            }

        } catch (e: Throwable) {
            log.error("initRunner throw Exception: ", e)
            exitProcess(0)
        }
    }
}