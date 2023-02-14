package com.dasoops.dasserver.plugin.webmanager.cache

import com.alibaba.fastjson2.JSON
import com.dasoops.common.cache.BaseCache
import com.dasoops.common.util.Convert
import com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerRedisKeyEnum
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class RegisterWebCache(stringRedisTemplate: StringRedisTemplate) : BaseCache(stringRedisTemplate) {

    fun setGroupIdOtmGroupUserIdMap(map: Map<Long, Set<Long>>) {
        val saveMap = map
            .mapKeys { it.key.toString() }
            .mapValues { JSON.toJSONString(it.value) }
        super.hset(WebManagerRedisKeyEnum.GROUP_ID_OTM_GROUP_USER_ID_MAP, saveMap)
    }

    fun getGroupUserIdSetByGroupIdMap(): Map<Long, Set<Long>> {
        return super.entries(WebManagerRedisKeyEnum.GROUP_ID_OTM_GROUP_USER_ID_MAP)
            .mapKeys { it.key.toLong() }
            .mapValues {
                JSON.parseArray(it.value).toList(Long::class.java).toHashSet()
            }
    }

    fun hasGroupUserCache(): Boolean {
        return super.hasKey(WebManagerRedisKeyEnum.GROUP_ID_OTM_GROUP_USER_ID_MAP)
    }
}
