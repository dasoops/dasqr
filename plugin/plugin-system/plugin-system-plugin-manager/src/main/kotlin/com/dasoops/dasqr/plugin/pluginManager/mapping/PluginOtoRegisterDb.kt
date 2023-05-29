package com.dasoops.dasqr.plugin.pluginManager.mapping

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import com.dasoops.dasqr.plugin.pluginManager.mapping.RegisterDos.bindTo
import org.ktorm.schema.boolean
import org.ktorm.schema.long
import org.ktorm.schema.varchar

/**
 * 插件1对多注册对象表
 */
object PluginOtmRegisterDao : BaseDao<PluginOtmRegisterDo, PluginOtmRegisterDos>(PluginOtmRegisterDos)

object PluginOtmRegisterDos : DasTable<PluginOtmRegisterDo>("plugin_system_plugin_otm_register") {
    val pluginRowId = long("plugin_row_id").bindTo { it.pluginRowId }
    val registerRowId = long("register_row_id").bindTo { it.registerRowId }
    val pass = boolean("pass").bindTo { it.pass }
    val botId = long("bot_id").bindTo { it.botId }
    val userId = long("user_id").bindTo { it.userId }
    val groupId = long("group_id").bindTo { it.groupId }
    val listenerHostClassName = varchar("listener_host_class_name").bindTo { it.listenerHostClassName }
    val listenerHostMethodName = varchar("listener_host_method_name").bindTo { it.listenerHostMethodName }
    val registerType = dataEnum<RegisterType>("register_type").bindTo { it.registerType }
}

interface PluginOtmRegisterDo : DasEntity<PluginOtmRegisterDo> {
    /**
     * 插件主键id
     */
    var pluginRowId: Long

    /**
     * 注册对象主键id
     */
    var registerRowId: Long

    /**
     * 类型
     */
    var pass: Boolean

    /**
     * 机器人主键id
     */
    var botId: Long

    /**
     * 注册对象主键id
     */
    var userId: Long?

    /**
     * 注册对象主键id
     */
    var groupId: Long?

    /**
     * 注册对象主键id
     */
    var listenerHostClassName: String

    /**
     * 注册对象主键id
     */
    var listenerHostMethodName: String

    /**
     * 机器人id
     */
    var registerType: RegisterType

    companion object : DasEntity.Factory<PluginOtmRegisterDo>()
}
