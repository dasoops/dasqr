package com.dasoops.core.util;

import com.dasoops.core.entity.enums.ExceptionEnum;
import com.dasoops.core.entity.enums.IExceptionEnum;
import com.dasoops.core.exception.BaseCustomException;

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

    public static void buildDbExecuteReturnIsZero() {
        throw new BaseCustomException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_ZERO);
    }

    public static void buildIsTrue() {
        throw new BaseCustomException(ExceptionEnum.IS_TRUE);
    }

    public static void buildIsFalse() {
        throw new BaseCustomException(ExceptionEnum.IS_FALSE);
    }

    public static void buildNoCqConnection() {
        throw new BaseCustomException(ExceptionEnum.NO_CQ_CONNECTION);
    }

    public static void buildRedisDataNotNull() {
        throw new BaseCustomException(ExceptionEnum.REDIS_DATA_NOT_NULL);
    }

    public static void buildDbExecuteReturnNotNull() {
        throw new BaseCustomException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_NULL);
    }

    public static void buildDbExecuteReturnNotFalse() {
        throw new BaseCustomException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_FALSE);
    }

    public static void buildCqReturnFailed(String message) {
        throw new BaseCustomException(ExceptionEnum.CQ_RETURN_FAILED, message);
    }

    public static void buildPluginNotFount() {
        throw new BaseCustomException(ExceptionEnum.PLUGIN_NOT_FOUNT);
    }

    public static void buildPluginNotFount(String message) {
        throw new BaseCustomException(ExceptionEnum.PLUGIN_NOT_FOUNT, message);
    }
}
