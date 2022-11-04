package com.dasoops.core.exception;

import cn.hutool.core.util.StrUtil;
import com.dasoops.core.entity.enums.ExceptionEnum;
import com.dasoops.core.entity.enums.IExceptionEnum;
import com.dasoops.core.util.ExceptionUtil;
import lombok.Getter;

/**
 * @Title: BaseCustomException
 * @ClassPath com.dasoops.core.Exception.BaseCustomException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 基础自定义异常
 */
@Getter
public class BaseCustomException extends RuntimeException {

    /**
     * 异常类型枚举
     */
    private IExceptionEnum exceptionEnum;
    /**
     * 错误信息,请传入堆栈异常
     */
    private String stackMessage;

    private BaseCustomException() {

    }

    public BaseCustomException(IExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
        this.stackMessage = getStackInfo();

    }

    public BaseCustomException(Exception exception) {
        if (exception instanceof BaseCustomException) {
            BaseCustomException e = (BaseCustomException) exception;
            this.exceptionEnum = e.getExceptionEnum();
            this.stackMessage = e.getStackMessage();
            return;
        }
        this.exceptionEnum = ExceptionEnum.UN_EXPECTED;
        this.stackMessage = getStackInfo(exception);
    }

    public BaseCustomException(IExceptionEnum exceptionEnum, String stackMessage) {
        this.exceptionEnum = exceptionEnum;
        this.stackMessage = StrUtil.format("errorData:{}\r\n{}", stackMessage, getStackInfo());
    }

    /**
     * 得到当前堆栈信息
     *
     * @return {@link String}
     */
    private String getStackInfo() {
        final int excludeLine = 5;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        //未知异常情况
        if (stackTrace.length <= excludeLine) {
            ExceptionUtil.buildUnExpected();
        }
        sb.append(StrUtil.format("ERROR{{}:{}}{}  stack\r\n", exceptionEnum.getCode(), exceptionEnum.getMsg(), stackMessage == null ? "" : stackMessage));
        //排除前5行(断言,异常类信息)
        for (int i = excludeLine; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            sb.append(StrUtil.format("\t at {}.{}({}:{})\r\n", element.getClassName(), element.getMethodName(), element.getClassName(), element.getLineNumber()));
        }
        return sb.toString();
    }

    /**
     * 得到当前堆栈信息
     *
     * @return {@link String}
     */
    private String getStackInfo(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        //未知异常情况
        sb.append(StrUtil.format("ERROR{{}:{}}{}  stack\r\n", exceptionEnum.getCode(), exceptionEnum.getMsg(), stackMessage == null ? "" : stackMessage));
        //排除前5行(断言,异常类信息)
        for (StackTraceElement element : stackTrace) {
            sb.append(StrUtil.format("\t at {}.{}({}:{})\r\n", element.getClassName(), element.getMethodName(), element.getClassName(), element.getLineNumber()));
        }
        return sb.toString();
    }
}
