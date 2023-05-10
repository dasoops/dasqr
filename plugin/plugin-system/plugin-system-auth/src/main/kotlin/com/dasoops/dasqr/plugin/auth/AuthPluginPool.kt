package com.dasoops.dasqr.plugin.auth

import cn.hutool.aop.ProxyUtil
import cn.hutool.aop.aspects.SimpleAspect
import cn.hutool.core.util.ReflectUtil
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DasqrListenerHost
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.plugin.DefaultPluginPool
import com.dasoops.dasqr.core.plugin.PluginPool
import org.slf4j.LoggerFactory
import java.lang.reflect.Method

/**
 * 身份验证插件池
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 */
object AuthPluginPool : PluginPool {
    private val log = LoggerFactory.getLogger(javaClass)

    val loadList = mutableSetOf<DasqrListenerHost>()

    @Suppress("UNCHECKED_CAST")
    override fun init(pluginConfig: PluginConfig) {
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            instanceFormClassOrNull(it as Class<DasqrListenerHost>)?.run {
                IBot.eventChannel.registerListenerHost(proxy(this))
            }
            log.info("load listener host: ${it.name}")
        }
    }

    private fun proxy(listenerHost: DasqrListenerHost): DasqrListenerHost {
        //import cn.hutool.aop.ProxyUtil
        //cglib动态代理
        return ProxyUtil.proxy(listenerHost, object : SimpleAspect() {
            override fun before(target: Any?, method: Method?, args: Array<out Any>?): Boolean {
                TODO()
            }
        })
    }

    fun instanceFormClassOrNull(clazz: Class<DasqrListenerHost>): DasqrListenerHost? {
        return if (clazz.kotlin.isOpen && !clazz.kotlin.isAbstract) {
            ReflectUtil.getConstructor(clazz).newInstance() as DasqrListenerHost
        } else if (clazz.kotlin.objectInstance != null) {
            //跳过object实例
            if (Config.INSTANCE.auth.skipObjectInstance) {
                log.warn(
                    """
                    |${clazz.name}被声明为object,该插件将跳过权限验证直接执行
                    |如果这在您的预期外,请检查配置项[auth.skipObjectInstance]
                    """.trimMargin()
                )
                return DefaultPluginPool.instanceFormClass(clazz)
            } else {
                throw SimpleProjectExceptionEntity(
                    """
                    |[plugin-system-auth]插件无法处理一个object类型的ListenerHost
                    |- 将其声明为open class,并保持一个无参构造,插件会生成该类的实例并为其提供权限校验
                    |- 将配置项auth.skipObjectInstance设置为true可以忽略这个错误,但插件无法再为其提供权限校验
                """.trimMargin()
                )
            }
        } else {
            null
        }
    }
}