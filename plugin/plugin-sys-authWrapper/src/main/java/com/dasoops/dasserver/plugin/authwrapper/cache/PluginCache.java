package com.dasoops.dasserver.plugin.authwrapper.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.BaseCustomException;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.enums.PluginRedisKeyEnum;
import com.dasoops.dasserver.cq.service.PluginService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
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
public class PluginCache extends BaseCache {

    private final PluginService pluginService;

    public PluginCache(StringRedisTemplate stringRedisTemplate, PluginService pluginService) {
        super(stringRedisTemplate);
        this.pluginService = pluginService;
    }

    public void initOrUpdatePluginClassNameIdMap() {
        //全表
        List<PluginDo> pluginDoList = pluginService.list();
        Map<String, Long> pluginClassPathIdMap = pluginDoList.stream().collect(Collectors.toMap(PluginDo::getClassPath, PluginDo::getId));

        //replace
        super.remove(PluginRedisKeyEnum.PLUGIN_CALSSPATH_OTO_ID);
        setPluginClassPathIdMap(pluginClassPathIdMap);
    }

    public void setPluginClassPathIdMap(Map<String, Long> pluginClassPathIdMap) {
        Map<String, String> valueMap = pluginClassPathIdMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> String.valueOf(entry.getValue())
        ));
        super.hset(PluginRedisKeyEnum.PLUGIN_CALSSPATH_OTO_ID, valueMap);
    }

    public Long getIdByPluginClassPath(String classPath) {
        String value = super.hget(PluginRedisKeyEnum.PLUGIN_CALSSPATH_OTO_ID, classPath);
        if (value == null || value.isEmpty()) {
            throw new BaseCustomException(ExceptionEnum.REDIS_DATA_NOT_NULL);
        }
        return Long.valueOf(value);
    }
}
