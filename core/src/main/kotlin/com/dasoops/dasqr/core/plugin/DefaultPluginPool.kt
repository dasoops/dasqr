package com.dasoops.dasqr.core.plugin

import cn.hutool.core.util.ReflectUtil
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.DefaultImpl
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.listener.*
import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import net.mamoe.mirai.event.*
import net.mamoe.mirai.spi.AudioToSilkService.Companion.priority
import org.slf4j.LoggerFactory
import org.springframework.util.ClassUtils
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

/**
 * 插件加载程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
@DefaultImpl
object DefaultPluginPool : PluginPool {

    private val log = LoggerFactory.getLogger(javaClass)

    val loadList = mutableSetOf<DasqrSimpleListenerHost>()

    @Suppress("UNCHECKED_CAST")
    override fun init(pluginConfig: PluginConfig) {
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            if (DasqrSimpleListenerHost::class.java.isAssignableFrom(it)) {
                IBot.eventChannel.registerListenerHost0(instanceFormClass(it as Class<DasqrSimpleListenerHost>))
                log.info("load simple listener host: ${it.name}")
            } else {
                val dslListenerHost = instanceFormClass(it as Class<DslListenerHost>)
                dslListenerHost.initAndGetMetaList().forEach { metaData ->
                    when (metaData) {
                        is GroupDslEventHandlerMetaData -> IBot.eventChannel.subscribeGroupMessages(
                            concurrencyKind = metaData.concurrency,
                            priority = metaData.priority,
                            listeners = metaData.func
                        )

                        is UserDslEventHandlerMetaData -> IBot.eventChannel.subscribeUserMessages(
                            concurrencyKind = metaData.concurrency,
                            priority = metaData.priority,
                            listeners = metaData.func
                        )
                    }
                }
                log.info("load dsl listener host: ${it.name}")
            }
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
            //添加这一行,open suspend会生成一个supendImpl供java调用
            if (!Modifier.isStatic(method.modifiers)) {
                method.getAnnotation(EventHandler::class.java)?.let {
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