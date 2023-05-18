package com.dasoops.dasqr.plugin.auth

import cn.hutool.aop.ProxyUtil
import cn.hutool.aop.aspects.SimpleAspect
import cn.hutool.core.util.ReflectUtil
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.ClassUtil
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.listener.DasqrSimpleListenerHost
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.PluginConfig
import com.dasoops.dasqr.core.plugin.DefaultPluginPool
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
object AuthPluginPool : PluginPool {
    private val log = LoggerFactory.getLogger(javaClass)

    @Suppress("UNCHECKED_CAST")
    override suspend fun init(pluginConfig: PluginConfig) {
        val scanPathList = pluginConfig.scanPath
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrSimpleListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            instanceFormClassOrNull(it as Class<DasqrSimpleListenerHost>)?.run {
                register(this)
            }
            log.info("load auth listener host: ${it.name}")
        }
    }

    fun register(listenerHost: DasqrSimpleListenerHost) {
        IBot.eventChannel.registerListenerHost0(proxy(listenerHost))
    }

    fun proxy(listenerHost: DasqrSimpleListenerHost): DasqrSimpleListenerHost {
        //import cn.hutool.aop.ProxyUtil
        //cglib动态代理
        return ProxyUtil.proxy(listenerHost, object : SimpleAspect() {
            override fun before(target: Any?, method: Method?, args: Array<out Any>?): Boolean {
                return super.before(target, method, args)
            }
        })
    }

    fun instanceFormClassOrNull(clazz: Class<DasqrSimpleListenerHost>): DasqrSimpleListenerHost? {
        return if (clazz.kotlin.isOpen && !clazz.kotlin.isAbstract) {
            ReflectUtil.getConstructor(clazz).newInstance() as DasqrSimpleListenerHost
        } else if (clazz.kotlin.objectInstance != null) {
            //跳过object实例
            if (Config.INSTANCE.auth.skipRegisterError) {
                log.warn(
                    """
                    |${clazz.name}被声明为object,该插件将跳过权限验证直接执行
                    |如果这在您的预期外,请检查配置项[auth.skipRegisterError]
                    """.trimMargin()
                )
                return DefaultPluginPool.instanceFormClass(clazz)
            } else {
                throw SimpleProjectExceptionEntity(
                    """
                    |[plugin-system-auth]插件无法处理一个object类型的ListenerHost
                    |- 将其声明为open class,并保持一个无参构造,插件会生成该类的实例并为其提供权限校验
                    |- 将配置项[auth.skipRegisterError]设置为true可以忽略这个错误,但插件无法再为其提供权限校验
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
                            |[plugin-system-auth]插件无法处理一个被声明为final的方法:
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