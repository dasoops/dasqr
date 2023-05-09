package com.dasoops.dasqr.core.config

/**
 * Dasqr配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class DasqrConfig(
    val exception: ExceptionConfig,
    val plugin: PluginConfig,
)

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class PluginConfig(
    scanPath: List<String>?,
) {

    /**
     * 扫描路径
     */
    val scanPath: List<String>

    init {
        this@PluginConfig.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core", "com.dasoops.dasqr.plugin")
    }
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class ExceptionConfig(
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
        this@ExceptionConfig.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core")
        this@ExceptionConfig.excludeClass = excludeClass?.ifEmpty { null }
    }
}