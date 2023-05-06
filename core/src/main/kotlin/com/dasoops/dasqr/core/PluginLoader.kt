package com.dasoops.dasqr.core

import com.dasoops.common.core.util.resources.Resources
import com.dasoops.dasqr.core.runner.properties.DasqrProperties
import org.slf4j.LoggerFactory

/**
 * 插件加载程序
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object PluginLoader {

    private val log = LoggerFactory.getLogger(javaClass)

    val loadList = mutableSetOf<DasqrListenerHost>()

    fun load() {
        //loadJar()
        loadPlugin()
    }

    @Deprecated("使用MyLauncher方案")
    fun loadJar() {
        //hutool还真是...什么都有...
        /*JarClassLoader.loadJar(
            this::class.java.classLoader as LaunchedURLClassLoader,
            File(DasqrProperties.plugin.path)
        )*/
        /*if (!DasqrProperties.plugin.load) {
            log.warn("unload plugin jar, if not in development please check your configuration yaml")
            return
        }*/

        ////打个日志,不用hutool包装的
        //val addUrl = ClassUtil.getDeclaredMethod(URLClassLoader::class.java, "addURL", URL::class.java)
        //addUrl.isAccessible = true
        //val classLoader = this::class.java.classLoader as LaunchedURLClassLoader
        //
        //FileUtil.loopFiles(File(DasqrProperties.plugin.path), -1) {
        //    it.isFile && it.extension == "jar"
        //}.map {
        //    ReflectUtil.invoke<Unit>(classLoader, addUrl, it.toURI().toURL())
        //    log.info("load plugin jar: ${it.name}")
        //}
        //val context = SpringUtil.getApplicationContext() as AnnotationConfigServletWebServerApplicationContext
        //val refresh = ReflectUtil.getField(AnnotationConfigServletWebServerApplicationContext::class.java, "refreshed")
        //ReflectUtil.setFieldValue(context, refresh, false)
        //context.refresh()
        //log.info("refresh spring application context")
    }

    fun loadPlugin() {
        val scanPathList = DasqrProperties.plugin.scanPathList ?: kotlin.run {
            log.warn("plugin scan path is empty, please check your configuration yaml")
            return
        }
        Resources.scan(*scanPathList.toTypedArray()).filter {
            DasqrListenerHost::class.java.isAssignableFrom(it)
        }.forEach {
            loadList.add(it.kotlin.objectInstance as DasqrListenerHost)
        }
    }
}