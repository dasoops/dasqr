package com.dasoops.dasqr.plugin.log.exception

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.DasqrProperties
import com.dasoops.dasqr.core.config.MiraiProperties
import org.ktorm.dsl.eq

/**
 * sql配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object SqlConfig : Config {
    override lateinit var mirai: MiraiProperties
    override lateinit var dasqr: DasqrProperties

    val configDao = ConfigDao.INSTANCE

    override fun init() {
        configDao.findAll().first().delete()
        configDao.deleteIf {
            it.rowId eq 1
        }
        //first.delete()
        println("")
    }
}