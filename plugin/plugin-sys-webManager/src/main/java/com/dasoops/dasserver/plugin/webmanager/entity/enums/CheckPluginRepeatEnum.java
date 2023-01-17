package com.dasoops.dasserver.plugin.webmanager.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: GetPluginCheckRepeatEnum
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.enums.GetPluginCheckRepeatEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/17
 * @Version 1.0.0
 * @Description: 检查插件类路径是否重复枚举
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
