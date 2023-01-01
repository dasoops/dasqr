package com.dasoops.dasserver.plugin.authwrapper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;

/**
 * @Title: AuthWrapperPluginService
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperPluginService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: 身份验证条件构造器插件服务
 * @see IService
 */
public interface AuthWrapperPluginService extends IService<PluginDo> {
    /**
     * 初始化或更新插件类名字单对单id map toCache
     */
    void initOrUpdatePluginClassNameOtoIdMap2Cache();
}
