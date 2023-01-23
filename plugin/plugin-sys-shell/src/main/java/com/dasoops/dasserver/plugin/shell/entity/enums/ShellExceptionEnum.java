package com.dasoops.dasserver.plugin.shell.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ShellExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.shell.entity.enums.ShellExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: 壳牌异常枚举
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum ShellExceptionEnum implements IExceptionEnum {

    /**
     * eem快速生成
     */
    TEMPLATE("template"),
    ;


    @Override
    public Integer getCode() {
        return 10000 + ordinal();
    }

    @Getter
    final String msg;

}
