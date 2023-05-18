package com.dasoops.dasqr.core.config

/**
 * Dasqr配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class DasqrConfig(
    exception: ExceptionConfig? = null,
    plugin: PluginConfig? = null,
    init: InitConfig? = null
) {
    val exception: ExceptionConfig
    val plugin: PluginConfig
    val init: InitConfig

    init {
        this.exception = exception ?: ExceptionConfig()
        this.plugin = plugin ?: PluginConfig()
        this.init = init ?: InitConfig()
    }
}

/**
 * 初始化配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [InitConfig]
 */
class InitConfig(
    scanPath: Collection<String>? = null,
    excludeClass: Collection<String>? = null
) {
    /**
     * 扫描路径
     */
    val scanPath: Collection<String>

    /**
     * 排除类
     */
    val excludeClass: Collection<String>?

    init {
        this.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core", "com.dasoops.dasqr.plugin")
        this.excludeClass = excludeClass?.ifEmpty { null }
    }
}

/**
 * plugin 配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class PluginConfig(
    scanPath: Collection<String>? = null,
    excludeClass: Collection<String>? = null
) {

    /**
     * 扫描路径
     */
    val scanPath: Collection<String>

    /**
     * 排除类
     */
    val excludeClass: Collection<String>?

    init {
        this.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core", "com.dasoops.dasqr.plugin")
        this.excludeClass = excludeClass?.ifEmpty { null }
    }
}

/**
 * Exception log 配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class ExceptionConfig(
    scanPath: Collection<String>? = null,
    excludeClass: Collection<String>? = null
) {
    /**
     * 扫描路径
     */
    val scanPath: Collection<String>

    /**
     * 排除类
     */
    val excludeClass: Collection<String>?

    init {
        this.scanPath = scanPath?.ifEmpty { null } ?: listOf("com.dasoops.dasqr.core")
        this.excludeClass = excludeClass?.ifEmpty { null }
    }
}