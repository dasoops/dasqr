package com.dasoops.dasserver.cq.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.ExceptionUtil;
import com.dasoops.dasserver.cq.entity.enums.ConfigKeyEnum;
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.cq.service.ConfigService;
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
public class ConfigCache extends BaseCache {

    private final ConfigService configService;

    public ConfigCache(StringRedisTemplate stringRedisTemplate,ConfigService configService) {
        super(stringRedisTemplate);
        this.configService = configService;
    }

    @PostConstruct
    public void init() {
        initConfig();
    }

    /**
     * 初始化配置
     */
    public void initConfig() {
        super.remove(ConfigKeyEnum.CONFIG);

        List<ConfigDo> configList = configService.list();
        Assert.dbExecuteReturnMustNotNull(configList);
        configList.forEach(config -> {
            super.hset(ConfigKeyEnum.CONFIG,config.getKeyword(),config.getValue());
        });
    }

    public String getConfig(ConfigHashKeyEnum configHashKeyEnum) {
        String value = super.hget(ConfigKeyEnum.CONFIG,configHashKeyEnum.getKey());
        Assert.ifNull(value, ExceptionUtil::buildRedisDataNotNull);
        return value;
    }

    public void setConfig(ConfigHashKeyEnum configHashKeyEnum, String value) {
        super.hset(ConfigKeyEnum.CONFIG,configHashKeyEnum.getKey(),value);
    }
}
