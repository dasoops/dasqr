package com.dasoops.dasserver.plugin.authwrapper.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum;
import com.dasoops.dasserver.entity.enums.AuthRedisKeyAuthListShamEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: RegisterMtmPluginCache
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.cache.RegisterMtmPluginCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 注册mtm插件缓存
 */
@Component
public class AuthWrapperRegisterMtmPluginCache extends BaseCache {

    public AuthWrapperRegisterMtmPluginCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    public void setAuthMap(Long registerRowId, Map<Long, Integer> pluginIdIsPassMap) {
        AuthRedisKeyAuthListShamEnum redisKeyEnum = new AuthRedisKeyAuthListShamEnum(registerRowId);
        super.remove(redisKeyEnum);
        Map<String, String> valueMap = Convert.toStrMap(pluginIdIsPassMap);
        super.hset(redisKeyEnum, valueMap);
    }

    public boolean getPluginIsPassByRegisterRowIdAndPluginId(Long registerId, Long pluginId) {
        AuthRedisKeyAuthListShamEnum redisKeyEnum = new AuthRedisKeyAuthListShamEnum(registerId);
        String isPass = super.hget(redisKeyEnum, String.valueOf(pluginId));
        if (isPass == null || "".equals(isPass)) {
            throw new LogicException(ExceptionEnum.REDIS_DATA_NOT_NULL);
        }
        //判断是否为TRUE
        return Integer.valueOf(isPass).equals(RegisterMtmPluginIsPassEnum.TRUE.getDbValue());
    }

    public Map<Long, Boolean> getAuthList(Long registerId) {
        AuthRedisKeyAuthListShamEnum redisKeyEnum = new AuthRedisKeyAuthListShamEnum(registerId);
        Map<String, String> entries = super.entries(redisKeyEnum);
        //判断是否为TRUE
        return entries.entrySet().stream().collect(Collectors.toMap(
                entry -> Long.valueOf(entry.getKey()),
                entry -> Integer.valueOf(entry.getValue()).equals(RegisterMtmPluginIsPassEnum.TRUE.getDbValue())
        ));
    }
}
