package com.dasoops.dasqr.core.util

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import com.fasterxml.jackson.module.kotlin.isKotlinClass
import java.io.File

fun Resources.get(name: String) =
    File(System.getProperty("user.dir") + "/resources/" + name)

@JvmName("scanBasePath")
fun Resources.scanBasePath(): Collection<Class<*>> {
    val config = Config.INSTANCE.dasqr.plugin
    return scan(config.scanPathList).filter {
        return@filter !config.excludeClass.contains(it.name)
    }
}

@JvmName("scanBasePath_generic")
inline fun <reified T> Resources.scanBasePath(): Collection<Class<*>> {
    return scanBasePath().filter { T::class.java.isAssignableFrom(it) }
}

@JvmName("getOrNull_parameter0")
inline fun <reified T> Resources.getOrNull(): T? =
    Config.INSTANCE.dasqr.plugin.run {
        getOrNull<T>(scanPathList, excludeClass)
    }

@JvmName("getOrNull_parameter2")
inline fun <reified T> Resources.getOrNull(basePath: Collection<String>, excludeClass: Collection<String>): T? {
    val list = Resources.scan(Thread.currentThread().contextClassLoader, basePath)
        .filter {
            T::class.java.isAssignableFrom(it)
        }.filter {
            !excludeClass.contains(it.name)
        }

    return if (list.size == 1) {
        getObjectInstacnce(list.first())
    } else if (list.isEmpty()) {
        null
    } else if (list.size == 2) {
        getObjectInstacnce(list.first {
            //不为默认实现
            !it.isAnnotationPresent(DefaultImpl::class.java)
        })
    } else {
        throw InitExceptionEntity(
            InitException.FIND_MULTI_CLASS, """
                    |扫描到多个加载类,无法从中选择一个
                    |[${list.joinToString(",") { it.name }}]
                    |- 使用 @IgnoreResources 使对象从扫描中排除
                    |- 在配置文件中的 exclude-class 字段中排除这个类
                """.trimMargin()
        )
    }
}

inline fun <reified T> Resources.getObjectInstacnce(clazz: Class<*>): T {
    if (clazz.isKotlinClass()) {
        val objectInstance = clazz.kotlin.objectInstance
        if (objectInstance != null) {
            return objectInstance as T
        }
    }
    if (clazz.kotlin.isOpen && !clazz.kotlin.isAbstract) {
        return clazz.getConstructor().newInstance() as T
    }
    throw InitExceptionEntity(
        InitException.MUST_OBJECT_INSTANCE, """
            |${clazz.name}类必须为kotlin object/open class 对象
            |    - 使用 @IgnoreResources 使对象从扫描中排除
            |    - 在配置文件中的 exclude-class 字段中排除这个类
        """.trimMargin()
    )
}

inline fun <reified T> Resources.getObjectInstacnce(className: String): T {
    return getObjectInstacnce(Class.forName(className, false, Thread.currentThread().contextClassLoader))
}