package com.dasoops.dasqr.core.config

import com.dasoops.common.core.util.resources.IgnoreResourcesScan

/**
 * 配置接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
interface Config {
    val mirai: MiraiProperties
    val dasqr: DasqrProperties

    fun init()

    companion object {
        lateinit var INSTANCE: Config
    }
}