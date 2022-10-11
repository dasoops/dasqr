package com.dasoops.common.exception.entity;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BaseCustomException
 * @ClassPath com.dasoops.dasq.common.exception.entity.BaseCustomException
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 自定义异常基类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseCustomException extends RuntimeException {

    private Long id;
    /**
     * 异常编号枚举
     */
    private ExceptionCodeEnum exceptionCodeEnum;
    /**
     * 编号
     */
    private Integer code;
    /**
     * 错误消息
     */
    private String msg;

    public BaseCustomException(ExceptionCodeEnum exceptionCodeEnum) {
        super(exceptionCodeEnum.getDescription());
        this.exceptionCodeEnum = exceptionCodeEnum;
        this.code = exceptionCodeEnum.getCode();
        this.id = System.currentTimeMillis();
    }

    public BaseCustomException(Long id, ExceptionCodeEnum exceptionCodeEnum, Throwable t) {
        this(id, exceptionCodeEnum, ExceptionUtil.stacktraceToString(t));
    }

    public BaseCustomException(ExceptionCodeEnum exceptionCodeEnum, Throwable t) {
        this(exceptionCodeEnum, ExceptionUtil.stacktraceToString(t));
    }

    public BaseCustomException(ExceptionCodeEnum exceptionCodeEnum, String msg) {
        this(System.currentTimeMillis(), exceptionCodeEnum, msg);
    }

    public BaseCustomException(Long id, ExceptionCodeEnum exceptionCodeEnum, String msg) {
        super(exceptionCodeEnum.getDescription());
        this.exceptionCodeEnum = exceptionCodeEnum;
        this.code = exceptionCodeEnum.getCode();
        this.msg = exceptionCodeEnum.getDescription() + "\r\n\tStack at \r\n" + msg;
        this.id = id;
    }

}
