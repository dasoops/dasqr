package com.dasoops.dasserver.plugin.setu.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title SetuSizeEnum
 * @classPath com.dasoops.dasserver.plugin.setu.entity.enums.SetuSizeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description setu大小枚举
 */
@AllArgsConstructor
@Getter
public enum SetuSizeEnum {

    /**
     * 原始
     */
    ORIGINAL("original"),
    /**
     * 常规
     */
    REGULAR("regular"),
    /**
     * 540x540
     */
    SMALL("small"),
    /**
     * 250x250
     */
    THUMB("thumb"),
    /**
     * 48x48
     */
    MINI("mini"),
    ;

    final String apiValue;
}
