package com.dasoops.common.exception.entity;

import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;

/**
 * @Title: LogicException
 * @ClassPath com.dasoops.dasq.common.exception.entity.LogicException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 逻辑异常(通用异常)
 * @see BaseCustomException
 */
public class LogicException extends BaseCustomException {
    public LogicException(ExceptionCodeEnum exceptionCodeEnum) {
        super(exceptionCodeEnum);
    }

    public LogicException(ExceptionCodeEnum exceptionCodeEnum, Throwable t) {
        super(exceptionCodeEnum, t);
    }

    public LogicException(ExceptionCodeEnum exceptionCodeEnum, String msg) {
        super(exceptionCodeEnum, msg);
    }

    public LogicException(Long id, ExceptionCodeEnum exceptionCodeEnum, String msg) {
        super(id, exceptionCodeEnum, msg);
    }
}
