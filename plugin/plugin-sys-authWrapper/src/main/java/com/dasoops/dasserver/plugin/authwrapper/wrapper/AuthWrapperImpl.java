package com.dasoops.dasserver.plugin.authwrapper.wrapper;

import com.dasoops.dasserver.cq.bot.AuthWrapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.plugin.authwrapper.utils.AuthUtil;
import com.dasoops.dasserver.plugin.authwrapper.cache.RegisterMtmPluginCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Title: AuthWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.entity.wrapper.AuthWrapperImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: 身份验证实现impl
 * @see AuthWrapper
 */
@Component
public class AuthWrapperImpl implements AuthWrapper {

    private final PluginService pluginService;
    private final RegisterService registerService;
    private final RegisterMtmPluginService registerMtmPluginService;
    private final StringRedisTemplate stringRedisTemplate;
    private final RegisterMtmPluginCache registerMtmPluginCache;

    public AuthWrapperImpl(PluginService pluginService, RegisterService registerService, RegisterMtmPluginService registerMtmPluginService, StringRedisTemplate stringRedisTemplate, RegisterMtmPluginCache registerMtmPluginCache) {
        this.pluginService = pluginService;
        this.registerService = registerService;
        this.registerMtmPluginService = registerMtmPluginService;
        this.stringRedisTemplate = stringRedisTemplate;
        this.registerMtmPluginCache = registerMtmPluginCache;
    }

    @Override
    public boolean auth(String classPath) {
        return AuthUtil.auth(classPath);
    }
}