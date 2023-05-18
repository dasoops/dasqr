package com.dasoops.dasqr.core.config

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.common.json.parse
import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.runner.InitRunner
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 配置接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
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
            val config = Finder.get<Config>(listOf("com.dasoops.dasqr"), null)
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

/**
 * 配置类模型实现
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
internal class ConfigModelImpl(
    override val mirai: MiraiConfig,
    override val dasqr: DasqrConfig,
    override val keywordToJsonConfigMap: Map<String, String>
) : Config {
    override fun init() {
        //nothing
    }

    override fun addAndInit(key: String, description: String, configStr: String) {
        //nothing
    }
}