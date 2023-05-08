package com.dasoops.dasqr.plugin.config

import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import org.ktorm.schema.varchar

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object Configs : DasTable<Config>("core_config") {
    val keyword = varchar("keyword").bindTo { it.keyword }
    val value = varchar("value").bindTo { it.value }
    val description = varchar("description").bindTo { it.description }
}

interface Config : DasEntity<Config> {
    /**
     * 堆栈信息
     */
    var keyword: String

    /**
     * 顶层消息
     */
    var value: String

    /**
     * 异常类型
     */
    var description: String

    companion object : DasEntity.Factory<Config>()
}
