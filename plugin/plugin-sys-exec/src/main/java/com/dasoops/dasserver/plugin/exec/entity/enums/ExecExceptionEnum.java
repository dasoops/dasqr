package com.dasoops.dasserver.plugin.exec.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ExecExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.exec.entity.enums.ExecExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: 执行异常枚举(106xx)
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
