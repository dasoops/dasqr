package com.dasoops.dasserver.plugin.webmanager.entity.param.register

import com.dasoops.common.entity.param.base.BaseParam
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @title LoginParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/01
 * @version 1.0.0
 * @description 登录param
 * @see [LoginParam]
 */
@Api("Register")
@ApiModel(value = "登录param", description = "登录param")
data class LoginParam(
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", notes = "用户名", example = "776465218", required = true)
    val username: String,

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", notes = "密码", example = "776465218", required = true)
    val password: String
) : BaseParam()