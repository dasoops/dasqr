package com.dasoops.dasserver.core.util;

import com.dasoops.dasserver.core.exception.BaseCustomException;
import com.dasoops.dasserver.core.exception.enums.ExceptionEnum;
import com.dasoops.dasserver.core.exception.enums.IExceptionEnum;

/**
 * @Title: ExceptionUtil
 * @ClassPath com.dasoops.dasserver.core.util.ExceptionUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 异常工具类
 */
public class ExceptionUtil {

    public static void build(IExceptionEnum exceptionEnum) {
        throw new BaseCustomException(exceptionEnum);
    }

    public static void buildEmpty() {
        throw new BaseCustomException(ExceptionEnum.UN_EXPECTED);
    }

    public static void buildUnExpected() {
        throw new BaseCustomException(ExceptionEnum.UN_EXPECTED);
    }

    public static void buildParameterIsNull() {
        throw new BaseCustomException(ExceptionEnum.PARAMETER_IS_NULL);
    }

    public static void buildParameterNotNull() {
        throw new BaseCustomException(ExceptionEnum.PARAMETER_NOT_NULL);
    }

    public static void buildParameterOutOfScope() {
        throw new BaseCustomException(ExceptionEnum.PARAMETER_OUT_OF_SCOPE);
    }

    public static void buildDbConnectionError() {
        throw new BaseCustomException(ExceptionEnum.DB_CONNECTION_ERROR);
    }

    public static void buildDbExecuteFailed() {
        throw new BaseCustomException(ExceptionEnum.DB_EXECUTE_FAILED);
    }

    public static void buildDbExecuteResIsZero() {
        throw new BaseCustomException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_ZERO);
    }

    public static void buildIsTrue(){
        throw new BaseCustomException(ExceptionEnum.IS_TRUE);
    }

    public static void buildIsFalse(){
        throw new BaseCustomException(ExceptionEnum.IS_FALSE);
    }


}
