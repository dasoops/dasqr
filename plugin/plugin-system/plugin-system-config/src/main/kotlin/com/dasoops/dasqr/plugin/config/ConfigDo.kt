package com.dasoops.dasqr.plugin.config

import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import org.ktorm.schema.varchar

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object Configs : DasTable<ConfigDo>("plugin_system_config") {
    val keyword = varchar("keyword").bindTo { it.keyword }
    val value = varchar("value").bindTo { it.value }
    val description = varchar("description").bindTo { it.description }
}

interface ConfigDo : DasEntity<ConfigDo> {
    /**
     * 关键词
     */
    var keyword: String

    /**
     * 配置信息
     */
    var value: String

    /**
     * 描述
     */
    var description: String

    companion object : DasEntity.Factory<ConfigDo>()
}
