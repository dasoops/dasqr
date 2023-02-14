package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: PluginStatusEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.PluginStatusEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/16
 * @version 1.0.0
 * @description 插件状态枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum PluginStatusEnum {
    /**
     * 未启用
     */
    UNABLE(0, "-"),
    /**
     * 未加载
     */
    ENABLE_UNLOAD(1, "x"),
    /**
     * 已加载
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
