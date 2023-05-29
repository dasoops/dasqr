package com.dasoops.dasqr.plugin.pluginManager.auth;

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.listener.DasqrListenerHost
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 实例化状态
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 * @see [InstanceStatus]
 */
enum class InstanceStatus {
    IS_OBJECT_SKIP_AUTH {
        override fun <T : DasqrListenerHost> check(clazz: Class<T>) {
            log.warn(
                """
                    |${clazz.name}被声明为object,该插件将跳过权限验证直接执行
                    |如果这在您的预期外,请检查配置项[auth.skipRegisterError]
                    """.trimMargin()
            )
        }

        override fun <T : DasqrListenerHost> instance(clazz: Class<T>): T {
            return clazz.kotlin.objectInstance!!
        }
    },
    IS_OBJECT_ERROR {
        override fun <T : DasqrListenerHost> check(clazz: Class<T>) {
            throw SimpleProjectExceptionEntity(
                """
                    |[plugin-system-plugin-manager]插件无法处理一个object类型的SimpleListenerHost
                    |(${clazz.name})
                    |- 将其声明为open class,并保持一个无参构造,插件会生成该类的实例并为其提供权限校验
                    |- 将配置项[auth.skipRegisterError]设置为true可以忽略这个错误,但插件无法再为其提供权限校验
                """.trimMargin()
            )
        }

        override fun <T : DasqrListenerHost> instance(clazz: Class<T>): T {
            check(clazz)
            throw IllegalStateException()
        }
    },
    NORMAL {
        override fun <T : DasqrListenerHost> instance(clazz: Class<T>): T =
            clazz.getConstructor().newInstance()

    };

    open fun <T : DasqrListenerHost> check(clazz: Class<T>) {

    }

    abstract fun <T : DasqrListenerHost> instance(clazz: Class<T>): T

    val log: Logger = LoggerFactory.getLogger(javaClass)

    companion object {
        fun <T : DasqrListenerHost> forClass(clazz: Class<T>): InstanceStatus =
            if (clazz.kotlin.isOpen && !clazz.kotlin.isAbstract) {
                NORMAL
            } else if (clazz.kotlin.objectInstance != null) {
                //跳过object实例
                if (Config.INSTANCE.auth.skipRegisterError) {
                    IS_OBJECT_SKIP_AUTH
                } else {
                    IS_OBJECT_ERROR

                }
            } else {
                throw SimpleProjectExceptionEntity("undefined instanceStatus")
            }
    }
}