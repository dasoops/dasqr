package com.dasoops.dasserver.plugin.webauth.entity.dto

/**
 * @Title: AuthUserDto
 * @ClassPath com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/01
 * @Version 1.0.0
 * @Description: 身份验证用户dto
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