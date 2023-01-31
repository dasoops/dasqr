package com.dasoops.dasserver.plugin.recall.cache

import com.dasoops.common.cache.BaseCache
import com.dasoops.dasserver.plugin.recall.entity.enums.RecallRedisKeyEnum
import lombok.extern.slf4j.Slf4j
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
@Slf4j
class RecallCache(stringRedisTemplate: StringRedisTemplate?) : BaseCache(stringRedisTemplate) {
    fun clear() {
        super.remove(RecallRedisKeyEnum.RECORD);
    }

    fun get(groupId: Long): Long? {
        val messageIdStr = super.hget(RecallRedisKeyEnum.RECORD, groupId.toString());
        return messageIdStr?.toLong();
    }

    fun set(groupId: Long, messageId: Long) {
        super.hset(RecallRedisKeyEnum.RECORD, groupId.toString(), messageId.toString())
    }
}