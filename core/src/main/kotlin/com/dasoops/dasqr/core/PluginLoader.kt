package com.dasoops.dasqr.core

import cn.hutool.core.io.FileUtil
import cn.hutool.core.util.ClassUtil
import cn.hutool.core.util.ReflectUtil
import com.dasoops.dasqr.core.runner.DasqrProperties
import org.slf4j.LoggerFactory
import org.springframework.boot.loader.LaunchedURLClassLoader
import java.io.File
import java.net.URL
import java.net.URLClassLoader


object PluginLoader {
    private val log = LoggerFactory.getLogger(javaClass)
    fun load() {
        //hutool还真是...什么都有...
        /*JarClassLoader.loadJar(
            this::class.java.classLoader as LaunchedURLClassLoader,
            File(DasqrProperties.plugin.path)
        )*/
        //打个日志,不用hutool包装的
        val addUrl = ClassUtil.getDeclaredMethod(URLClassLoader::class.java, "addURL", URL::class.java)
        addUrl.isAccessible = true
        val classLoader = this::class.java.classLoader as LaunchedURLClassLoader

        FileUtil.loopFiles(File(DasqrProperties.plugin.path), -1) {
            it.isFile && it.extension == "jar"
        }.map {
            ReflectUtil.invoke<Unit>(classLoader, addUrl, it.toURI().toURL())
            log.info("load plugin: ${it.name}")
        }
    }
}