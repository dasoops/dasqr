package com.dasoops.dasqr.plugin.config

import com.dasoops.common.db.ktorm.BaseDao
import org.ktorm.dsl.eq
import org.springframework.stereotype.Component

@Component
class ConfigDao : BaseDao<Config, Configs>(Configs) {

    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: ConfigDao
    }
}