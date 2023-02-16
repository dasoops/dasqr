package com.dasoops.dasserver.plugin.setu.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title SetuExceptionEnum
 * @classPath com.dasoops.dasserver.plugin.setu.entity.enums.SetuExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description setu异常枚举(107xx)
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
