package com.dasoops.dasqr.plugin.bilibili

import com.dasoops.common.core.entity.dataenum.DataEnum
import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import org.ktorm.schema.int
import org.ktorm.schema.long

/**
 * BilibiliDao
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [BilibiliSubscriberDao]
 */
object BilibiliSubscriberDao : BaseDao<BilibiliSubscribeDo, BilibiliSubscribes>(BilibiliSubscribes)

object BilibiliSubscribes : DasTable<BilibiliSubscribeDo>("plugin_bilibili_subscriber") {
    val registerRowId = long("register_row_id").bindTo { it.registerRowId }
    val targetId = long("target_id").bindTo { it.targetId }
    val dynamicType = dataEnum<DynamicType>("dynamic_type").bindTo { it.dynamicType }
    val intervalMinute = int("interval_minute").bindTo { it.intervalMinute }
}

interface BilibiliSubscribeDo : DasEntity<BilibiliSubscribeDo> {
    var registerRowId: Long
    var targetId: Long
    var dynamicType: DynamicType
    var intervalMinute: Int

    companion object : DasEntity.Factory<BilibiliSubscribeDo>()
}

enum class DynamicType : DataEnum {
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