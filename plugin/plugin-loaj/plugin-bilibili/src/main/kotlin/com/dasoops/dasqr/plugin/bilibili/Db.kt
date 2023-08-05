package com.dasoops.dasqr.plugin.bilibili

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import com.dasoops.common.json.core.dataenum.IntDataEnum
import org.ktorm.schema.long

/**
 * 消息日志Dao
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object SubscribeDao : BaseDao<Subscribe, Subscribes>(Subscribes)

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object Subscribes : DasTable<Subscribe>("plugin_bilibili_subscriber") {
    val subscribeId = long("subscribe_id").bindTo { it.subscribeId }
    val registerId = long("register_id").bindTo { it.registerId }
    val registerType = dataEnum<RegisterType>("register_type").bindTo { it.registerType }
    val messageType = dataEnum<MessageType>("message_type").bindTo { it.messageType }
}

interface Subscribe : DasEntity<Subscribe> {
    /**
     * 订阅对象id
     */
    var subscribeId: Long

    /**
     * 注册对象id
     */
    var registerId: Long

    /**
     * 注册类型
     */
    var registerType: RegisterType

    /**
     * 动态类型
     */
    var messageType: MessageType

    companion object : DasEntity.Factory<Subscribe>()
}

enum class RegisterType : IntDataEnum {
    GROUP, USER
    ;

    override val data = ordinal
}


enum class MessageType : IntDataEnum {
    SHARE {
        override fun match(instance: Dynamic) = instance is Share
    },
    ORIGINAL {
        override fun match(instance: Dynamic) = instance is Video || instance is Message
    },
    ORIGINAL_VIDEO {
        override fun match(instance: Dynamic) = instance is Video
    },
    ORIGINAL_MESSAGE {
        override fun match(instance: Dynamic) = instance is Message
    },
    ALL {
        override fun match(instance: Dynamic) = true
    },
    ;

    abstract fun match(instance: Dynamic): Boolean
    override val data = ordinal
}