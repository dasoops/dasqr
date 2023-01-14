package com.dasoops.dasserver.plugin.webauth.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: LoginExceptionEnum
 * @ClassPath com.dasoops.imageManagerServer.user.enums.LoginExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 登录异常枚举(100xx)
 * @see IExceptionEnum
 */
@Getter
@AllArgsConstructor
public enum RegisterExceptionEnum implements IExceptionEnum {

    /**
     * eem快速生成
     */
    AUTH_FAIL("权限校验失败"),
    LOGIN_FAIL("用户名或密码错误"),
    NEED_HIGH_LEVEL("level不支持webManager"),
    ;


    @Override
    public Integer getCode() {
        return 10000 + ordinal();
    }

    @Getter
    final String msg;
}
