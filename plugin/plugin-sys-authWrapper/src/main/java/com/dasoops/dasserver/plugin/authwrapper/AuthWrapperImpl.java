package com.dasoops.dasserver.plugin.authwrapper;

import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.bot.AuthWrapper;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.entity.retdata.ApiListData;
import com.dasoops.dasserver.cq.entity.retdata.GroupData;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Title: AuthWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.AuthWrapperImpl
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

    public AuthWrapperImpl(PluginService pluginService, RegisterService registerService, RegisterMtmPluginService registerMtmPluginService, StringRedisTemplate stringRedisTemplate) {
        this.pluginService = pluginService;
        this.registerService = registerService;
        this.registerMtmPluginService = registerMtmPluginService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean auth() {

        return false;
    }
}