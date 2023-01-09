package com.dasoops.dasserver.plugin.authwrapper.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.entity.enums.PluginRedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: PluginCache
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.cache.PluginCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 插件缓存
 * @see BaseCache
 */
@Component
@Slf4j
public class AuthWrapperPluginCache extends BaseCache {


    public AuthWrapperPluginCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    public void setPluginClassPathIdMap(Map<String, Long> pluginClassPathIdMap) {
        super.remove(PluginRedisKeyEnum.PLUGIN_CALSSPATH_OTO_ID);
        Map<String, String> valueMap = pluginClassPathIdMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> String.valueOf(entry.getValue())
        ));
        super.hset(PluginRedisKeyEnum.PLUGIN_CALSSPATH_OTO_ID, valueMap);
    }

    public Long getIdByPluginClassPath(String classPath) {
        String value = super.hget(PluginRedisKeyEnum.PLUGIN_CALSSPATH_OTO_ID, classPath);
        if (value == null || value.isEmpty()) {
            log.error("classPath:{},not found id",classPath);
            throw new LogicException(ExceptionEnum.REDIS_DATA_NOT_NULL);
        }
        return Long.valueOf(value);
    }
}
