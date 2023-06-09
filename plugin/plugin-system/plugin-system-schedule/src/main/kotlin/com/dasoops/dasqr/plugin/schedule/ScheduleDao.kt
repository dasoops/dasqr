package com.dasoops.dasqr.plugin.schedule

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import org.ktorm.schema.boolean
import org.ktorm.schema.varchar

/**
 * 定时任务dao
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [ScheduleDao]
 */
object ScheduleDao : BaseDao<ScheduleDo, Schedules>(Schedules)

object Schedules : DasTable<ScheduleDo>("plugin_system_schedule") {
    val cron = varchar("cron").bindTo { it.cron }
    val `class` = varchar("class").bindTo { it.`class` }
    val description = varchar("description").bindTo { it.description }
    val paramJson = varchar("param_json").bindTo { it.paramJson }
    val enable = boolean("enable").bindTo { it.enable }
}

interface ScheduleDo : DasEntity<ScheduleDo> {
    var cron: String
    var `class`: String
    var description: String
    var paramJson: String?
    var enable: Boolean

    companion object : DasEntity.Factory<ScheduleDo>()
}