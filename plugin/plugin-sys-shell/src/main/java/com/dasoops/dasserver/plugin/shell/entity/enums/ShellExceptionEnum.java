package com.dasoops.dasserver.plugin.shell.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title ShellExceptionEnum
 * @classPath com.dasoops.dasserver.plugin.shell.entity.enums.ShellExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/23
 * @version 1.0.0
 * @description shell异常枚举(108xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum ShellExceptionEnum implements IExceptionEnum {

    /**
     * eem快速生成
     */
    UNSUPPORTED_OPERATION("不支持的操作"), SEND_ERROR("消息发送失败"), RESLOVE_ERROR("解析失败");


    @Override
    public Integer getCode() {
        return 10800 + ordinal();
    }

    @Getter
    final String msg;

}
