package com.dasoops.dasqr.core.plugin

import cn.hutool.core.util.ReflectUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DasqrListenerHost
import com.dasoops.dasqr.core.DefaultImpl
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
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

    @Suppress("UNCHECKED_CAST")
    override fun init(pluginConfig: PluginConfig) {
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            IBot.eventChannel.registerListenerHost(instanceFormClass(it as Class<DasqrListenerHost>))
            log.info("load listener host: ${it.name}")
        }
    }

    fun instanceFormClass(clazz: Class<DasqrListenerHost>): DasqrListenerHost {
        return instanceFormClassOrNull(clazz) ?: throw InitExceptionEntity(
            InitException.UNCREATE_LISTENER_HOST_INSTANCE,
            """
                无法创建listenerHost实例: ${clazz.name}
                类必须为open或object
            """.trimIndent()
        )
    }

    fun instanceFormClassOrNull(clazz: Class<DasqrListenerHost>): DasqrListenerHost? {
        return if (clazz.kotlin.objectInstance != null) {
            clazz.kotlin.objectInstance as DasqrListenerHost
        } else if (clazz.kotlin.isOpen && !clazz.kotlin.isAbstract) {
            ReflectUtil.getConstructor(clazz).newInstance() as DasqrListenerHost
        } else {
            null
        }
    }
}