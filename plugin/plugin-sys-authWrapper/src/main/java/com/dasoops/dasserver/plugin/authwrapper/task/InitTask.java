package com.dasoops.dasserver.plugin.authwrapper.task;

import com.dasoops.common.exception.BaseCustomException;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.plugin.authwrapper.cache.PluginCache;
import com.dasoops.dasserver.plugin.authwrapper.cache.RegisterMtmPluginCache;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 初始化任务
 */
@Component
public class InitTask {

    private final RegisterService registerService;
    private final RegisterMtmPluginService registerMtmPluginService;
    private final RegisterMtmPluginCache registerMtmPluginCache;
    private final PluginCache pluginCache;

    public InitTask(RegisterService registerService, RegisterMtmPluginService registerMtmPluginService, RegisterMtmPluginCache registerMtmPluginCache, PluginCache pluginCache) {
        this.registerService = registerService;
        this.registerMtmPluginService = registerMtmPluginService;
        this.registerMtmPluginCache = registerMtmPluginCache;
        this.pluginCache = pluginCache;
    }

    /**
     * 初始化或更新
     */
    public void initOrUpdate() {
        Optional<CqTemplate> cqTemplateOpt = CqGlobal.findFirst();
        if (cqTemplateOpt.isEmpty()) {
            throw new BaseCustomException(CqExceptionEnum.CQ_GLOBAL_EMPTY);
        }
        CqTemplate cqTemplate = cqTemplateOpt.get();

        initOrUpdateRegisterList(cqTemplate);
        initOrUpdateRegisterMtmPluginList();
    }

    /**
     * 初始化或更新 注册集合
     */
    private void initOrUpdateRegisterList(CqTemplate cqTemplate) {
        registerService.initOrUpdateRegisterList(cqTemplate);
    }

    /**
     * 初始化或更新注册多对多插件集合
     */
    private void initOrUpdateRegisterMtmPluginList() {
        registerMtmPluginService.initOrUpdateRegisterMtmPluginList();
        registerMtmPluginCache.initOrUpdateAuthMap();
        pluginCache.initOrUpdatePluginClassNameIdMap();
    }

}
