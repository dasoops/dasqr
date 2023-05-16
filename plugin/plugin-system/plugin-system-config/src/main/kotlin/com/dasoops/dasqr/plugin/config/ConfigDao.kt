package com.dasoops.dasqr.plugin.config

import com.dasoops.common.db.ktorm.BaseDao
import org.springframework.stereotype.Component

@Component
class ConfigDao : BaseDao<ConfigDo, Configs>(Configs) {

    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: ConfigDao
    }
}