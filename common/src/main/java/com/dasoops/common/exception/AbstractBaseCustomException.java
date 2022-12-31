package com.dasoops.common.exception;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.IExceptionEnum;
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
public abstract class AbstractBaseCustomException extends RuntimeException {

    /**
     * 异常类型枚举
     */
    private IExceptionEnum exceptionEnum;
    /**
     * 错误信息,请传入堆栈异常
     */
    private String stackMessage;

    private AbstractBaseCustomException() {

    }

    public AbstractBaseCustomException(IExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
        this.stackMessage = getStackInfo();
    }

    public AbstractBaseCustomException(Exception exception) {
        if (exception instanceof AbstractBaseCustomException e) {
            this.exceptionEnum = e.getExceptionEnum();
            this.stackMessage = e.getStackMessage();
            return;
        }
        this.exceptionEnum = ExceptionEnum.UN_EXPECTED;
        this.stackMessage = getStackInfo(exception);
    }

    public AbstractBaseCustomException(IExceptionEnum exceptionEnum, String stackMessage) {
        this.exceptionEnum = exceptionEnum;
        this.stackMessage = StrUtil.format("errorData:{}\r\n{}", stackMessage, getStackInfo());
    }

    public AbstractBaseCustomException(IExceptionEnum exceptionEnum, Exception e) {
        this.exceptionEnum = exceptionEnum;
        this.stackMessage = getStackInfo() + cn.hutool.core.exceptions.ExceptionUtil.stacktraceToString(e);
    }

    /**
     * 获取堆栈信息
     *
     * @return {@link String}
     */
    public abstract String getStackInfo();

    /**
     * 从异常获取堆栈信息
     *
     * @param e e
     * @return {@link String}
     */
    public abstract String getStackInfo(Exception e);

}
