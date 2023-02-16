package com.dasoops.dasserver.plugin.exec.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title ExecExceptionEnum
 * @classPath com.dasoops.dasserver.plugin.exec.entity.enums.ExecExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description 执行异常枚举(106xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
public enum ExecExceptionEnum implements IExceptionEnum {
    /**
     * eem快速生成
     */
    UNDEFINED_KEYWORD("未定义的关键词"),
    NO_SUCH_FILE("没有指定的文件");


    @Override
    public Integer getCode() {
        return 10600 + ordinal();
    }

    @Getter
    final String msg;

}
