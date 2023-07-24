package com.dasoops.dasqr.plugin.reply

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.varchar

/**
 * 消息日志Dao
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
object ImageDao : BaseDao<Image, Images>(Images)

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object Images : DasTable<Image>("plugin_image") {
    val keyword = varchar("keyword").bindTo { it.keyword }
    val fileName = varchar("file_name").bindTo { it.fileName }
    val groupId = long("group_id").bindTo { it.groupId }
}

interface Image : DasEntity<Image> {

    /**
     * 关键字
     */
    var keyword: String

    /**
     * 匹配类型
     */
    var fileName: String

    /**
     * 匹配类型
     */
    var groupId: Long

    companion object : DasEntity.Factory<Image>()
}