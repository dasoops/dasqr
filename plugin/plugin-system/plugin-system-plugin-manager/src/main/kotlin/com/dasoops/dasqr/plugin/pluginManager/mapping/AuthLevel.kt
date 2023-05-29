package com.dasoops.dasqr.plugin.pluginManager.mapping;

import com.dasoops.common.core.entity.dataenum.DataEnum

/**
 * 身份验证级别
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 * @see [AuthLevel]
 */
enum class AuthLevel(override val data: Int) : DataEnum {
    /**
     * 系统级,不应该有该权限的用户/插件
     */
    SYSTEM(0),

    /**
     * root级
     */
    ROOT(10),

    /**
     * 开发者
     */
    DEV(20),

    /**
     * 高级别用户
     */
    ADMIN(30),

    /**
     * 普通用户(默认插件级别)
     */
    NORMAL(40),

    /**
     * 排除(默认用户级别)
     */
    EXCLUDE(50),
    ;

    companion object {
        /**
         * 是否有权限
         * 用户权限.data <= 插件权限.data
         */
        fun isAuth(plugin: AuthLevel, register: AuthLevel) = register.data <= plugin.data
    }

}