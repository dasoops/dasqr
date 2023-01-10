package com.dasoops.dasserver.plugin.sleep;

import com.dasoops.common.cache.BaseCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Title: SleepCache
 * @ClassPath com.dasoops.dasserver.plugin.sleep.SleepCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 睡眠缓存
 * @see BaseCache
 */
@Component
@Slf4j
public class SleepCache extends BaseCache {

    private static final String FLAG = "zzZZZZzzzzzz...";

    public SleepCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    public void setGroupSleepTime(Long groupId, Long time, TimeUnit timeUnit) {
        setSleepTime(false, groupId, time, timeUnit);
    }

    public void setUserSleepTime(Long userId, Long time, TimeUnit timeUnit) {
        setSleepTime(false, userId, time, timeUnit);
    }

    public void setSleepTime(boolean isGroup, Long registerId, Long time, TimeUnit timeUnit) {
        SleepRedisKeyShamEnum redisKeyEnum = SleepRedisKeyShamEnum.build(isGroup, registerId);
        super.setAndExpire(redisKeyEnum, FLAG, time, timeUnit);
    }

    public void sleep(boolean isGroup, Long registerId, Long time, TimeUnit timeUnit) {
        setSleepTime(isGroup, registerId, time, timeUnit);
    }

    public boolean isSleep(boolean isGroup, Long registerId) {
        SleepRedisKeyShamEnum redisKeyEnum = SleepRedisKeyShamEnum.build(isGroup, registerId);
        String value = super.get(redisKeyEnum);
        return value != null && value.equals(FLAG);
    }

    public void removeFlag(boolean isGroup, Long registerId) {
        SleepRedisKeyShamEnum redisKeyEnum = SleepRedisKeyShamEnum.build(isGroup, registerId);
        super.remove(redisKeyEnum);
    }
}
