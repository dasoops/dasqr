package com.dasoops.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ReflectExceptionEnum
 * @ClassPath com.dasoops.common.entity.enums.ReflectExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/08
 * @Version 1.0.0
 * @Description: 反射工具类异常枚举(107xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum ReflectUtilExceptionEnum implements IExceptionEnum {
    /***/
    INSTANCE_ERROR(10701, "类创建失败"),
    NO_SUCH_CONSTRUCTOR(10702, "未找到无参构造"),
    CANT_INVOKE_METHOD(10703, "无法访问需执行方法"),
    NO_SUCH_SET_METHOD(10704, "未找到字段对应set方法"),
    CANT_RESLOVE_PARAM(10705, "不可解析的参数类型"),
    PARAMETER_RESLOVE_CONVERT_ERROR(10706, "参数解析时发生类型转换异常"),
    ;
    final Integer code;
    final String msg;
}
