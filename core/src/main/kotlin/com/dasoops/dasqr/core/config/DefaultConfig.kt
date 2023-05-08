package com.dasoops.dasqr.core.config

import cn.hutool.core.io.FileUtil
import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.common.json.Json
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
        val loadByPath = Json.parse(FileUtil.file(System.getProperty("user.dir") + "/config.json").readText(), ConfigImpl::class.java)
        mirai = loadByPath.mirai
        dasqr = loadByPath.dasqr
    }

    @IgnoreResourcesScan
    internal class ConfigImpl(override val mirai: MiraiProperties, override val dasqr: DasqrProperties) : Config {
        override fun init() {
            //nothing
        }
    }
}