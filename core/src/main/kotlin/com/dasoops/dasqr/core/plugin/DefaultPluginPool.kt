package com.dasoops.dasqr.core.plugin

import cn.hutool.core.util.ReflectUtil
import com.dasoops.common.core.util.ClassUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.listener.*
import com.dasoops.dasqr.core.loader.DasqrRunner
import com.dasoops.dasqr.core.loader.Development
import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import com.dasoops.dasqr.core.util.DefaultImpl
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import net.mamoe.mirai.event.*
import net.mamoe.mirai.event.events.GroupMessageEvent
import org.slf4j.LoggerFactory
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 插件加载程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
@DefaultImpl
open class DefaultPluginPool : PluginPool {

    private val log = LoggerFactory.getLogger(javaClass)

    override val loadList = mutableSetOf<LoadPlugin>()

    companion object {
        fun buildLoadPlugin(
            hostClass: Class<DasqrListenerHost>,
            registerMethodNameList: Collection<String>,
            listenerHost: DasqrListenerHost,
        ): List<LoadPlugin> {
            //获取来源插件信息
            val dasqrPlugin = if (DasqrRunner.load) {
                DasqrRunner.loadPluginList.first { dasqrPlugin ->
                    dasqrPlugin.rawPath == hostClass.protectionDomain.codeSource.location.toURI()
                }
            } else {
                Development
            }
            val loadPluginList = registerMethodNameList.map { name ->
                LoadPlugin(
                    from = dasqrPlugin,
                    listenerHost = listenerHost,
                    methodName = name
                )
            }
            return loadPluginList
        }
    }

    @Suppress("UNCHECKED_CAST")
    override suspend fun init() {
        val excludeList = Config.INSTANCE.dasqr.plugin.excludeClass
        val scanPathList = Config.INSTANCE.dasqr.plugin.scanPathList
        Resources.scan(scanPathList).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            if (excludeList.contains(it.name)) {
                return@forEach
            }
            val listenerHost: DasqrListenerHost
            val registerMethodNameList = if (DasqrSimpleListenerHost::class.java.isAssignableFrom(it)) {
                listenerHost = instanceFormClass(it as Class<DasqrSimpleListenerHost>)
                log.info("load simple listener host: ${it.name}")
                IBot.eventChannel.registerListenerHost0(listenerHost)
            } else {
                listenerHost = instanceFormClass(it as Class<DslListenerHost>)
                log.info("load dsl listener host: ${it.name}")
                registerDsl(listenerHost)
            }.ifEmpty { return@forEach }

            val loadPluginList = buildLoadPlugin(it as Class<DasqrListenerHost>, registerMethodNameList, listenerHost)
            loadList.addAll(loadPluginList)
        }
    }

    private suspend fun registerDsl(dslListenerHost: DslListenerHost): Collection<String> {
        return dslListenerHost.initAndGetMetaList().map { metaData ->
            when (metaData) {
                is GroupDslEventHandlerMetaData ->
                    IBot.eventChannel.subscribeGroupMessages(
                        concurrencyKind = metaData.concurrency,
                        priority = metaData.priority,
                        listeners = metaData.func
                    )

                is FriendDslEventHandlerMetaData ->
                    IBot.eventChannel.subscribeFriendMessages(
                        concurrencyKind = metaData.concurrency,
                        priority = metaData.priority,
                        listeners = metaData.func
                    )
            }
            metaData.name
        }
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
            //通过反射执行
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

    fun <T : DasqrListenerHost> instanceFormClass(clazz: Class<T>): T {
        return instanceFormClassOrNull(clazz) ?: throw InitExceptionEntity(
            InitException.UNCREATE_LISTENER_HOST_INSTANCE,
            """
                无法创建listenerHost实例: ${clazz.name}
                类必须为open或object
            """.trimIndent()
        )
    }

    fun <T : DasqrListenerHost> instanceFormClassOrNull(clazz: Class<T>): T? {
        return if (clazz.kotlin.objectInstance != null) {
            clazz.kotlin.objectInstance as T
        } else if (clazz.kotlin.isOpen && !clazz.kotlin.isAbstract) {
            ReflectUtil.getConstructor(clazz).newInstance() as T
        } else {
            null
        }
    }
}