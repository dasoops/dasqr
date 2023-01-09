package com.dasoops.dasserver.plugin.authwrapper.service;

/**
 * @Title: RegisterMtmPluginAuthWrapper
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.service.RegisterMtmPluginAuthWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册mtm插件身份验证条件构造器
 */
public interface AuthWrapperRegisterMtmPluginService {

    /**
     * 初始化或更新注册mtm插件集合
     */
    void initOrUpdateRegisterMtmPluginList();

    /**
     * 初始化或更新身份验证 id单对多插件是否放行 toCache
     */
    void initOrUpdateAuthIdOtmIsPassMap2Cache();
}
