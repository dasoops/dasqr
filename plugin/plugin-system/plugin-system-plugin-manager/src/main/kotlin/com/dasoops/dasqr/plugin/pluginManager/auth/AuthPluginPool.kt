package com.dasoops.dasqr.plugin.pluginManager.auth

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.ClassUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.listener.*
import com.dasoops.dasqr.core.plugin.PluginPool
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import net.mamoe.mirai.event.*
import org.slf4j.LoggerFactory
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 身份验证插件池
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 */
open class AuthPluginPool : PluginPool {
    private val log = LoggerFactory.getLogger(javaClass)

    @Suppress("UNCHECKED_CAST")
    override suspend fun init() {
        val scanPathList = Config.INSTANCE.dasqr.plugin.scanPathList
        val excludeClass = Config.INSTANCE.dasqr.plugin.excludeClass
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.filter {
            !excludeClass.contains(it.javaClass.name)
        }.forEach {
            if (DasqrSimpleListenerHost::class.java.isAssignableFrom(it)) {
                val status = InstanceStatus.forClass(it as Class<DasqrSimpleListenerHost>)
                if (status == InstanceStatus.IS_OBJECT_SKIP_AUTH) {
                    registerObjectClassNoAuth(status.instance(it)!!)
                    log.warn("load simple listener host: ${it.name}")
                } else {
                    status.check(it)
                    register(it)
                    log.info("load auth simple listener host: ${it.name}")
                }
            } else {
                instanceFormClassOrNull(it as Class<DslListenerHost>)?.run {
                    initAndGetMetaList().forEach { metaData ->
                        when (metaData) {
                            is GroupDslEventHandlerMetaData ->
                                IBot.eventChannel.subscribeGroupMessages(
                                    concurrencyKind = metaData.concurrency,
                                    priority = metaData.priority,
                                    listeners = AuthProxy.proxyFunc(it, metaData, metaData.func)
                                )

                            is FriendDslEventHandlerMetaData -> IBot.eventChannel.subscribeFriendMessages(
                                concurrencyKind = metaData.concurrency,
                                priority = metaData.priority,
                                listeners = AuthProxy.proxyFunc(it, metaData, metaData.func)
                            )
                        }
                    }
                }
                log.info("load auth dsl listener host: ${it.name}")
            }
        }
    }

    fun register(clazz: Class<DasqrSimpleListenerHost>) {
        IBot.eventChannel.registerListenerHost0(AuthProxy.proxyInstance(clazz))
    }

    fun registerObjectClassNoAuth(listenerHost: DasqrSimpleListenerHost) {
        IBot.eventChannel.registerListenerHost0(listenerHost)
    }

    fun <T : DasqrListenerHost> instanceFormClassOrNull(clazz: Class<T>): T? {
        return InstanceStatus.forClass(clazz).instance(clazz)
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
        for (method in ClassUtil.getUserClass(host).declaredMethods) {
            if (!Modifier.isStatic(method.modifiers)) {
                method.getAnnotation(EventHandler::class.java)?.let {
                    if (Modifier.isFinal(method.modifiers)) {
                        if (Config.INSTANCE.auth.skipRegisterError) {
                            log.warn(
                                """
                                |${host.javaClass.name}.(${method.name})被声明为final,该方法将跳过权限验证直接执行
                                |如果这在您的预期外,请检查配置项[auth.skipRegisterError]
                            """.trimMargin()
                            )
                        } else {
                            throw SimpleProjectExceptionEntity(
                                """
                                |[plugin-system-plugin-manager]插件无法处理一个被声明为final的方法:
                                |  ${host.javaClass.name}.${method.name}()
                                |- 将其声明为open method
                                |- 将配置项[auth.skipRegisterError]设置为true可以忽略这个错误,但插件无法再为其提供权限校验
                            """.trimMargin()
                            )
                        }
                    }
                    //通过反射获取执行
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
}