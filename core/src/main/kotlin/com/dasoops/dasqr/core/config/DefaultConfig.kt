package com.dasoops.dasqr.core.config

import cn.hutool.setting.yaml.YamlUtil
import com.dasoops.dasqr.core.DefaultImpl

/**
 * 默认配置实现
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@DefaultImpl
object DefaultConfig : Config {
    override lateinit var mirai: MiraiProperties
    override lateinit var dasqr: DasqrProperties

    override fun init() {
        val loadByPath = YamlUtil.loadByPath("./config.yaml", DefaultConfig::class.java)
        mirai = loadByPath.mirai
        dasqr = loadByPath.dasqr
    }
}