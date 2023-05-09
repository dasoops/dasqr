package com.dasoops.dasqr.plugin.auth

import cn.hutool.aop.ProxyUtil
import cn.hutool.aop.aspects.SimpleAspect
import cn.hutool.core.util.RandomUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DasqrListenerHost
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.PluginProperties
import com.dasoops.dasqr.core.plugin.PluginPool
import org.slf4j.LoggerFactory
import java.lang.reflect.Method
import cn.hutool.aop.aspects.Aspect as Aspect

/**
 * 身份验证插件池
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 */
object AuthPluginPool : PluginPool {
    private val log = LoggerFactory.getLogger(javaClass)

    val loadList = mutableSetOf<DasqrListenerHost>()

    override fun init(pluginConfig: PluginProperties) {
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            IBot.eventChannel.registerListenerHost(proxy(it.kotlin.objectInstance as DasqrListenerHost))
            log.info("load listener host: ${it.name}")
        }
    }

    private fun proxy(listenerHost: DasqrListenerHost): DasqrListenerHost {
        return ProxyUtil.proxy(listenerHost, object : SimpleAspect() {
            override fun before(target: Any?, method: Method?, args: Array<out Any>?): Boolean {
                return RandomUtil.randomBoolean()
            }
        })
    }
}