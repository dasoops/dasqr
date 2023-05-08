package com.dasoops.dasqr.core.runner

import com.dasoops.common.json.Json
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import com.dasoops.dasqr.core.plugin.PluginPool
import net.mamoe.mirai.utils.LoggerAdapters
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * 初始化
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@Component
class InitRunner : ApplicationRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(args: ApplicationArguments) {
        //初始化配置项
        val config = Finder.get<Config>(listOf("com.dasoops.dasqr"))
        config.init()
        Config.INSTANCE = config
        log.info(
            """
            load config for : ${System.getProperty("user.dir")}/config.yaml
            ${Json.toJsonStr(config)}
        """.trimIndent()
        )

        //初始化日志
        if (config.mirai.log.useLog4j2) {
            LoggerAdapters.useLog4j2()
            log.info("useLog4j2")
        }

        //加载bot
        IBot
        log.info("init IBot")

        //加载插件
        log.debug("scan plugin")
        val pluginPool = Finder.get<PluginPool>(config.dasqr.plugin.scanPath)
        pluginPool.init(config.dasqr.plugin)

        //加载异常处理
        log.debug("scan exception")
        val exceptionHandler = Finder.get<ExceptionHandlerPool>(config.dasqr.plugin.scanPath)
        exceptionHandler.init(config.dasqr.exception)
    }
}