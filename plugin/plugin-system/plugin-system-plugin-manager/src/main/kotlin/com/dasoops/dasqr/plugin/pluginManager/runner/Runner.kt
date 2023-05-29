package com.dasoops.dasqr.plugin.pluginManager.runner

import com.dasoops.dasqr.core.runner.Runner
import com.dasoops.dasqr.plugin.pluginManager.runner.PluginRunner
import com.dasoops.dasqr.plugin.pluginManager.runner.RegisterRunner

/**
 * 启动类
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 * @see [Runner]
 */
open class Runner : Runner {
    override val level = Runner.Level.AFTER_PLUGIN_INIT

    override suspend fun init() {
        RegisterRunner.init()
        PluginRunner.init()
        PluginOtmRegisterRunner.init()
    }
}