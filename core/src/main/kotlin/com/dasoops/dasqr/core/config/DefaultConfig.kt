package com.dasoops.dasqr.core.config

import cn.hutool.core.io.FileUtil
import com.dasoops.common.json.Json
import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.DefaultImpl
import org.slf4j.LoggerFactory
import java.io.File

/**
 * 默认配置实现
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@DefaultImpl
object DefaultConfig : Config {

    private val log = LoggerFactory.getLogger(javaClass)
    override lateinit var mirai: MiraiConfig
    override lateinit var dasqr: DasqrConfig
    override lateinit var keywordToJsonConfigMap: Map<String, String>

    override fun init() {
        val configJson = FileUtil.file(System.getProperty("user.dir") + "/config.json").readText()
        val loadByPath = Json.parse(configJson)
        log.info(
            """
            |load config form : ${System.getProperty("user.dir")}${File.separator}config.json
            |$configJson
        """.trimMargin()
        )
        keywordToJsonConfigMap = loadByPath.mapValues { it.value.toJsonStr() }

        mirai = loadByPath.get("mirai", MiraiConfig::class.java)
        dasqr = loadByPath.get("dasqr", DasqrConfig::class.java)
    }
}