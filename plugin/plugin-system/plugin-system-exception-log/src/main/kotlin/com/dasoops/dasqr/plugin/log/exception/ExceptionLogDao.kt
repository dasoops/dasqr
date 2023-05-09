package com.dasoops.dasqr.plugin.log.exception

import com.dasoops.common.db.ktorm.BaseDao
import org.springframework.stereotype.Component

@Component
class ExceptionLogDao : BaseDao<ExceptionLog, ExceptionLogs>(ExceptionLogs) {


    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: ExceptionLogDao
    }

}