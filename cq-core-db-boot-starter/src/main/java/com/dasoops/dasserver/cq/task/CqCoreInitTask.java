package com.dasoops.dasserver.cq.task;

import com.dasoops.common.task.BaseTask;
import com.dasoops.dasserver.cq.CqPluginGlobal;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @title InitTask
 * @classPath com.dasoops.dasserver.cq.task.InitTask
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 初始化任务
 */
@Component
@RequiredArgsConstructor
public class CqCoreInitTask extends BaseTask {

    private final RegisterService registerService;
    private final PluginService pluginService;
    private final ConfigService configService;

    @PostConstruct
    public void initOrUpdateAll() {
        CqPluginGlobal.setReslover(2147483646, applicationContext ->
                pluginService.getAllLoadDbCqPlugin().stream().collect(Collectors.toMap(
                        cqPlugin -> cqPlugin.getRawPlugin().getClass().getName(), // 1. actual String as KEY
                        cqPlugin -> cqPlugin,  // 2. String length as their VALUE
                        (key1, key2) -> key1, // 3. duplicate KEY resolver
                        LinkedHashMap::new // 4. implementation-class
                ))
        );
        CqPluginGlobal.refresh();
        configService.initOrUpdateConfig();
        configService.updateLocalVersionFromCloudVersion();
        configService.initOrUpdateFastFailImage();
    }
}
