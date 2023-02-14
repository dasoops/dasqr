package com.dasoops.dasserver.plugin.loaj.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.RollRecordRedisKeyShamEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @title: RollCache
 * @classPath com.dasoops.dasserver.plugin.loaj.cache.RollCache
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/08
 * @version 1.0.0
 * @description roll点缓存
 * @see BaseCache
 */
@Component
public class RollCache extends BaseCache {
    private final ConfigCache configCache;

    public RollCache(StringRedisTemplate stringRedisTemplate, ConfigCache configCache) {
        super(stringRedisTemplate);
        this.configCache = configCache;
    }

    /**
     * 添加记录
     *
     * @param groupId 群组id
     * @param userId  用户id
     * @param value   价值
     */
    public void addRecord(Long groupId, Long userId, Integer value) {
        RollRecordRedisKeyShamEnum redisKeyEnum = RollRecordRedisKeyShamEnum.addRecord(groupId, userId);
        super.sadd(redisKeyEnum, String.valueOf(value));
    }

    /**
     * 群组延长到期时间
     *
     * @param groupId 群组id
     */
    public void lengthenGroupExpireTime(Long groupId) {
        RollRecordRedisKeyShamEnum redisKeyEnum = RollRecordRedisKeyShamEnum.expirePrefix(groupId);
        super.expire4Prefix(redisKeyEnum, configCache.getLongConfig(LoajConfigHashKeyEnum.ROLL_RECORD_EFFECTIVE_SECONDS), TimeUnit.SECONDS);
    }

    /**
     * 是否有记录
     *
     * @param groupId 群组id
     * @return boolean
     */
    public boolean hasRecord(Long groupId) {
        RollRecordRedisKeyShamEnum redisKeyEnum = RollRecordRedisKeyShamEnum.hasRecord(groupId);
        return super.keys4Prefix(redisKeyEnum).size() > 0;
    }

    /**
     * 获取所有记录
     *
     * @param groupId 群组id
     * @return {@link Map}<{@link Long}, {@link Set}<{@link Integer}>>
     */
    public Map<Long, Set<Integer>> getAllRecord(Long groupId) {
        RollRecordRedisKeyShamEnum redisKeyEnum = RollRecordRedisKeyShamEnum.getAllRecord(groupId);
        return super.sGetGroupingByPrefix(redisKeyEnum, Long::valueOf, Integer::valueOf);
    }

    /**
     * 删除群组所有记录
     *
     * @param groupId 群组id
     */
    public void removeGroupAllRecord(Long groupId) {
        RollRecordRedisKeyShamEnum redisKeyEnum = RollRecordRedisKeyShamEnum.removeAllGroupRecord(groupId);
        super.remove4Prefix(redisKeyEnum);
    }
}
