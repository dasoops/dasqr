package com.dasoops.dasserver.cq.exception;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import com.dasoops.common.exception.AbstractBaseCustomException;
import com.dasoops.common.exception.LogicException;

/**
 * @title: CqLogicException
 * @classPath com.dasoops.dasserver.cq.exception.CqLogicException
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description cq逻辑异常
 * @see AbstractBaseCustomException
 */
public class CqLogicException extends LogicException {
    /**
     * 错误信息
     */

    public CqLogicException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }


    public CqLogicException(Exception exception) {
        super(exception);
    }

    public CqLogicException(IExceptionEnum exceptionEnum, String stackMessage) {
        super(exceptionEnum, stackMessage);
    }

    public CqLogicException(IExceptionEnum exceptionEnum, Exception exception) {
        super(exceptionEnum, exception);
    }
}
