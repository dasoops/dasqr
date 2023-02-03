package com.dasoops.dasserver.plugin.webmanager.entity.param.register

import com.dasoops.common.entity.param.base.BaseParam
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @Title: LoginParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/01
 * @Version 1.0.0
 * @Description: 登录param
 * @see [LoginParam]
 */
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