package com.dasoops.dasserver.entity.enums;

import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ConfigExceptionEnum
 * @ClassPath com.dasoops.dasserver.entity.enums.ConfigExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 配置异常枚举(102xx)
 * @see Enum
 * @see IExceptionEnum
 */
@Getter
@AllArgsConstructor
public enum ConfigExceptionEnum implements IExceptionEnum {

    /***/
    REPEAT_KEYWORD(10201, "重复的关键词"),
    UNDEFINED_ID(10202, "无效的id"),
    CANT_EDIT(10203, "不支持编辑的配置项"),

    ;

    final Integer code;

    final String msg;

}
