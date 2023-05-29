package com.dasoops.dasqr.plugin.pluginManager.auth

import com.dasoops.dasqr.core.listener.DasqrSimpleListenerHost
import com.dasoops.dasqr.core.listener.DslEventHandlerMetaData
import com.dasoops.dasqr.core.listener.DslListenerHost
import net.bytebuddy.ByteBuddy
import net.bytebuddy.implementation.MethodDelegation
import net.bytebuddy.implementation.bind.annotation.*
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.GroupMessageSubscribersBuilder
import net.mamoe.mirai.event.ListenerHost
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.event.events.MessageEvent
import java.lang.reflect.Method
import java.util.concurrent.Callable

/**
 * 代理
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 */
object AuthProxy {
    open class AuthProxyAdvice {
        companion object {
            @JvmStatic
            @RuntimeType
            fun onMethodEnter(
                @Origin method: Method,
                @This listenerHost: ListenerHost,
                @AllArguments allArguments: Array<Any>,
                @SuperCall zuper: Callable<*>,
            ): Any? {
                return if (Auth.auth(method, listenerHost, allArguments[0] as MessageEvent)) {
                    zuper.call()
                } else {
                    null
                }
            }
        }
    }

    fun proxyInstance(clazz: Class<DasqrSimpleListenerHost>): DasqrSimpleListenerHost {
        return ByteBuddy()
            .subclass(clazz)
            .name("${clazz.name}$\$SysAuth")
            .method {
                it.declaredAnnotations.isAnnotationPresent(EventHandler::class.java)
            }
            .intercept(MethodDelegation.to(AuthProxyAdvice::class.java))
            .make()
            .load(Thread.currentThread().contextClassLoader)
            .loaded.getConstructor().newInstance()
    }
}