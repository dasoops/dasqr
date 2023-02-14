package com.dasoops.dasserver.plugin.authwrapper.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.base.PrefixRedisKeyShamEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum;
import com.dasoops.dasserver.plugin.authwrapper.entity.enums.AuthRedisKeyAuthListShamEnum;
import com.dasoops.dasserver.plugin.authwrapper.utils.AuthUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title: RegisterMtmPluginCache
 * @classPath com.dasoops.dasserver.plugin.authwrapper.cache.RegisterMtmPluginCache
 * @date 2022/12/27
 * @description 注册mtm插件缓存
 */
@Component
@Slf4j
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
            log.error("isPass is null in cache,registerId: {},pluginId: {}", registerId, pluginId);
            throw new LogicException(ExceptionEnum.REDIS_DATA_NOT_NULL);
        }
        //判断是否为TRUE
        return Integer.valueOf(isPass).equals(RegisterMtmPluginIsPassEnum.TRUE.getDbValue());
    }

    public Map<Long, Boolean> getAuthMap(Long registerRowId) {
        AuthRedisKeyAuthListShamEnum redisKeyEnum = new AuthRedisKeyAuthListShamEnum(registerRowId);
        Map<String, String> entries = super.entries(redisKeyEnum);
        //判断是否为TRUE
        return convertAuthMap(entries);
    }

    private Map<Long, Boolean> convertAuthMap(Map<String, String> authMap) {
        return authMap.entrySet().stream().collect(Collectors.toMap(
                entry -> Long.valueOf(entry.getKey()),
                entry -> Integer.valueOf(entry.getValue()).equals(RegisterMtmPluginIsPassEnum.TRUE.getDbValue())
        ));
    }

    public Map<Long, Map<Long, Boolean>> getAuthMap() {
        var entries4Prefix = super.entries4Prefix(new PrefixRedisKeyShamEnum(AuthRedisKeyAuthListShamEnum.getBasePath()));
        //判断是否为TRUE
        return entries4Prefix.entrySet().stream().collect(Collectors.toMap(
                entry -> AuthUtil.resloveRowId(entry.getKey()),
                entry -> convertAuthMap(entry.getValue())
        ));
    }
}
