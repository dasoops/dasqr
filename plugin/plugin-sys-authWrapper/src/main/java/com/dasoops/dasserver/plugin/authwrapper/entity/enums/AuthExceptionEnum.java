package com.dasoops.dasserver.plugin.authwrapper.entity.enums;

import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AuthExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.entity.enums.AuthExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 身份验证异常枚举
 * @see Enum
 * @see IExceptionEnum(104xx)
 */
@AllArgsConstructor
@Getter
public enum AuthExceptionEnum implements IExceptionEnum {

    ,;

    final Integer code;
    final String msg;

}
