package com.dasoops.dasserver.plugin.authwrapper.task;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.cq.task.CqCoreInitTask;
import com.dasoops.dasserver.plugin.authwrapper.cache.PluginCache;
import com.dasoops.dasserver.plugin.authwrapper.cache.RegisterMtmPluginCache;
import com.dasoops.dasserver.plugin.authwrapper.service.RegisterMtmPluginAuthWrapperService;
import org.springframework.stereotype.Component;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 初始化任务
 */
@Component
public class AuthInitTask {

    private final RegisterService registerService;
    private final RegisterMtmPluginAuthWrapperService registerMtmPluginWsWrapperService;
    private final RegisterMtmPluginCache registerMtmPluginCache;
    private final PluginCache pluginCache;
    private final CqCoreInitTask cqCoreInitTask;

    public AuthInitTask(RegisterService registerService, RegisterMtmPluginAuthWrapperService registerMtmPluginWsWrapperService, RegisterMtmPluginCache registerMtmPluginCache, PluginCache pluginCache, CqCoreInitTask cqCoreInitTask) {
        this.registerService = registerService;
        this.registerMtmPluginWsWrapperService = registerMtmPluginWsWrapperService;
        this.registerMtmPluginCache = registerMtmPluginCache;
        this.pluginCache = pluginCache;
        this.cqCoreInitTask = cqCoreInitTask;
    }

    /**
     * 初始化或更新
     */
    public void initOrUpdateAll(CqTemplate cqTemplate) {
        initOrUpdateRegisterList(cqTemplate);
        initOrUpdateRegisterMtmPluginList();
    }

    /**
     * 初始化或更新 注册集合
     */
    public void initOrUpdateRegisterList(CqTemplate cqTemplate) {
        registerService.initOrUpdateRegisterList(cqTemplate);
    }

    /**
     * 初始化或更新注册表多对多插件集合
     */
    public void initOrUpdateRegisterMtmPluginList() {
        registerMtmPluginWsWrapperService.initOrUpdateRegisterMtmPluginList();
        cqCoreInitTask.initOrUpdateAll();
        registerMtmPluginCache.initOrUpdateAuthIdOtmIsPassMap2Cache();
        pluginCache.initOrUpdatePluginClassNameOtoIdMap2Cache();
    }

}
