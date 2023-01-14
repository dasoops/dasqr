package com.dasoops.dasserver.plugin.alasnotice.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AlasExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.alasNotice.entity.enums.AlasExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/14
 * @Version 1.0.0
 * @Description: alas异常枚举(105xx)
 * @see Enum
 */
@AllArgsConstructor
public enum AlasExceptionEnum implements IExceptionEnum {
    /**
     * 由eem快速生成
     */
    NO_NOTICE_CQ_TEMPLATE("无在线提醒bot"),
    ;


    @Override
    public Integer getCode() {
        return 10500 + ordinal();
    }

    @Getter
    final String msg;
}
