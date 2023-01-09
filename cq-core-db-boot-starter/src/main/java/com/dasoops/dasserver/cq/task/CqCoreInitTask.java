package com.dasoops.dasserver.cq.task;

import com.dasoops.common.task.BaseInitTask;
import com.dasoops.dasserver.cq.CqPluginGlobal;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.cq.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 初始化任务
 */
@Component
@RequiredArgsConstructor
public class CqCoreInitTask extends BaseInitTask {

    private final RegisterService registerService;
    private final PluginService pluginService;

    @PostConstruct
    public void initOrUpdateAll() {
        CqPluginGlobal.setReslover(2147483646, applicationContext ->
                pluginService.getAllLoadPlugin().stream().collect(Collectors.toMap(plugin -> plugin.getClass().getName(), plugin -> plugin))
        );
        CqPluginGlobal.refresh();
        initOrUpdateRegisterIdOtoTypeMap2Cache();
    }


    public void initOrUpdateRegisterIdOtoTypeMap2Cache() {
        registerService.initOrUpdateRegisterIdOtoTypeMap2Cache();
        registerService.initOrUpdateRegisterTypeRegisterIdOtoId2Cache();
    }


}
