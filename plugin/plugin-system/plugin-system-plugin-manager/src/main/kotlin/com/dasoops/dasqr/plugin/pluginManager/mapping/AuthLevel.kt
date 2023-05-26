package com.dasoops.dasqr.plugin.pluginManager.mapping;

import com.dasoops.common.core.entity.dataenum.DataEnum

/**
 * 身份验证级别
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 * @see [AuthLevel]
 */
enum class AuthLevel(override val data: Int) : DataEnum {
    SYSTEM(0),
    ROOT(10),
    DEV(20),
    NORMAL(30),
    EXCLUDE(40),
    ;
}