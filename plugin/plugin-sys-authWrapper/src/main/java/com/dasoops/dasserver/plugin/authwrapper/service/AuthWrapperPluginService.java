package com.dasoops.dasserver.plugin.authwrapper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;

/**
 * @title AuthWrapperPluginService
 * @classPath com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperPluginService
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/01
 * @version 1.0.0
 * @description 身份验证条件构造器插件服务
 * @see IService
 */
public interface AuthWrapperPluginService extends IService<PluginDo> {
    /**
     * 初始化或更新插件类名字单对单id map toCache
     */
    void initOrUpdatePluginClassNameOtoIdMap2Cache();
}
