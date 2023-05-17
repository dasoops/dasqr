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
    lateinit var keywordToConfigMap: Map<String, ConfigDo>

    override fun init() {
        keywordToConfigMap = configDao.findAll().associateBy { it.keyword }
        keywordToJsonConfigMap = keywordToConfigMap.mapValues { it.value.value }

        log.info(
            """
            |load config form : ${SpringUtil.getProperty("spring.datasource.url")} -> core_config
        """.trimMargin()
        )
    }

    override fun addAndInit(key: String, description: String, configStr: String) {
        ConfigDao.INSTANCE.add(ConfigDo {
            this.keyword = key
            this.value = configStr
            this.description = description
        })
        init()
    }
}