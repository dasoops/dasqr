package com.dasoops.dasserver.plugin.webManager.task;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.plugin.webManager.cache.RegisterWebCache;
import org.springframework.stereotype.Component;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.plugin.webManager.task.InitTask
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
        registerWebCache.initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate);
    }
}
