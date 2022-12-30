package com.dasoops.common.cache;

import com.dasoops.common.entity.enums.IRedisHashKeyEnum;
import com.dasoops.common.entity.enums.IRedisKeyEnum;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Title: AbstractBaseCache
 * @ClassPath com.dasoops.dasserver.core.AbstractBaseCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 缓存 基类
 */
public class BaseCache {

    private final StringRedisTemplate stringRedisTemplate;

    public BaseCache(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    protected void remove(IRedisKeyEnum redisKeyEnum) {
        stringRedisTemplate.delete(redisKeyEnum.getKey());
    }

    protected void remove4Prefix(String prefix) {
        Set<String> keys = stringRedisTemplate.keys(prefix + "*");
        if (keys != null && keys.size() > 0){
            stringRedisTemplate.delete(keys);
        }
    }

    protected void set(IRedisKeyEnum redisKeyEnum, String value) {
        stringRedisTemplate.opsForValue().set(redisKeyEnum.getKey(), value);
    }

    protected String get(IRedisKeyEnum redisKeyEnum) {
        return stringRedisTemplate.opsForValue().get(redisKeyEnum.getKey());
    }

    protected Map<String, String> entries(IRedisKeyEnum redisKeyEnum) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        return operations.entries(redisKeyEnum.getKey());
    }

    protected String hget(IRedisKeyEnum redisKeyEnum, IRedisHashKeyEnum redisHashKeyEnum) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        return operations.get(redisKeyEnum.getKey(), redisHashKeyEnum.getKey());
    }

    protected String hget(IRedisKeyEnum redisKeyEnum, String redisHashKey) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        return operations.get(redisKeyEnum.getKey(), redisHashKey);
    }

    protected void hset(IRedisKeyEnum redisKeyEnum, IRedisHashKeyEnum redisHashKeyEnum, String value) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        operations.put(redisKeyEnum.getKey(), redisHashKeyEnum.getKey(), value);
    }

    protected void hset(IRedisKeyEnum redisKeyEnum, String hashKey, String value) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        operations.put(redisKeyEnum.getKey(), hashKey, value);
    }

    protected void hset(IRedisKeyEnum redisKeyEnum, Map<String, String> valueMap) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        operations.putAll(redisKeyEnum.getKey(), valueMap);
    }

    protected void lset(IRedisKeyEnum redisKeyEnum, List<String> valueList) {
        stringRedisTemplate.opsForList().rightPushAll(redisKeyEnum.getKey(), valueList);
    }

    protected List<String> lget(IRedisKeyEnum redisKeyEnum) {
        return stringRedisTemplate.opsForList().range(redisKeyEnum.getKey(), 0, -1);
    }

    protected String lget(IRedisKeyEnum redisKeyEnum, Integer index) {
        return stringRedisTemplate.opsForList().index(redisKeyEnum.getKey(), index);
    }
}
