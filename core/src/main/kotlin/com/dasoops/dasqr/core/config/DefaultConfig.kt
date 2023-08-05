package com.dasoops.dasqr.core.config

import cn.hutool.core.io.FileUtil
import com.dasoops.common.json.core.Json
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.common.json.jackson.Jackson
import com.dasoops.common.json.jackson.parseNode
import com.dasoops.dasqr.core.util.DefaultImpl
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import java.io.File

/**
 * 默认配置实现
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@DefaultImpl
open class DefaultConfig : Config {
    override lateinit var keywordToJsonConfigMap: Map<String, String>

    private val configFile = FileUtil.file(System.getProperty("user.dir") + "/config.json")

    override fun init() {
        val configJson = configFile.readText()
        val loadByPath = Json.parseNode(configJson)
        log.info(
            """
            |load config form : ${System.getProperty("user.dir")}/config.json
            |$configJson
        """.trimMargin()
        )
        keywordToJsonConfigMap = loadByPath.fields().asSequence().map {
            it.key to it.value.toJsonStr()
        }.toMap()
    }

    override fun addAndInit(key: String, description: String, configStr: String) {
        val configNode = Json.parseNode(configFile.readText())
        val jsonStr = configNode.fields().asSequence().map {
            it.key to it.value.toJsonStr()
        }.toMutableList().apply {
            add(key to configStr)
        }.associate { it }.toJsonStr()
        configFile.writeText(jsonStr)
        init()
    }
}