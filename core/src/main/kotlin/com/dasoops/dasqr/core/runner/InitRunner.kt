package com.dasoops.dasqr.core.runner

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import com.dasoops.dasqr.core.loader.get
import com.dasoops.dasqr.core.plugin.PluginPool
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import kotlin.system.exitProcess

/**
 * 初始化
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@IgnoreResourcesScan
object InitRunner : SystemRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    override suspend fun init() = runBlocking {
        try {
            Resources.get("banner.txt").apply {
                if (exists()){
                    println(readText())
                }
            }

            log.info("go run system runner")
            Finder.getAll<SystemRunner>(listOf("com.dasoops.dasqr"), emptyList()).forEach {
                log.info("run system runner：${it.javaClass.name}")
                it.init()
            }

            //初始化配置项
            log.info("init config")
            val config = Finder.get<Config>(listOf("com.dasoops.dasqr"), null)
            config.init()
            Config.INSTANCE = config
            log.info("use config: ${config.javaClass.name}")

            //加载bot
            log.info("init IBot")
            IBot

            //加载插件
            log.info("init pluginPool")
            log.info("info")
            log.debug("debug")
            log.trace("trace")
            val pluginPool = Finder.get<PluginPool>(
                config.dasqr.plugin.scanPath, config.dasqr.plugin.excludeClass
            )
            log.info("use pluginPool: ${pluginPool.javaClass.name}")
            pluginPool.init(config.dasqr.plugin)
            PluginPool.INSTANCE = pluginPool

            //加载异常处理
            log.info("init exceptionHandlerPool")
            val exceptionHandlerPool = Finder.get<ExceptionHandlerPool>(
                config.dasqr.plugin.scanPath, config.dasqr.plugin.excludeClass
            )
            log.info("use exceptionHandlerPool: ${exceptionHandlerPool.javaClass.name}")
            exceptionHandlerPool.init(config.dasqr.exception)
            ExceptionHandlerPool.INSTANCE = exceptionHandlerPool

            log.info("go run custom runner")
            Finder.getAll<Runner>(config.dasqr.init.scanPath, config.dasqr.init.excludeClass).forEach {
                log.info("run custom runner：${it.javaClass.name}")
                launch(start = CoroutineStart.UNDISPATCHED) { it.init() }
            }
            while (true){

            }
        } catch (e: Throwable) {
            log.error("initRunner throw Exception: ", e)
            exitProcess(0)
        }
    }
}