package com.dasoops.dasqr.core.plugin

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.DefaultConfig.dasqr
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.runner.InitRunner
import org.slf4j.LoggerFactory

/**
 * 插件池接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
interface PluginPool {
    suspend fun init(pluginConfig: PluginConfig)

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        lateinit var INSTANCE: PluginPool

        suspend fun goInit() {
            //加载插件
            log.info("init pluginPool")
            log.info("info")
            val pluginPool = Finder.get<PluginPool>(
                Config.INSTANCE.dasqr.plugin.scanPath, Config.INSTANCE.dasqr.plugin.excludeClass
            )
            log.info("use pluginPool: ${pluginPool.javaClass.name}")
            pluginPool.init(Config.INSTANCE.dasqr.plugin)
            INSTANCE = pluginPool
        }
    }
}