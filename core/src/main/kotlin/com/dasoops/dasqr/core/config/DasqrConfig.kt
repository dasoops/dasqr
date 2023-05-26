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
    excludeClass: Collection<String>? = null
) {
    /**
     * 排除类
     */
    val excludeClass: Collection<String>

    init {
        this.excludeClass = excludeClass ?: emptyList()
    }
}

/**
 * plugin 配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class PluginConfig(
    excludeClass: Collection<String>? = null,
    scanPathList: Collection<String>? = null
) {

    /**
     * 排除类
     */
    val excludeClass: Collection<String>
    val scanPathList: Collection<String>

    init {
        this.excludeClass = excludeClass ?: emptyList()
        this.scanPathList = scanPathList ?: listOf("com.dasoops.dasqr")
    }
}

/**
 * Exception log 配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class ExceptionConfig(
    excludeClass: Collection<String>? = null
) {
    /**
     * 排除类
     */
    val excludeClass: Collection<String>

    init {
        this.excludeClass = excludeClass ?: emptyList()
    }
}