package com.dasoops.dasqr.core.runner

import cn.hutool.extra.spring.SpringUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import java.io.File

/**
 * Dasqr配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object DasqrProperties {
    const val PREFIX = "dasqr"
    val exception: ExceptionProperties = SpringUtil.getBean(ExceptionProperties::class.java)
    val plugin: PluginProperties = SpringUtil.getBean(PluginProperties::class.java)
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@ConfigurationProperties(prefix = "${DasqrProperties.PREFIX}.${PluginProperties.PREFIX}")
class PluginProperties//为空代表没输入,给默认值
//排除没有默认值
@ConstructorBinding constructor(
    @Value("\${scan-path}")
    pluginPath: String?,
    @Value("\${load}")
    load: Boolean?,
    @Value("\${scan-path}")
    scanPath: List<String>?,
) {
    /**
     * 扫描路径
     */
    val path: String

    /**
     * 扫描路径
     */
    val load: Boolean

    /**
     * 扫描路径
     */
    val scanPathList: List<String>?

    init {
        //为空代表没输入,给默认值
        this@PluginProperties.path = pluginPath ?: (System.getProperty("user.dir") + File.separator + "plugin")
        this@PluginProperties.load = load ?: true
        this@PluginProperties.scanPathList = scanPath ?: listOf("com.dasoops.dasqr.core", "com.dasoops.dasqr.plugin").ifEmpty { null }
    }

    companion object {
        const val PREFIX = "plugin"
    }
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@ConfigurationProperties(prefix = "${DasqrProperties.PREFIX}.${ExceptionProperties.PREFIX}")
class ExceptionProperties//为空代表没输入,给默认值
//排除没有默认值
@ConstructorBinding constructor(
    @Value("\${scan-path}")
    scanPath: List<String>?,
    @Value("\${exclude-class}")
    excludeClass: List<String>?
) {
    /**
     * 扫描路径
     */
    val scanPathList: List<String>?

    /**
     * 排除类
     */
    val excludeClass: List<String>?

    init {
        this@ExceptionProperties.scanPathList = scanPath ?: listOf("com.dasoops.dasqr.core").ifEmpty { null }
        this@ExceptionProperties.excludeClass = excludeClass?.ifEmpty { null }
    }

    companion object {
        const val PREFIX = "exception"
    }
}