package com.dasoops.dasqr.plugin.pluginManager.auth

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.ClassUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.listener.*
import com.dasoops.dasqr.core.plugin.DefaultPluginPool
import com.dasoops.dasqr.core.plugin.LoadPlugin
import com.dasoops.dasqr.core.plugin.PluginPool
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import net.mamoe.mirai.event.*
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.spi.AudioToSilkService.Companion.priority
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

    override val loadList: MutableCollection<LoadPlugin> = mutableSetOf()

    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        lateinit var INSTANCE: AuthPluginPool
    }

    @Suppress("UNCHECKED_CAST")
    override suspend fun init() {
        INSTANCE = this
        val scanPathList = Config.INSTANCE.dasqr.plugin.scanPathList
        val excludeClass = Config.INSTANCE.dasqr.plugin.excludeClass
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.filter {
            !excludeClass.contains(it.javaClass.name)
        }.forEach {
            val listenerHost: DasqrListenerHost
            val registerMethodNameList = if (DasqrSimpleListenerHost::class.java.isAssignableFrom(it)) {
                val status = InstanceStatus.forClass(it as Class<DasqrSimpleListenerHost>)
                if (status == InstanceStatus.IS_OBJECT_SKIP_AUTH) {
                    listenerHost = status.instance(it)
                    log.warn("load simple listener host: ${it.name}")
                } else {
                    status.check(it)
                    listenerHost = AuthProxy.proxyInstance(it)
                    log.info("load auth simple listener host: ${it.name}")
                }
                IBot.eventChannel.registerListenerHost0(listenerHost)
            } else {
                listenerHost = instanceFormClassOrNull(it as Class<DslListenerHost>)
                log.info("load auth dsl listener host: ${it.name}")
                listenerHost.initAndGetMetaList().map { metaData ->
                    when (metaData) {
                        is GroupDslEventHandlerMetaData ->
                            IBot.eventChannel.filter { event ->
                                event is GroupMessageEvent && Auth.auth(it, metaData, event)
                            }.subscribeGroupMessages(
                                concurrencyKind = metaData.concurrency,
                                priority = metaData.priority,
                                listeners = metaData.func
                            )

                        is FriendDslEventHandlerMetaData ->
                            IBot.eventChannel.filter { event ->
                                event is FriendMessageEvent && Auth.auth(it, metaData, event)
                            }.subscribeFriendMessages(
                                concurrencyKind = metaData.concurrency,
                                priority = metaData.priority,
                                listeners = metaData.func
                            )
                    }
                    metaData.name
                }
            }

            val loadPluginList =
                DefaultPluginPool.buildLoadPlugin(it as Class<DasqrListenerHost>, registerMethodNameList, listenerHost)
            loadList.addAll(loadPluginList)
        }
    }

    fun <T : DasqrListenerHost> instanceFormClassOrNull(clazz: Class<T>): T {
        return InstanceStatus.forClass(clazz).instance(clazz)
    }

    fun EventChannel<*>.registerListenerHost0(
        host: DasqrListenerHost,
        coroutineContext: CoroutineContext = EmptyCoroutineContext,
    ): Collection<String> {
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
        return ClassUtil.getUserClass(host).declaredMethods.mapNotNull { method ->
            if (Modifier.isStatic(method.modifiers)) return@mapNotNull null
            val eventHandler = method.getAnnotation(EventHandler::class.java) ?: return@mapNotNull null
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
                .invoke(method, method, host, this, eventHandler, coroutineContext0) as Listener<*>
            jobOfListenerHost?.invokeOnCompletion { exception ->
                listener.cancel(
                    when (exception) {
                        is CancellationException -> exception
                        is Throwable -> CancellationException(null, exception)
                        else -> null
                    }
                )
            }
            return@mapNotNull method.name
        }
    }
}