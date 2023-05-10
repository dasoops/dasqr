package com.dasoops.dasqr.plugin.auth

import cn.hutool.aop.ProxyUtil
import cn.hutool.aop.aspects.SimpleAspect
import cn.hutool.core.util.RandomUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DasqrListenerHost
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.plugin.PluginPool
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import net.mamoe.mirai.event.*
import org.slf4j.LoggerFactory
import org.springframework.util.ClassUtils
import java.lang.reflect.Method
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.full.functions

/**
 * 身份验证插件池
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 */
object AuthPluginPool : PluginPool {
    private val log = LoggerFactory.getLogger(javaClass)

    val loadList = mutableSetOf<DasqrListenerHost>()

    override fun init(pluginConfig: PluginConfig) {
        log.info("[plugin-system-auth]use AuthPluginPool")
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            IBot.eventChannel.registerListenerHost0(proxy(it.kotlin.objectInstance as DasqrListenerHost))
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
                val listener = Method::class.functions.find { func ->
                    func.name == "registerEventHandler"
                }?.call(host, this, it, coroutineContext0) as Listener<Event>

//                val listener = method.registerEventHandler(host, this, it, coroutineContext0)
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