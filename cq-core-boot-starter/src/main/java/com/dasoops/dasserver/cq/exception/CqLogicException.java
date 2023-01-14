package com.dasoops.dasserver.cq.exception;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import com.dasoops.common.exception.AbstractBaseCustomException;
import com.dasoops.common.exception.LogicException;

/**
 * @Title: CqLogicException
 * @ClassPath com.dasoops.dasserver.cq.exception.CqLogicException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: cq逻辑异常
 * @see AbstractBaseCustomException
 */
public class CqLogicException extends LogicException {
    public CqLogicException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public CqLogicException(Exception exception) {
        super(exception);
    }

    public CqLogicException(IExceptionEnum exceptionEnum, String stackMessage) {
        super(exceptionEnum, stackMessage);
    }

    public CqLogicException(IExceptionEnum exceptionEnum, Exception e) {
        super(exceptionEnum, e);
    }
}
