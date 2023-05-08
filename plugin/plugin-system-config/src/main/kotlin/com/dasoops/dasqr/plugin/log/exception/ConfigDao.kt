package com.dasoops.dasqr.plugin.log.exception

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

    fun getAll() {
        this.update(Config {
            this.value = "aoe"
        })
        this.findOne {
            it.keyword eq "aoe"
        }
    }

}