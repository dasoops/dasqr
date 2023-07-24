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
    var exception: ExceptionConfig
    var plugin: PluginConfig
    var init: InitConfig

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
    var excludeClass: Collection<String>

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
    scanPath: Collection<String>? = null
) {

    /**
     * 排除类
     */
    var excludeClass: Collection<String>
    var scanPathList: Collection<String>

    init {
        this.excludeClass = excludeClass ?: emptyList()
        this.scanPathList = scanPath ?: listOf("com.dasoops.dasqr")
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
    var excludeClass: Collection<String>

    init {
        this.excludeClass = excludeClass ?: emptyList()
    }
}