package com.dasoops.dasqr.plugin.pluginManager.mapping

import com.dasoops.common.core.entity.dataenum.DataEnum
import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import org.ktorm.schema.long

/**
 * 插件表Dao
 */
object RegisterDao : BaseDao<RegisterDo, RegisterDos>(RegisterDos)

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object RegisterDos : DasTable<RegisterDo>("plugin_system_register") {
    val userId = long("user_id").bindTo { it.userId }
    val groupId = long("group_id").bindTo { it.groupId }
    val type = dataEnum<RegisterType>("type").bindTo { it.type }
    val authLevel = dataEnum<AuthLevel>("auth_level").bindTo { it.authLevel }
    val botId = long("bot_id").bindTo { it.botId }
}

interface RegisterDo : DasEntity<RegisterDo> {
    /**
     * 用户id
     */
    var userId: Long

    /**
     * 群组id
     */
    var groupId: Long

    /**
     * 类型
     */
    var type: RegisterType

    /**
     * 权限等级
     */
    var authLevel: AuthLevel

    /**
     * 机器人id
     */
    var botId: Long

    companion object : DasEntity.Factory<RegisterDo>()
}

/**
 * 注册对象类型
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 * @see [RegisterType]
 */
enum class RegisterType : DataEnum {
    FRIEND, USER_IN_GROUP, GROUP;

    override val data = ordinal
}
