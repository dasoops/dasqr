package com.dasoops.dasserver.plugin.webmanager.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title GetPluginCheckRepeatEnum
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.enums.GetPluginCheckRepeatEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/17
 * @version 1.0.0
 * @description 检查插件类路径是否重复枚举
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum CheckPluginRepeatEnum {

    /**
     * 检查
     */
    TRUE(1),
    /**
     * 不检查
     */
    FALSE(0),
    ;

    final Integer integerValue;

}
