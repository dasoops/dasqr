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
import com.dasoops.dasqr.plugin.auth.AuthPluginPool.registerListenerHost0
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import net.mamoe.mirai.event.*
import org.slf4j.LoggerFactory
import org.springframework.util.ClassUtils
import java.lang.reflect.Method
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.full.declaredMemberExtensionFunctions
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

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
                IBot.eventChannel.registerListenerHost0(proxy(this))
            }
            log.info("load auth listener host: ${it.name}")
        }
    }

    private fun proxy(listenerHost: DasqrListenerHost): DasqrListenerHost {
        //import cn.hutool.aop.ProxyUtil
        //cglib动态代理
        return ProxyUtil.proxy(listenerHost, object : SimpleAspect() {
            override fun before(target: Any?, method: Method?, args: Array<out Any>?): Boolean {
                return super.before(target, method, args)
            }

            override fun after(target: Any?, method: Method?, args: Array<out Any>?, returnVal: Any?): Boolean {
                return super.after(target, method, args, returnVal)
            }

            override fun afterException(target: Any?, method: Method?, args: Array<out Any>?, e: Throwable?): Boolean {
                return super.afterException(target, method, args, e)
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

    fun EventChannel<*>.registerListenerHost0(
        host: ListenerHost,
        coroutineContext: CoroutineContext = EmptyCoroutineContext,
    ) {
        val jobOfListenerHost: Job?
        val coroutineContext0 = if (host is SimpleListenerHost) {
            val listenerCoroutineContext = host.coroutineContext
            val listenerJob = listenerCoroutineContext[Job]

            val rsp = listenerCoroutineContext.minusKey(Job) +
                    coroutineContext +
                    (listenerCoroutineContext[CoroutineExceptionHandler] ?: EmptyCoroutineContext)

            val registerCancelHook = when {
                listenerJob === null -> false

                // Registering cancellation hook is needless
                // if [Job] of [EventChannel] is same as [Job] of [SimpleListenerHost]
                (rsp[Job] ?: this.defaultCoroutineContext[Job]) === listenerJob -> false

                else -> true
            }

            jobOfListenerHost = if (registerCancelHook) {
                listenerCoroutineContext[Job]
            } else {
                null
            }
            rsp
        } else {
            jobOfListenerHost = null
            coroutineContext
        }
        for (method in ClassUtils.getUserClass(host).declaredMethods) {
            method.getAnnotation(EventHandler::class.java)?.let { it ->

                val listener = Class.forName("net.mamoe.mirai.internal.event.JvmMethodListenersInternalKt")
                    .getDeclaredMethod(
                        "registerEventHandler",
                        Method::class.java,
                        Object::class.java,
                        EventChannel::class.java,
                        EventHandler::class.java,
                        CoroutineContext::class.java
                    )
                    .invoke(method, method, host, this, it, coroutineContext0) as Listener<*>

//                val listener = Method::class.declaredMemberExtensionFunctions.find { func ->
//                    func.name == "registerEventHandler"
//                }?.call(host, this, it, coroutineContext0) as Listener<Event>

//                val listener = method.registerListenerHost0(host, this, it, coroutineContext0)
                // For [SimpleListenerHost.cancelAll]
                jobOfListenerHost?.invokeOnCompletion { exception ->
                    listener.cancel(
                        when (exception) {
                            is CancellationException -> exception
                            is Throwable -> CancellationException(null, exception)
                            else -> null
                        }
                    )
                }
            }
        }
    }
}