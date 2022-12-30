package com.dasoops.common.exception;

import com.dasoops.common.entity.enums.IExceptionEnum;

/**
 * @Title: LogicException
 * @ClassPath com.dasoops.common.exception.LogicException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/29
 * @Version 1.0.0
 * @Description: 逻辑异常
 * @see BaseCustomException
 */
public class LogicException extends BaseCustomException{
    public LogicException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
