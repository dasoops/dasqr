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

    override suspend fun init() =
        try {
            printBanner()
            SystemRunner.goInit()
            Config.goInit()

            //加载bot
            log.info("init IBot")
            IBot

            PluginPool.goInit()
            ExceptionHandlerPool.goInit()
            Runner.goInit()
        } catch (e: Throwable) {
            log.error("initRunner throw Exception: ", e)
            exitProcess(0)
        }

    private fun printBanner() {
        Resources.get("banner.txt").apply {
            if (exists()){
                println(readText())
            }
        }
    }

}