package com.dasoops.dasserver.cq.cache;

import com.dasoops.core.util.Assert;
import com.dasoops.core.util.ExceptionUtil;
import com.dasoops.dasserver.cq.entity.enums.ConfigKeyEnum;
import com.dasoops.dasserver.cq.entity.enums.ConfigEnum;
import com.dasoops.dasserver.cq.service.ConfigService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Title: ConfigCache
 * @ClassPath com.dasoops.dasserver.cq.cache.ConfigCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 配置缓存
 */
@Service
public class ConfigCache {

    private final StringRedisTemplate redisTemplate;
    private final ConfigService configService;

    public ConfigCache(@SuppressWarnings("all") StringRedisTemplate stringRedisTemplate, ConfigService configService) {
        this.redisTemplate = stringRedisTemplate;
        this.configService = configService;
    }

    @PostConstruct
    public void init() {
        setVersion(Integer.parseInt(configService.getConfig(ConfigEnum.VERSION)));
    }

    public String getVersion() {
        String localVersion = redisTemplate.opsForValue().get(ConfigKeyEnum.LOCAL_VERSION.getKey());
        Assert.notNull(localVersion, ExceptionUtil::buildRedisDataNotNull);
        return localVersion;
    }

    public void setVersion(Integer version) {
        redisTemplate.opsForValue().set(ConfigKeyEnum.LOCAL_VERSION.getKey(), String.valueOf(version));
    }
}
