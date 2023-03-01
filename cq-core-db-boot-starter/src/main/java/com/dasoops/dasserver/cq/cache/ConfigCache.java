package com.dasoops.dasserver.cq.cache;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.entity.enums.ConfigKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
public class ConfigCache extends BaseCache {

    public ConfigCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    public void setConfig(Map<String, String> valueMap) {
        super.remove(ConfigKeyEnum.CONFIG);
        super.hset(ConfigKeyEnum.CONFIG, valueMap);
    }

    public void setConfig(IRedisHashKeyEnum configHashKeyEnum, String value) {
        super.hset(ConfigKeyEnum.CONFIG, configHashKeyEnum.getKey(), value);
    }

    public void setConfig(String keyword, String value) {
        super.hset(ConfigKeyEnum.CONFIG, keyword, value);
    }

    public String getConfig(IRedisHashKeyEnum configHashKeyEnum) {
        String value = super.hget(ConfigKeyEnum.CONFIG, configHashKeyEnum.getKey());
        Assert.ifNull(value, () -> {
            log.error("redis data is null,key is {},hashKey is {}", ConfigKeyEnum.CONFIG.getKey(), configHashKeyEnum.getKey());
            throw new LogicException(ExceptionEnum.REDIS_DATA_NOT_NULL);
        });
        return value;
    }

    public <R> R getConfig(IRedisHashKeyEnum configHashKeyEnum, Function<String, R> convertFunction) {
        String value = getConfig(configHashKeyEnum);
        return convertFunction.apply(value);
    }

    public <R extends IDbColumnEnum> R getEnumConfig(IRedisHashKeyEnum configHashKeyEnum, Class<R> enumClass) {
        Integer integerValue = getIntegerConfig(configHashKeyEnum);
        R[] enumConstants = enumClass.getEnumConstants();
        Optional<R> enumOptional = Arrays.stream(enumConstants).filter(enumConstant -> enumConstant.getDbValue().equals(integerValue)).findFirst();
        if (enumOptional.isEmpty()) {
            throw new LogicException(ExceptionEnum.UNKNOWN_KEYWORD);
        }
        return enumOptional.get();
    }

    public Integer getIntegerConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum, Integer::valueOf);
    }

    public Long getLongConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum, Long::valueOf);
    }

    public Boolean getBooleanConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum, string -> !"0".equals(string));
    }

    public String getStringConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum);
    }

    public List<String> getStringListConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum, str -> StrUtil.split(str, ","));
    }

    public List<Integer> getIntegerListConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum, str -> StrUtil.split(str, ","))
                .stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public List<Long> getLongListConfig(IRedisHashKeyEnum configHashKeyEnum) {
        return getConfig(configHashKeyEnum, str -> StrUtil.split(str, ","))
                .stream().map(Long::valueOf).collect(Collectors.toList());
    }

    public <T> T getJsonConfig(IRedisHashKeyEnum configHashKeyEnum, Class<T> clazz) {
        return getConfig(configHashKeyEnum, str -> JSON.parseObject(str, clazz));
    }
}
