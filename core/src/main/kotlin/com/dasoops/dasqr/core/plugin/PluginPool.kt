package com.dasoops.dasqr.core.plugin

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.PluginConfig

/**
 * 插件池接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
interface PluginPool {
    fun init(pluginConfig: PluginConfig)

    companion object {
        lateinit var INSTANCE: PluginPool
    }
}