package com.dasoops.dasqr.core.plugin

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DasqrListenerHost
import com.dasoops.dasqr.core.DefaultImpl
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.PluginProperties
import org.slf4j.LoggerFactory

/**
 * 插件加载程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
@DefaultImpl
object DefaultPluginPool : PluginPool {

    private val log = LoggerFactory.getLogger(javaClass)

    val loadList = mutableSetOf<DasqrListenerHost>()


    override fun init(pluginConfig: PluginProperties) {
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            IBot.eventChannel.registerListenerHost(it.kotlin.objectInstance as DasqrListenerHost)
            log.info("load listener host: ${it.name}")
        }
    }
}