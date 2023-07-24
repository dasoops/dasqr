package com.dasoops.dasqr.core.loader

import org.slf4j.LoggerFactory
import java.io.File
import java.net.URL

/**
 * dasqr启动器
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/17
 */
object DasqrRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    var load = false
    const val PLUGIN_DIR = "./plugin"
    const val PLUGIN_LIB_DIR = "./plugin/libs"

    var loadPluginList: List<DasqrPlugin> = emptyList()
    val pluginJarList = mutableListOf<File>()
    val pluginLibJarList = mutableListOf<File>()

    lateinit var loadUrl: Array<URL>

    fun init() {
        load = true
        loadUrl = loadAllUrl().toTypedArray()
        loadPluginList = initLoadPluginList()
        createAndInitClassLoader(loadUrl)
        log()
    }

    private fun initLoadPluginList(): List<DasqrPlugin> {
        return pluginJarList.map { DasqrPlugin(it) }.toMutableList().run {
            add(CorePackage)
            this
        }
    }

    fun log() {
        log.info(
            "\n" + loadPluginList.joinToString(
                separator = "\n----------------------------------------------\n"
            )
        )
    }

    /**
     * 创建和初始化类加载程序
     * @return [DasqrUrlClassLoader]
     */
    fun createAndInitClassLoader(loadUrl: Array<URL>): DasqrUrlClassLoader {
        return DasqrUrlClassLoader(url = loadUrl).apply {
            Thread.currentThread().contextClassLoader = this
        }
    }

    fun loadAllUrl(): Collection<URL> {
        return mutableListOf<File>().run {
            addAll(loadJar())
//            addAll(loadResources())
            map { it.toURI().toURL() }
        }
    }

    /**
     * 加载jar目录
     * @return [Collection<File>]
     */
    fun loadJar(): Collection<File> {
        pluginJarList.addAll(
            loadJar(File(PLUGIN_DIR))
                .apply { ifEmpty { log.warn("no load plugins") } }
        )
        pluginLibJarList.addAll(
            loadJar(File(PLUGIN_LIB_DIR))
                .apply { ifEmpty { log.warn("no load plugin libs") } }
        )
        return mutableListOf<File>().apply {
            addAll(pluginJarList)
            addAll(pluginLibJarList)
        }
    }

    private fun loadJar(dir: File): Collection<File> {
        if (!dir.exists()) {
            dir.mkdir()
        }
        return dir.listFiles { it ->
            it.isFile && it.extension == "jar"
        }?.toList() ?: emptyList()
    }

    /**
     * 加载资源目录
     * @return [Collection<File>]
     */
    /*fun loadResources(): Collection<File> {
        resourceList.addAll(FileUtil.loopFiles(RESOURCES_DIR))
        return resourceList
    }*/
}