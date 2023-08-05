package com.dasoops.dasqr.core.util

import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import java.util.*
import kotlin.reflect.full.hasAnnotation

/**
 * 程序加载器(ServiceLoader)
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 */
object QuickServiceLoader {
    inline fun <reified T> getAll(excludeClass: Collection<String> = emptyList()): Collection<T> {
        return ServiceLoader.load(T::class.java, Thread.currentThread().contextClassLoader)
            .filter { !excludeClass.contains(it!!::class.java.name) }
            .toList()
    }

    inline fun <reified T> getOne(excludeClass: Collection<String> = emptyList()): T {
        val loadList = ServiceLoader.load(T::class.java, Thread.currentThread().contextClassLoader)
            .filter { !excludeClass.contains(it!!::class.java.name) }
            .toList()

        return if (loadList.size == 1) {
            return loadList.first()
        } else if (loadList.isEmpty()) {
            throw InitExceptionEntity(InitException.NO_FIND_CLASS)
        } else if (loadList.size == 2) {
            //保证必须加载的类有一个实现类
            loadList.first {
                !it!!::class.hasAnnotation<DefaultImpl>()
            }
        } else {
            throw InitExceptionEntity(
                InitException.FIND_MULTI_CLASS, """
                    |扫描到多个加载类,无法从中选择一个
                    |[${loadList.joinToString(",") { it!!::class.java.name }}]
                    |- 将其类名从JavaSpi读取的文件中移除
                    |- 在配置文件中的 exclude-class 字段中排除这个类
                """.trimMargin()
            )
        }
    }

}