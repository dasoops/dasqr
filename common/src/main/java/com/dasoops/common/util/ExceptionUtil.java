package com.dasoops.common.util;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.IExceptionEnum;
import com.dasoops.common.exception.BaseCustomException;

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

    public static void buildImageSaveError() {
        throw new BaseCustomException(ExceptionEnum.IMAGE_SAVE_ERROR);
    }

    public static void buildParameterResloveError() {
        throw new BaseCustomException(ExceptionEnum.PARAMETER_RESLOVE_ERROR);
    }

    public static void buildOcrError(Exception e) {
        throw new BaseCustomException(ExceptionEnum.OCR_ERROR, e);
    }

    public static void buildImagePartSaveKeyNotNull() {
        throw new BaseCustomException(ExceptionEnum.IMAGE_PART_SAVE_KEY_NOT_NULL);
    }

    public static void buildTestException() {
        throw new BaseCustomException(ExceptionEnum.TEST_EXCEPTION);
    }

    public static void buildCrazyException() {
        throw new BaseCustomException(ExceptionEnum.CRAZY_TEST_EXCEPTION);
    }
}
