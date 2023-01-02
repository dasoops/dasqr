package com.dasoops.common.cache;

import com.dasoops.common.entity.enums.IRedisHashKeyEnum;
import com.dasoops.common.entity.enums.IRedisKeyEnum;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Title: BaseCache
 * @ClassPath com.dasoops.common.cache.BaseCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: 基地缓存
 */
public class BaseCache {

    private final StringRedisTemplate stringRedisTemplate;

    public BaseCache(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /* -- Operations Begin -- */

    private ValueOperations<String, String> value() {
        return stringRedisTemplate.opsForValue();
    }

    private ListOperations<String, String> list() {
        return stringRedisTemplate.opsForList();
    }

    private HashOperations<String, String, String> hash() {
        return stringRedisTemplate.opsForHash();
    }

    /* -- Operations End -- */

    /* -- Global Begin -- */

    protected Set<String> keys() {
        return stringRedisTemplate.keys("*");
    }

    protected Set<String> keys(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }

    protected void remove(IRedisKeyEnum redisKeyEnum) {
        stringRedisTemplate.delete(redisKeyEnum.getKey());
    }

    protected void remove4Prefix(String prefix) {
        Set<String> keys = stringRedisTemplate.keys(prefix + "*");
        if (keys != null && keys.size() > 0) {
            stringRedisTemplate.delete(keys);
        }
    }

    protected void expire(IRedisKeyEnum redisKeyEnum, Long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.expire(redisKeyEnum.getKey(), timeout, timeUnit);
    }

    /* -- Global End -- */

    /* -- Value Begin -- */

    protected void set(IRedisKeyEnum redisKeyEnum, String value) {
        value().set(redisKeyEnum.getKey(), value);
    }

    protected String get(IRedisKeyEnum redisKeyEnum) {
        return value().get(redisKeyEnum.getKey());
    }

    protected String getAndDelete(IRedisKeyEnum redisKeyEnum) {
        return value().getAndDelete(redisKeyEnum.getKey());
    }

    /* -- Value End -- */

    /* -- Hash Begin -- */

    protected Map<String, String> entries(IRedisKeyEnum redisKeyEnum) {
        return hash().entries(redisKeyEnum.getKey());
    }

    protected String hget(IRedisKeyEnum redisKeyEnum, IRedisHashKeyEnum redisHashKeyEnum) {
        return hash().get(redisKeyEnum.getKey(), redisHashKeyEnum.getKey());
    }

    protected String hget(IRedisKeyEnum redisKeyEnum, String redisHashKey) {
        return hash().get(redisKeyEnum.getKey(), redisHashKey);
    }

    protected void hset(IRedisKeyEnum redisKeyEnum, IRedisHashKeyEnum redisHashKeyEnum, String value) {
        hash().put(redisKeyEnum.getKey(), redisHashKeyEnum.getKey(), value);
    }

    protected void hset(IRedisKeyEnum redisKeyEnum, String hashKey, String value) {
        hash().put(redisKeyEnum.getKey(), hashKey, value);
    }

    protected void hset(IRedisKeyEnum redisKeyEnum, Map<String, String> valueMap) {
        hash().putAll(redisKeyEnum.getKey(), valueMap);
    }

    protected boolean hhasKey(IRedisKeyEnum redisKeyEnum, String hashKey) {
        return hash().hasKey(redisKeyEnum.getKey(), hashKey);
    }

    protected String hgetAndDelete(IRedisKeyEnum redisKeyEnum, String hashKey) {
        boolean b = this.hhasKey(redisKeyEnum, hashKey);
        if (!b) {
            return null;
        }
        String str = hash().get(redisKeyEnum.getKey(), hashKey);
        hdelete(redisKeyEnum, hashKey);
        return str;
    }

    protected void hdelete(IRedisKeyEnum redisKeyEnum, String hashKey) {
        hash().delete(redisKeyEnum.getKey(), hashKey);
    }

    /* -- Hash End -- */

    /* -- List Begin -- */

    protected void lset(IRedisKeyEnum redisKeyEnum, List<String> valueList) {
        list().rightPushAll(redisKeyEnum.getKey(), valueList);
    }

    protected void lset(IRedisKeyEnum redisKeyEnum, String value) {
        list().rightPush(redisKeyEnum.getKey(), value);
    }

    protected List<String> lget(IRedisKeyEnum redisKeyEnum) {
        return list().range(redisKeyEnum.getKey(), 0, -1);
    }

    protected String lget(IRedisKeyEnum redisKeyEnum, Integer index) {
        return list().index(redisKeyEnum.getKey(), index);
    }

    /* -- List End -- */
}
