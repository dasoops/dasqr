package com.dasoops.dasqr.core.config

/**
 * Dasqr配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class DasqrProperties(
    val exception: ExceptionProperties,
    val plugin: PluginProperties,
)

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class PluginProperties(
    scanPath: List<String>?,
) {

    /**
     * 扫描路径
     */
    val scanPath: List<String>

    init {
        this@PluginProperties.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core", "com.dasoops.dasqr.plugin")
    }
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class ExceptionProperties(
    scanPath: List<String>?,
    excludeClass: List<String>?
) {
    /**
     * 扫描路径
     */
    val scanPath: List<String>

    /**
     * 排除类
     */
    val excludeClass: List<String>?

    init {
        this@ExceptionProperties.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core")
        this@ExceptionProperties.excludeClass = excludeClass?.ifEmpty { null }
    }
}