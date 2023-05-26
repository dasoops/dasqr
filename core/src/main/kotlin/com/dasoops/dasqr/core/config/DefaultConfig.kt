package com.dasoops.dasqr.core.config

import cn.hutool.core.io.FileUtil
import com.dasoops.common.json.Json
import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.util.DefaultImpl
import org.slf4j.LoggerFactory
import java.io.File

/**
 * 默认配置实现
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@DefaultImpl
open class DefaultConfig : Config {

    private val log = LoggerFactory.getLogger(javaClass)
    override lateinit var keywordToJsonConfigMap: Map<String, String>

    private val configFile = FileUtil.file(System.getProperty("user.dir") + "/config.json")

    override fun init() {
        val configJson = configFile.readText()
        val loadByPath = Json.parse(configJson)
        log.info(
            """
            |load config form : ${System.getProperty("user.dir")}${File.separator}config.json
            |$configJson
        """.trimMargin()
        )
        keywordToJsonConfigMap = loadByPath.mapValues { it.value.toJsonStr() }
    }

    override fun addAndInit(key: String, description: String, configStr: String) {
        val configNode = Json.parse(configFile.readText())
        configNode[key] = configStr
        configFile.writeText(Json.toJsonStr(configNode))
        init()
    }
}