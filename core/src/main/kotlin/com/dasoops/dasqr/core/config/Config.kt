package com.dasoops.dasqr.core.config

import com.dasoops.common.json.core.parse
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.util.QuickServiceLoader
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 配置接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
interface Config {
    val log: Logger
        get() = LoggerFactory.getLogger(javaClass)
    val keywordToJsonConfigMap: Map<String, String>
    val mirai: MiraiConfig
        get() = getOrInit<MiraiConfig>(
            keyword = "mirai",
            description = "mirai配置项",
        ) {
            MiraiConfig().toJsonStr()
        }
    val dasqr: DasqrConfig
        get() = getOrInit<DasqrConfig>(
            keyword = "dasqr",
            description = "dasqr配置项",
        ) {
            DasqrConfig().toJsonStr()
        }


    fun init()

    fun addAndInit(key: String, description: String, configStr: String)

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
        fun goInit() {
            //初始化配置项
            log.info("init config")
            val config = QuickServiceLoader.getOne<Config>(emptyList())
            config.init()
            INSTANCE = config
            log.info("use config: ${config.javaClass.name}")
        }

        lateinit var INSTANCE: Config
    }
}

inline fun <reified T> Config.getOrInit(
    keyword: String,
    description: String,
    default: () -> String,
): T {
    getOrNull<T>(keyword)?.run {
        return this
    }
    addAndInit(keyword, description, default())
    log.warn("已初始化[${keyword}]配置项")
    return getOrNull<T>(keyword)!!
}

@JvmName("getOrNull_1")
inline fun <reified T> Config.getOrNull(keyword: String): T? {
    return getOrNull(keyword)?.parse(T::class.java)
}

@JvmName("getOrNull_0")
fun Config.getOrNull(keyword: String): String? = keywordToJsonConfigMap[keyword]