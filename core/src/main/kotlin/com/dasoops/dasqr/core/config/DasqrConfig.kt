package com.dasoops.dasqr.core.config

/**
 * Dasqr配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class DasqrConfig(
    exception: ExceptionConfig? = null,
    plugin: PluginConfig? = null,
) {
    val exception: ExceptionConfig
    val plugin: PluginConfig

    init {
        this.exception = exception ?: ExceptionConfig()
        this.plugin = plugin ?: PluginConfig()
    }
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class PluginConfig(
    scanPath: List<String>? = null,
) {

    /**
     * 扫描路径
     */
    val scanPath: List<String>

    init {
        this.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core", "com.dasoops.dasqr.plugin")
    }
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class ExceptionConfig(
    scanPath: List<String>? = null,
    excludeClass: List<String>? = null
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
        this.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core")
        this.excludeClass = excludeClass?.ifEmpty { null }
    }
}