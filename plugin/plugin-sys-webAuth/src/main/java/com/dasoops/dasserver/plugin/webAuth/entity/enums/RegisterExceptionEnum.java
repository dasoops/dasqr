package com.dasoops.dasserver.plugin.webAuth.entity.enums;

import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: LoginExceptionEnum
 * @ClassPath com.dasoops.imageManagerServer.user.enums.LoginExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 登录异常枚举(101xx)
 * @see IExceptionEnum
 */
@Getter
@AllArgsConstructor
public enum RegisterExceptionEnum implements IExceptionEnum {

    /***/
    AUTH_FAIL(10101, "权限校验失败"),
    LOGIN_FAIL(10102, "用户名或密码错误"),
    NEED_HIGH_LEVEL(10103, "level不支持webManager");

    final Integer code;

    final String msg;

}
