package com.dasoops.dasserver.plugin.webmanager.task;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.plugin.webmanager.cache.RegisterWebCache;
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
public class WebManagerInitTask {

    private final RegisterWebCache registerWebCache;

    public WebManagerInitTask(RegisterWebCache registerWebCache) {
        this.registerWebCache = registerWebCache;
    }

    public void initOrUpdateAll(CqTemplate cqTemplate) {
        initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate);
    }

    public void initOrUpdateRegisterIdOtoNameMap2Cache(CqTemplate cqTemplate) {
        registerWebCache.initOrUpdateRegisterRowIdOtoNameMap2Cache(cqTemplate);
    }
}