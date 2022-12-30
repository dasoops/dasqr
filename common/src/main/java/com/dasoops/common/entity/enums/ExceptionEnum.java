package com.dasoops.common.entity.enums;

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
     * CqHttp异常
     */
    NO_CQ_CONNECTION(2001, "没有CqHttp连接"),
    CQ_RETURN_FAILED(2002, "CqHttp调用失败"),

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
    PARAMETER_RESLOVE_ERROR(4004, "输入参数解析异常"),

    /**
     * 数据库异常
     */
    DB_CONNECTION_ERROR(5001, "数据库连接异常"),
    DB_EXECUTE_FAILED(5002, "数据库操作失败"),
    DB_EXECUTE_RETURN_NOT_ZERO(5003, "数据库执行生效记录数为0"),
    DB_EXECUTE_RETURN_NOT_NULL(5004, "数据库返回不应为null"),
    DB_EXECUTE_RETURN_NOT_FALSE(5005, "数据库返回不应为false"),

    /**
     * 缓存异常
     */
    REDIS_DATA_NOT_NULL(6001, "redis数据不应为空"),

    /**
     * 系统异常
     */
    PLUGIN_NOT_FOUNT(7001, "插件装配异常"),
    TYPE_CONVERT(7002, "类型转换异常"),

    /**
     * 插件自定义异常
     */
    IMAGE_SAVE_ERROR(8001, "图片存储异常"),
    OCR_ERROR(8002, "ocr服务异常"),
    IMAGE_PART_SAVE_KEY_NOT_NULL(8003, "imageKey获取失败,可能是消息间隔太长"),
    TEST_EXCEPTION(8004, "这是一个测试异常"),
    CRAZY_TEST_EXCEPTION(8005, "CrazyThursDayPayMe50"),

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
