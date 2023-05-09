package com.dasoops.dasqr.plugin.config

import cn.hutool.extra.spring.SpringUtil
import com.dasoops.common.json.parse
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.DasqrProperties
import com.dasoops.dasqr.core.config.MiraiProperties
import org.slf4j.LoggerFactory

/**
 * sql配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object SqlConfig : Config {
    override lateinit var mirai: MiraiProperties
    override lateinit var dasqr: DasqrProperties

    private val log = LoggerFactory.getLogger(javaClass)

    //Map<keyword,config>
    lateinit var keywordToConfigMap: Map<String, com.dasoops.dasqr.plugin.config.Config>

    val configDao = ConfigDao.INSTANCE

    override fun init() {
        keywordToConfigMap = configDao.findAll().associateBy { it.keyword }

        log.info(
            """
            |load config form : ${SpringUtil.getProperty("spring.datasource.url")} -> core_config
        """.trimMargin()
        )
        initMirai()
        initDasqr()
    }

    fun initMirai() {
        val value = keywordToConfigMap["mirai"]?.value ?: throw ConfigPluginExceptionEntity(
            ConfigPluginException.NO_RECORD,
            "没有查询到配置记录 -> keyword = mirai"
        )

        log.info("loading mirai configuration: $value".trimIndent())

        mirai = value.parse(MiraiProperties::class.java)
    }

    fun initDasqr() {
        val value = keywordToConfigMap["dasqr"]?.value ?: throw ConfigPluginExceptionEntity(
            ConfigPluginException.NO_RECORD,
            "没有查询到配置记录 -> keyword = dasqr"
        )

        log.info("loading dasqr configuration: $value".trimIndent())

        dasqr = value.parse(DasqrProperties::class.java)
    }
}