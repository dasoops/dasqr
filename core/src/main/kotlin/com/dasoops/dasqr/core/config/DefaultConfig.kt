package com.dasoops.dasqr.core.config

import cn.hutool.core.io.FileUtil
import com.dasoops.common.json.Json
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
    override lateinit var mirai: MiraiProperties
    override lateinit var dasqr: DasqrProperties

    override fun init() {
        val configJson = FileUtil.file(System.getProperty("user.dir") + "/config.json").readText()
        val loadByPath = Json.parse(configJson, ConfigModelImpl::class.java)
        log.info(
            """
            |load config form : ${System.getProperty("user.dir")}${File.separator}config.json
            |$configJson
        """.trimMargin()
        )

        mirai = loadByPath.mirai
        dasqr = loadByPath.dasqr
    }
}