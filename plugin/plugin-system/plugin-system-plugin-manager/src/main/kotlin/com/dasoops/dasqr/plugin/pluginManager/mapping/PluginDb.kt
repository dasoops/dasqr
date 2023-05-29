package com.dasoops.dasqr.plugin.pluginManager.mapping

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
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
    val pluginName = varchar("plugin_name").bindTo { it.pluginName }
    val pluginAuthor = varchar("plugin_author").bindTo { it.pluginAuthor }
    val pluginVersion = varchar("plugin_version").bindTo { it.pluginVersion }
    val pluginDescription = varchar("plugin_description").bindTo { it.pluginDescription }
    val listenerHostClass = varchar("listener_host_class").bindTo { it.listenerHostClass }
    val methodName = varchar("method_name").bindTo { it.methodName }
    val authLevel = dataEnum<AuthLevel>("auth_level").bindTo { it.authLevel }
    val order = int("order").bindTo { it.order }
    val enable = boolean("enable").bindTo { it.enable }
}

interface PluginDo : DasEntity<PluginDo> {
    /**
     * 名称
     */
    var pluginName: String

    /**
     * 作者
     */
    var pluginAuthor: String

    /**
     * 版本
     */
    var pluginVersion: String

    /**
     * 描述
     */
    var pluginDescription: String

    /**
     * 监听器class全路径
     */
    var listenerHostClass: String

    /**
     * 执行方法名
     */
    var methodName: String

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