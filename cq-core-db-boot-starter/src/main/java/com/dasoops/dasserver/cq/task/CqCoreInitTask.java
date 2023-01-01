package com.dasoops.dasserver.cq.task;

import com.dasoops.dasserver.cq.service.RegisterService;
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
public class CqCoreInitTask {

    private final RegisterService registerService;

    public CqCoreInitTask(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostConstruct
    public void initOrUpdateAll() {
        initOrUpdateRegisterIdOtoTypeMap2Cache();
    }

    public void initOrUpdateRegisterIdOtoTypeMap2Cache() {
        registerService.initOrUpdateRegisterIdOtoTypeMap2Cache();
        registerService.initOrUpdateRegisterTypeRegisterIdOtoId2Cache();
    }

}
