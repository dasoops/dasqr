package com.dasoops.dasqr.plugin.reply

import com.dasoops.common.db.ktorm.BaseDao
import org.springframework.stereotype.Component

/**
 * 消息日志Dao
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@Component
class ReplyDao : BaseDao<Reply, Replys>(Replys) {


    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: ReplyDao
    }
}
