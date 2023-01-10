package com.dasoops.dasserver.cq.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.IRedisHashKeyEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.cq.entity.enums.ConfigKeyEnum;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.entity.enums.ConfigHashKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Title: ConfigCache
 * @ClassPath com.dasoops.dasserver.cq.cache.ConfigCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 配置缓存
 */
@Service
@Slf4j
public class ConfigCache extends BaseCache {

    private final ConfigService configService;

    public ConfigCache(StringRedisTemplate stringRedisTemplate, ConfigService configService) {
        super(stringRedisTemplate);
        this.configService = configService;
    }

    @PostConstruct
    public void initOrUpdate() {
        initOrUpdateConfig();
    }

    /**
     * 初始化配置
     */
    public void initOrUpdateConfig() {
        log.info("初始化/更新 配置项 缓存");
        super.remove(ConfigKeyEnum.CONFIG);

        List<ConfigDo> configList = configService.list();
        Assert.getInstance().dbExecuteReturnMustNotNull(configList);
        configList.forEach(config -> super.hset(ConfigKeyEnum.CONFIG, config.getKeyword(), config.getValue()));
    }

    public void setConfig(ConfigHashKeyEnum configHashKeyEnum, String value) {
        super.hset(ConfigKeyEnum.CONFIG, configHashKeyEnum.getKey(), value);
    }

    public String getConfig(IRedisHashKeyEnum configHashKeyEnum) {
        String value = super.hget(ConfigKeyEnum.CONFIG, configHashKeyEnum.getKey());
        Assert.getInstance().ifNull(value, () -> {
            throw new LogicException(ExceptionEnum.REDIS_DATA_NOT_NULL);
        });
        return value;
    }

    public Integer getIntegerConfig(IRedisHashKeyEnum configHashKeyEnum){
        return Integer.valueOf(this.getConfig(configHashKeyEnum));
    }

    public Long getLongConfig(IRedisHashKeyEnum configHashKeyEnum){
        return Long.valueOf(this.getConfig(configHashKeyEnum));
    }

    public String getStringConfig(IRedisHashKeyEnum configHashKeyEnum){
        return this.getConfig(configHashKeyEnum);
    }
}
