package com.dasoops.dasserver.plugin.setu.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: SetuExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.setu.entity.enums.SetuExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setu异常枚举(107xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum SetuExceptionEnum implements IExceptionEnum {
    /**
     * eem快速生成
     */
    API_REQUEST_ERROR("setuApi请求失败"),
    ;


    @Override
    public Integer getCode() {
        return 10700 + ordinal();
    }

    @Getter
    final String msg;
}
