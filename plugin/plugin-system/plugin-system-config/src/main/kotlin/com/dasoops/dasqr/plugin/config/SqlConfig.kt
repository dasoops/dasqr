package com.dasoops.dasqr.plugin.config

import cn.hutool.extra.spring.SpringUtil
import com.dasoops.dasqr.core.config.Config
import org.slf4j.LoggerFactory

/**
 * sql配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object SqlConfig : Config {
    override lateinit var keywordToJsonConfigMap: Map<String, String>

    private val log = LoggerFactory.getLogger(javaClass)

    //Map<keyword,config>
    lateinit var keywordToConfigMap: Map<String, com.dasoops.dasqr.plugin.config.Config>

    val configDao = ConfigDao.INSTANCE

    override fun init() {
        keywordToConfigMap = configDao.findAll().associateBy { it.keyword }
        keywordToJsonConfigMap = keywordToConfigMap.mapValues { it.value.value }

        log.info(
            """
            |load config form : ${SpringUtil.getProperty("spring.datasource.url")} -> core_config
        """.trimMargin()
        )
        checkAndLog()
    }

    override fun addAndInit(key: String, description: String, configStr: String) {
        ConfigDao.INSTANCE.add(Config {
            this.keyword = key
            this.value = configStr
            this.description = description
        })
        init()
    }

    fun checkAndLog() {
        keywordToConfigMap["mirai"]?.value?.also {
            log.info("loading mirai configuration: $it".trimIndent())
        } ?: throw ConfigPluginExceptionEntity(
            ConfigPluginException.NO_RECORD,
            "没有查询到配置记录 -> keyword = mirai"
        )

        keywordToConfigMap["dasqr"]?.value?.also {
            log.info("loading dasqr configuration: $it".trimIndent())
        } ?: throw ConfigPluginExceptionEntity(
            ConfigPluginException.NO_RECORD,
            "没有查询到配置记录 -> keyword = dasqr"
        )
    }
}