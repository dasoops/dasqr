package com.dasoops.dasserver.plugin.webmanager.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ConfigExceptionEnum
 * @ClassPath com.dasoops.dasserver.webManager.entity.enums.ConfigExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: webManager异常枚举(103xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
public enum WebManagerExceptionEnum implements IExceptionEnum {

    /**
     * eem快速生成
     */
    REPEAT_KEYWORD("重复的关键词"),
    UNDEFINED_ID("未定义的id"),
    CANT_EDIT("不支持编辑的配置项"),
    UNDEFINED_CLASS_PATH("未找到类文件"),
    REPEAT_CLASS_PATH("重复的类路径"),
    NEED_HIGH_LEVEL("需要更高的level"), REPEAT_ROW_ID("重复的rowId"), REPEAT_ORDER("重复的order");

    @Override
    public Integer getCode() {
        return 10300 + ordinal();
    }

    @Getter
    final String msg;

}