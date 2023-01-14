package com.dasoops.common.entity.enums.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: BaseRedisKeyEnum
 * @ClassPath com.dasoops.common.entity.enums.base.BaseRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: redisKey 基本枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum BaseRedisKeyEnum {

    /**
     * 核心
     */
    CORE("core:"),
    /**
     * 核心配置
     */
    CONFIG(CORE + "config:"),
    /**
     * 注册表
     */
    REGISTER(CORE + "register:"),
    /**
     * 核心插件
     */
    CORE_PLUGIN(CORE + "plugin:"),
    /**
     * 系统级插件(默认增强等)
     */
    SYS_PLUGIN(CORE + "plugin:"),
    /**
     * 权限
     */
    AUTH(CORE + "auth:"),
    /**
     * 插件
     */
    PLUGIN("plugin:"),
    ;

    final String key;

    @Override
    public String toString() {
        return key;
    }
}
