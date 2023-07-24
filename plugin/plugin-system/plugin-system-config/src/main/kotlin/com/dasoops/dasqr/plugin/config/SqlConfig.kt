package com.dasoops.dasqr.plugin.config

import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.config.Config
import org.flywaydb.core.Flyway
import org.slf4j.LoggerFactory

/**
 * sql配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
open class SqlConfig : Config {
    override lateinit var keywordToJsonConfigMap: Map<String, String>

    private val log = LoggerFactory.getLogger(javaClass)

    //Map<keyword,config>
    lateinit var keywordToConfigMap: Map<String, ConfigDo>

    override fun init() {
        keywordToConfigMap = ConfigDao.findAll().associateBy { it.keyword }
        keywordToJsonConfigMap = keywordToConfigMap.mapValues { it.value.value }
        Flyway.configure()
        log.info("config init:${keywordToJsonConfigMap.toJsonStr()}")
    }

    override fun addAndInit(key: String, description: String, configStr: String) {
        ConfigDao.add(ConfigDo {
            this.keyword = key
            this.value = configStr
            this.description = description
        })
        init()
    }
}