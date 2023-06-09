package com.dasoops.dasqr.core.config

import com.dasoops.common.json.core.parse
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.util.Loader
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 配置接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
interface Config {
    private val log: Logger
        get() = LoggerFactory.getLogger(javaClass)
    val keywordToJsonConfigMap: Map<String, String>
    val mirai: MiraiConfig
        get() {
            getOrNull<MiraiConfig>("mirai")?.run {
                return this
            }
            addAndInit(
                "mirai", "mirai配置项", MiraiConfig().toJsonStr()
            )
            log.warn("未加载到mirai配置项,已初始化配置,请手动填入相关信息后再使用")
            return getOrNull<MiraiConfig>("mirai")!!
        }
    val dasqr: DasqrConfig
        get() {
            getOrNull<DasqrConfig>("dasqr")?.run {
                return this
            }
            addAndInit(
                "dasqr", "dasqr配置项", DasqrConfig().toJsonStr()
            )
            log.warn("未加载到dasqr配置项,已初始化配置,请手动填入相关信息后再使用")
            return getOrNull<DasqrConfig>("dasqr")!!
        }

    fun init()

    fun addAndInit(key: String, description: String, configStr: String)

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
        fun goInit() {
            //初始化配置项
            log.info("init config")
            val config = Loader.getOne<Config>(emptyList())
            config.init()
            INSTANCE = config
            log.info("use config: ${config.javaClass.name}")
        }

        lateinit var INSTANCE: Config
    }
}

inline fun <reified T> Config.getOrNull(keyword: String): T? {
    return keywordToJsonConfigMap[keyword]?.parse(T::class.java)
}