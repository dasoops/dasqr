package com.dasoops.common.exception;

import com.dasoops.common.entity.enums.IExceptionEnum;

/**
 * @Title: LogicException
 * @ClassPath com.dasoops.common.exception.LogicException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/29
 * @Version 1.0.0
 * @Description: 逻辑异常
 * @see AbstractBaseCustomException
 */
public class WebLogicException extends LogicException {
    public WebLogicException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public WebLogicException(Exception exception) {
        super(exception);
    }

    public WebLogicException(IExceptionEnum exceptionEnum, String stackMessage) {
        super(exceptionEnum, stackMessage);
    }

    public WebLogicException(IExceptionEnum exceptionEnum, Exception e) {
        super(exceptionEnum, e);
    }
}
