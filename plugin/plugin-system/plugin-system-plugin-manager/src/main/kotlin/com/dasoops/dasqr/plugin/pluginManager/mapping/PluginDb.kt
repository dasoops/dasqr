package com.dasoops.dasqr.plugin.pluginManager.mapping

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import com.dasoops.dasqr.plugin.pluginManager.mapping.RegisterDos.bindTo
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 * 插件表Dao
 */
object PluginDao : BaseDao<PluginDo, PluginDos>(PluginDos)

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object PluginDos : DasTable<PluginDo>("plugin_system_plugin") {
    val name = varchar("name").bindTo { it.name }
    val another = varchar("another").bindTo { it.another }
    val version = varchar("version").bindTo { it.version }
    val description = varchar("description").bindTo { it.description }
    val listenerHostClass = varchar("listener_host_class").bindTo { it.listenerHostClass }
    val authLevel = dataEnum<AuthLevel>("auth_level").bindTo { it.authLevel }
    val order = int("order").bindTo { it.order }
    val enable = boolean("enable").bindTo { it.enable }
}

interface PluginDo : DasEntity<PluginDo> {
    /**
     * 名称
     */
    var name: String

    /**
     * 作者
     */
    var another: String

    /**
     * 版本
     */
    var version: String

    /**
     * 描述
     */
    var description: String

    /**
     * 监听器class全路径
     */
    var listenerHostClass: String

    /**
     * 权限等级
     */
    var authLevel: AuthLevel

    /**
     * 插件排序
     */
    var order: Int

    /**
     * 是否启用
     */
    var enable: Boolean

    companion object : DasEntity.Factory<PluginDo>()
}