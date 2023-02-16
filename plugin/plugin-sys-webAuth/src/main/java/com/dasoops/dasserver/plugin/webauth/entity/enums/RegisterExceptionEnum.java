package com.dasoops.dasserver.plugin.webauth.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title LoginExceptionEnum
 * @classPath com.dasoops.imageManagerServer.user.enums.LoginExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/26
 * @version 1.0.0
 * @description 登录异常枚举(100xx)
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
    UNDEFINED_TYPE("未定义的类型")
    ;


    @Override
    public Integer getCode() {
        return 10000 + ordinal();
    }

    @Getter
    final String msg;
}
