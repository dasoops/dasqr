package com.dasoops.common.entity.enums.base

enum class BaseRedisKeyEnum(private val key: String) : IRedisKeyEnum {

    /**
     * 核心
     */
    CORE("core:"),

    /**
     * 插件
     */
    PLUGIN("plugin:"),

    /**
     * 注册表
     */
    REGISTER("${CORE}register:"),

    /**
     * 配置
     */
    CONFIG("${CORE}config:"),

    /**
     * 系统级插件(默认增强等)
     */
    SYS_PLUGIN("${CORE}plugin:"),

    /**
     * 权限
     */
    AUTH("${CORE}auth:"),
    ;

    override fun getKey(): String {
        return key;
    }

    override fun toString(): String {
        return key;
    }


}