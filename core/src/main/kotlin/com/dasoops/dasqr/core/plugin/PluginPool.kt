package com.dasoops.dasqr.core.plugin

import com.dasoops.dasqr.core.util.Loader
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.PluginConfig
import org.slf4j.LoggerFactory

/**
 * 插件池接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
interface PluginPool {
    suspend fun init()

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        lateinit var INSTANCE: PluginPool

        suspend fun goInit() {
            //加载插件
            log.info("init pluginPool")
            val pluginPool = Loader.getOne<PluginPool>(Config.INSTANCE.dasqr.plugin.excludeClass)
            log.info("use pluginPool: ${pluginPool.javaClass.name}")
            pluginPool.init()
            INSTANCE = pluginPool
        }
    }
}