package com.dasoops.dasqr.plugin.auth

import com.dasoops.common.core.IExceptionEnum
import com.dasoops.common.core.exception.ProjectExceptionEntity

/**
 * 初始化异常(152xx)
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class InitException(override val message: String) : IExceptionEnum {
    UNCREATE_LISTENER_HOST_INSTANCE_FOR_OBJECT(
        """
            [plugin-system-auth]插件无法处理一个object类型的ListenerHost
                - 将其声明为open class,并保持一个无参构造,插件会生成该类的实例并为其提供权限校验
                - 将配置项auth.skipObjectInstance设置为true可以忽略这个错误,但插件无法再为其提供权限校验
        """.trimIndent()
    ),

    ;

    override val code: Int = 15200 + ordinal
    override fun get() = InitExceptionEntity(this)
}

open class InitExceptionEntity(exceptionEnum: InitException, message: String = exceptionEnum.message) : ProjectExceptionEntity(exceptionEnum, message)