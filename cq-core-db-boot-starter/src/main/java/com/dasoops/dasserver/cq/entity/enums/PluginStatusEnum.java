package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: PluginStatusEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.PluginStatusEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/16
 * @Version 1.0.0
 * @Description: 插件状态枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum PluginStatusEnum {
    /**
     * 未启用
     */
    NOT_ENABLE(0, "-"),
    /**
     * 未加载
     */
    ENABLE_NOT_LOAD(1, "x"),
    /**
     * 加载
     */
    LOAD(2, "√"),
    /**
     * 无记录
     */
    NO_RECORD(3, "?"),
    ;

    final Integer integerValue;
    final String statusString;
}
