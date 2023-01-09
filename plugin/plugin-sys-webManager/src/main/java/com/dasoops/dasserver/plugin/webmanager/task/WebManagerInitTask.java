package com.dasoops.dasserver.plugin.webmanager.task;

import com.dasoops.common.task.BaseInitTask;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService;
import org.springframework.stereotype.Component;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 初始化任务
 */
@Component
public class WebManagerInitTask extends BaseInitTask {

    private final RegisterWebService registerWebService;

    public WebManagerInitTask(RegisterWebService registerWebService) {
        this.registerWebService = registerWebService;
    }


    public void initOrUpdateAll(CqTemplate cqTemplate) {
        initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate);
    }

    public void initOrUpdateRegisterIdOtoNameMap2Cache(CqTemplate cqTemplate) {
        registerWebService.initOrUpdateRegisterRowIdOtoNameMapAndRegisterUserIdOtoNameMap2Cache(cqTemplate);
    }
}
