package com.dasoops.dasqr.core.util

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import com.fasterxml.jackson.module.kotlin.isKotlinClass

/**
 * 类查找器(Resources)
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object Finder {

    inline fun <reified T> getAll(basePath: Collection<String>, excludeClass: Collection<String>): Collection<T> {
        return Resources.scan(Thread.currentThread().contextClassLoader, *basePath.toTypedArray())
            .filter {
                T::class.java.isAssignableFrom(it)
            }.filter {
                !excludeClass.contains(it.name)
            }.map {
                getObjectInstacnce(it)
            }
    }

    /**
     * 查找实体类
     * @return [T]
     */
    inline fun <reified T> getOrNull(basePath: Collection<String>, excludeClass: Collection<String>): T? {
        val list = Resources.scan(Thread.currentThread().contextClassLoader, *basePath.toTypedArray())
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

    inline fun <reified T> get(basePath: Collection<String>, excludeClass: Collection<String>): T {
        return getOrNull<T>(basePath, excludeClass) ?: throw InitException.NO_FIND_CLASS.get()
    }

    inline fun <reified T> getObjectInstacnce(clazz: Class<*>): T {
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

    inline fun <reified T> getObjectInstacnce(className: String): T {
        return getObjectInstacnce(Class.forName(className, false, Thread.currentThread().contextClassLoader))
    }
}
