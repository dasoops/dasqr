package com.dasoops.dasserver.core.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.core.exception.enums.IExceptionEnum;

/**
 * @Title: BaseCustomException
 * @ClassPath com.dasoops.core.Exception.BaseCustomException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 基础自定义异常
 */
public class BaseCustomException extends RuntimeException {

    /**
     * 异常类型枚举
     */
    private IExceptionEnum exceptionEnum;
    /**
     * 错误信息,请传入堆栈异常
     */
    private String message;

    private BaseCustomException() {

    }

    public BaseCustomException(IExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
        this.message = getStackInfo();

    }

    public BaseCustomException(IExceptionEnum exceptionEnum, Exception exception) {
        this.exceptionEnum = exceptionEnum;
        this.message = ExceptionUtil.stacktraceToString(exception, 100000);
    }

    public BaseCustomException(IExceptionEnum exceptionEnum, String message) {
        this.exceptionEnum = exceptionEnum;
        this.message = message;
    }

    /**
     * 重写获取错误信息方法
     *
     * @return {@link String}
     */
    @Override
    public String getMessage() {
        return StrUtil.format("ERROR{{}:{}}  stack of\r\n", exceptionEnum.getCode(), exceptionEnum.getMsg()) + message;
    }

    /**
     * 得到当前堆栈信息
     *
     * @return {@link String}
     */
    private String getStackInfo(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            sb.append(StrUtil.format("\t at {}.{}({}:{})\r\n", element.getClassName(), element.getMethodName(), element.getClassName(), element.getLineNumber()));
        }
        return sb.toString();
    }
}
