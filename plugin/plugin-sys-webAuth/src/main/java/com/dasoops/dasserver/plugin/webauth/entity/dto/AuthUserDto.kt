package com.dasoops.dasserver.plugin.webauth.entity.dto

/**
 * @title: AuthUserDto
 * @classPath com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/01
 * @version 1.0.0
 * @description 身份验证用户dto
 * @see [AuthUserDto]
 */
data class AuthUserDto(
    /**
     * rowId
     */
    val rowId: Long?,

    /**
     * 注册者id
     */
    val registerId: Long?,

    /**
     * 名字
     */
    val name: String?,
) {
}