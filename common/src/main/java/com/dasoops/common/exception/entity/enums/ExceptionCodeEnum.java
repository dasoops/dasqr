package com.dasoops.common.exception.entity.enums;

/**
 * @Title: ExceptionCodeEnum
 * @ClassPath com.dasoops.dasq.common.exception.entity.enums.ExceptionCodeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 异常编号枚举
 * @see Enum
 */
public enum ExceptionCodeEnum {

    /**
     * 参数应不为空,获取异常
     */
    UN_EXPECTED_ERROR(1600, "预料之外的错误"),
    PARAMETER_GET_ERROR(1601, "参数获取异常"),
    NO_REGISTER_CODE_ERROR(1602, "未注册的识别码"),
    CQ_HTTP_ERROR(1603, "cqHttp访问异常"),
    IMAGE_SERVICE_ERROR(1604, "图片服务访问异常"),
    IMAGE_GET_ERROR(1605, "图片获取失败"),
    ;

    /**
     * 错误代码
     */
    private final Integer code;

    /**
     * 错误描述
     */
    private final String description;

    ExceptionCodeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
