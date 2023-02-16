package com.dasoops.dasserver.plugin.webmanager.entity.vo.register

import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel

/**
 * @title LoginVo
 * @classPath com.dasoops.imageManagerServer.user.model.vo.LoginVo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/26
 * @version 1.0.0
 * @description 登录vo
 */
@Api("Register")
@ApiModel("登录Vo")
data class LoginVo(
    /**
     * 令牌
     */
    var token: String,

    /**
     * 注册表id
     */
    var registerId: Long,

    /**
     * 名字
     */
    var name: String
)