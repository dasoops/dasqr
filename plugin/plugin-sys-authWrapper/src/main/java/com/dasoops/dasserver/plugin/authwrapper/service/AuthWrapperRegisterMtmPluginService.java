package com.dasoops.dasserver.plugin.authwrapper.service;

/**
 * @title RegisterMtmPluginAuthWrapper
 * @classPath com.dasoops.dasserver.plugin.authwrapper.service.RegisterMtmPluginAuthWrapper
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 注册mtm插件身份验证条件构造器
 */
public interface AuthWrapperRegisterMtmPluginService {

    /**
     * 初始化或更新注册mtm插件集合
     */
    void initRegisterMtmPluginList();

    /**
     * 初始化或更新身份验证 id单对多插件是否放行 toCache
     */
    void initOrUpdateAuthIdOtmIsPassMap2Cache();
}
