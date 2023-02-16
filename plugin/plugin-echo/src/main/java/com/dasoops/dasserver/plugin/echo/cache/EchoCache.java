package com.dasoops.dasserver.plugin.echo.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.dasserver.plugin.echo.entity.enums.RedisKeyShamEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @title ConfigCache
 * @classPath com.dasoops.dasserver.cq.cache.ConfigCache
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/03
 * @version 1.0.0
 * @description 配置缓存
 */
@Service
@Slf4j
public class EchoCache extends BaseCache {

    public EchoCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    @Override
    public Set<String> keys(String keyword) {
        return super.keys(keyword);
    }

    public String get(String key) {
        RedisKeyShamEnum redisKeyShamEnum = new RedisKeyShamEnum(key);
        return super.getJSONString(redisKeyShamEnum);
    }
}
