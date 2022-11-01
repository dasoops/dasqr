package com.dasoops.dasserver.core.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ExceptionCodeEnum
 * @ClassPath com.dasoops.dasq.common.exception.entity.enums.ExceptionCodeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 异常编号枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum implements IExceptionEnum {

    /**
     * 预料外的异常
     */
    UN_EXPECTED(65535, "预料之外的错误"),

    /**
     * 通用异常
     */
    IS_TRUE(3001, "值必须为true"),
    IS_FALSE(3002, "值必须为false"),

    /**
     * 参数异常
     */
    PARAMETER_NOT_NULL(4001, "参数不可为空"),
    PARAMETER_IS_NULL(4002, "参数必须为空"),
    PARAMETER_OUT_OF_SCOPE(4003, "参数超出界定范围"),

    /**
     * 数据库异常
     */
    DB_CONNECTION_ERROR(5001, "数据库连接异常"),
    DB_EXECUTE_FAILED(5002, "数据库操作失败"),
    DB_EXECUTE_RETURN_NOT_ZERO(5003, "数据库执行生效记录数为0"),

    ;

    /**
     * 错误代码
     */
    private final Integer code;

    /**
     * 错误描述
     */
    private final String msg;

}
