package com.dasoops.dasserver.plugin.webmanager.entity.vo.register

/**
 * @Title: LoginVo
 * @ClassPath com.dasoops.imageManagerServer.user.model.vo.LoginVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 登录vo
 */
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