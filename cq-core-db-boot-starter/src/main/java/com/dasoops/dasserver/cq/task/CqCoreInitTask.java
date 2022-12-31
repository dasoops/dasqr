package com.dasoops.dasserver.cq.task;

import com.dasoops.dasserver.cq.cache.RegisterCache;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.cq.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 初始化任务
 */
@Component
public class CqCoreInitTask{

    private final RegisterCache registerCache;

    public CqCoreInitTask(RegisterCache registerCache) {
        this.registerCache = registerCache;
    }

    @PostConstruct
    public void initOrUpdateAll() {
        initOrUpdateRegisterIdOtoTypeMap2Cache();
    }

    public void initOrUpdateRegisterIdOtoTypeMap2Cache() {
        registerCache.initOrUpdateRegisterIdOtoTypeMap2Cache();
        registerCache.initOrUpdateRegisterTypeRegisterIdOtoId2Cache();
    }

}
