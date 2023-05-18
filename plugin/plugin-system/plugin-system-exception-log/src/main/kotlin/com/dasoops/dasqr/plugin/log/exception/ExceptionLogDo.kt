package com.dasoops.dasqr.plugin.log.exception

import com.dasoops.common.db.ktorm.BaseDao
import com.dasoops.common.db.ktorm.DasEntity
import com.dasoops.common.db.ktorm.DasTable
import org.ktorm.schema.varchar

object ExceptionLogDao : BaseDao<ExceptionLogDo, ExceptionLogs>(ExceptionLogs)

/**
 * 异常日志
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-04
 */
object ExceptionLogs : DasTable<ExceptionLogDo>("core_exception_log") {
    val stackInfo = varchar("stack_info").bindTo { it.stackInfo }
    val topMessage = varchar("top_message").bindTo { it.topMessage }
    val exceptionType = varchar("exception_type").bindTo { it.exceptionType }
}

interface ExceptionLogDo : DasEntity<ExceptionLogDo> {
    /**
     * 堆栈信息
     */
    var stackInfo: String

    /**
     * 顶层消息
     */
    var topMessage: String

    /**
     * 异常类型
     */
    var exceptionType: String

    companion object : DasEntity.Factory<ExceptionLogDo>()
}
