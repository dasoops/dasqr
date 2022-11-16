package com.dasoops.common.entity.enums;

/**
 * @Title: IRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.core.entity.enums.IRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: redisKeyEnum
 */
public interface IRedisKeyEnum {

    /**
     * 核心
     */
    String CORE = "core:";
    /**
     * 核心配置
     */
    String CONFIG = CORE + "config:";
    /**
     * 插件
     */
    String PLUGIN = "plugin:";
    /**
     * 系统级插件(默认增强等)
     */
    String CORE_SYS_PLUGIN = CORE + "sys:plugin:";

    /**
     * 获取key
     *
     * @return {@link String}
     */
    String getKey();

}
