package com.dasoops.dasserver.plugin.authwrapper.task;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.cq.task.CqCoreInitTask;
import com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperPluginService;
import com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperRegisterMtmPluginService;
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
    private final AuthWrapperRegisterMtmPluginService authWrapperRegisterMtmPluginService;
    private final AuthWrapperPluginService authWrapperPluginService;
    private final CqCoreInitTask cqCoreInitTask;

    public AuthInitTask(RegisterService registerService, AuthWrapperRegisterMtmPluginService authWrapperRegisterMtmPluginService, AuthWrapperPluginService authWrapperPluginService, CqCoreInitTask cqCoreInitTask, PluginService pluginService) {
        this.registerService = registerService;
        this.authWrapperRegisterMtmPluginService = authWrapperRegisterMtmPluginService;
        this.authWrapperPluginService = authWrapperPluginService;
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
        authWrapperRegisterMtmPluginService.initOrUpdateRegisterMtmPluginList2Cache();
        cqCoreInitTask.initOrUpdateAll();
        authWrapperRegisterMtmPluginService.initOrUpdateAuthIdOtmIsPassMap2Cache();
        authWrapperPluginService.initOrUpdatePluginClassNameOtoIdMap2Cache();
    }

}
