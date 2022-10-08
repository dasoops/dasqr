package com.dasoops.common.exception.entity;

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
        this.exceptionCodeEnum = exceptionCodeEnum;
        this.code = exceptionCodeEnum.getCode();
        this.msg = exceptionCodeEnum.getDescription();
        this.id = System.currentTimeMillis();
    }

    public BaseCustomException(Long id, ExceptionCodeEnum exceptionCodeEnum) {
        this.exceptionCodeEnum = exceptionCodeEnum;
        this.code = exceptionCodeEnum.getCode();
        this.msg = exceptionCodeEnum.getDescription();
        this.id = id;
    }
}
