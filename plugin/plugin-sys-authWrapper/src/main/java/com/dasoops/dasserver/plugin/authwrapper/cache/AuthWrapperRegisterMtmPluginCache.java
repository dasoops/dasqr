package com.dasoops.dasserver.plugin.authwrapper.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.BaseRedisKeyEnum;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
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

    private final RegisterMtmPluginService registerMtmPluginService;

    public AuthWrapperRegisterMtmPluginCache(StringRedisTemplate stringRedisTemplate, RegisterMtmPluginService registerMtmPluginService) {
        super(stringRedisTemplate);
        this.registerMtmPluginService = registerMtmPluginService;
    }

    public void setAuthMap(Long registerRowId, Map<Long, Integer> pluginIdIsPassMap) {
        super.remove4Prefix(BaseRedisKeyEnum.AUTH.getKey());
        AuthRedisKeyAuthListShamEnum redisKeyEnum = new AuthRedisKeyAuthListShamEnum(registerRowId);
        Map<String, String> valueMap = Convert.toStrMap(pluginIdIsPassMap);
        super.hset(redisKeyEnum, valueMap);
    }

    public boolean getPluginIsPassByRegisterRowIdAndPluginId(Long registerId, Long pluginId) {
        AuthRedisKeyAuthListShamEnum redisKeyEnum = new AuthRedisKeyAuthListShamEnum(registerId);
        String isPass = super.hget(redisKeyEnum, String.valueOf(pluginId));
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
