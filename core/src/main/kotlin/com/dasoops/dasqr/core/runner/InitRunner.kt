package com.dasoops.dasqr.core.runner

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import com.dasoops.dasqr.core.util.get
import com.dasoops.dasqr.core.plugin.PluginPool
import org.slf4j.LoggerFactory
import kotlin.system.exitProcess

/**
 * 初始化
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object InitRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    suspend fun init() {
        try {
            printBanner()
            Runner.runBeforeAll()
            Config.goInit()

            Runner.runBeforeBotInit()
            //加载bot
            log.info("init IBot")
            //IBot.login()
            Runner.runAfterBotInit()

            PluginPool.goInit()
            Runner.runAfterPluginInit()

            ExceptionHandlerPool.goInit()
            Runner.runLast()
            log.info("init success")
        } catch (e: Throwable) {
            log.error("initRunner throw Exception: ", e)
            exitProcess(0)
        }
    }

    private fun printBanner() {
        Resources.get("banner.txt").apply {
            if (exists()) {
                println(readText())
            }
        }
    }

}