package com.dasoops.dasqr.plugin.reply

import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import com.dasoops.common.db.ktorm.dataEnum
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.varchar

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object Replys : DasTable<Reply>("plugin_reply") {
    val keyword = varchar("keyword").bindTo { it.keyword }
    val matchType = dataEnum<MatchType>("match_type").bindTo { it.matchType }
    val mustAt = boolean("must_at").bindTo { it.mustAt }
    val enabled = boolean("enable").bindTo { it.enable }
    val replyMessage = varchar("reply_message").bindTo { it.replyMessage }
    val order = int("order").bindTo { it.order }
}

interface Reply : DasEntity<Reply> {

    /**
     * 关键字
     */
    var keyword: String

    /**
     * 匹配类型
     */
    var matchType: MatchType

    /**
     * 是否必须包含at
     */
    var mustAt: Boolean

    /**
     * 排序
     */
    var order: Int

    /**
     * 启用
     */
    var enable: Boolean

    /**
     * 回复消息
     */
    var replyMessage: String

    companion object : DasEntity.Factory<Reply>()
}