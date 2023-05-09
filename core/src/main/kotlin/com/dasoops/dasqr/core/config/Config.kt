package com.dasoops.dasqr.core.config

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.common.json.parse

/**
 * 配置接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
interface Config {
    val keywordToJsonConfigMap: Map<String, String>
    val mirai: MiraiConfig
        get() = getOrNull<MiraiConfig>("mirai")!!
    val dasqr: DasqrConfig
        get() = getOrNull<DasqrConfig>("dasqr")!!

    fun init()

    companion object {
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
}