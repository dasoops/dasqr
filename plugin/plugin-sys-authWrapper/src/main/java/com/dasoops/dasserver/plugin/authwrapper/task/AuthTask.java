package com.dasoops.dasserver.plugin.authwrapper.task;

import com.dasoops.common.task.BaseInitTask;
import com.dasoops.dasserver.cq.CqPluginGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.bot.CqPluginLoadReslover;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperPluginService;
import com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperRegisterMtmPluginService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthInitTask extends BaseInitTask {

    private final RegisterService registerService;
    private final AuthWrapperRegisterMtmPluginService authWrapperRegisterMtmPluginService;
    private final AuthWrapperPluginService authWrapperPluginService;


    /**
     * 初始化或更新
     */
    public void initOrUpdateAll(CqTemplate cqTemplate) {
        initOrUpdateRegisterList(cqTemplate);
        initOrUpdateRegisterMtmPluginList();
        initPluginGlobalReslover();
    }

    private void initPluginGlobalReslover() {
        CqPluginLoadReslover reslover = CqPluginGlobal.getReslover();
        CqPluginGlobal.setReslover(2147483645, applicationContext -> {
            initOrUpdateRegisterMtmPluginList();
            return reslover.refresh(applicationContext);
        });

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
        authWrapperRegisterMtmPluginService.initOrUpdateRegisterMtmPluginList();
        authWrapperRegisterMtmPluginService.initOrUpdateAuthIdOtmIsPassMap2Cache();
        authWrapperPluginService.initOrUpdatePluginClassNameOtoIdMap2Cache();
    }

}
