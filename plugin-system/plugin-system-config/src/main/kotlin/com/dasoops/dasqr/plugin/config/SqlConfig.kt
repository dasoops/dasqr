package com.dasoops.dasqr.plugin.config

import com.dasoops.common.json.parse
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.DasqrProperties
import com.dasoops.dasqr.core.config.MiraiProperties

/**
 * sql配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object SqlConfig : Config {
    override lateinit var mirai: MiraiProperties
    override lateinit var dasqr: DasqrProperties

    //Map<keyword,config>
    lateinit var keywordToConfigMap: Map<String, com.dasoops.dasqr.plugin.config.Config>

    val configDao = ConfigDao.INSTANCE

    override fun init() {
        keywordToConfigMap = configDao.findAll().associateBy { it.keyword }
        initMirai()
        initDasqr()
    }

    fun initMirai() {
        mirai = keywordToConfigMap["mirai"]?.value?.parse(MiraiProperties::class.java) ?: throw ConfigPluginExceptionEntity(
            ConfigPluginException.NO_RECORD,
            "没有查询到配置记录 -> keyword = mirai"
        )
    }

    fun initDasqr() {
        dasqr = keywordToConfigMap["dasqr"]?.value?.parse(DasqrProperties::class.java) ?: throw ConfigPluginExceptionEntity(
            ConfigPluginException.NO_RECORD,
            "没有查询到配置记录 -> keyword = dasqr"
        )
    }
}