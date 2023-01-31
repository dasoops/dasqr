package com.dasoops.dasserver.plugin.recall.entity.enums

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum
import com.dasoops.common.entity.enums.base.IRedisKeyEnum

enum class RecallRedisKeyEnum(private val key: String) : IRedisKeyEnum {

    RECORD(RecallRedisKeyEnum.basePath + "record"),
    ;

    override fun getKey(): String {
        return key;
    }

    companion object {
        private val basePath = BaseRedisKeyEnum.PLUGIN.getKey() + "recall:";
    }
}