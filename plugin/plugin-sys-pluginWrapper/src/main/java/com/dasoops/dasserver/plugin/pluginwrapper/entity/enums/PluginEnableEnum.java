package com.dasoops.dasserver.plugin.pluginwrapper.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: PluginEnableEnum
 * @ClassPath com.dasoops.dasserver.plugin.pluginwrapper.entity.enums.PluginEnableEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 插件启用枚举
 * @see Enum
 * @see IDbColumnEnum
 */
@AllArgsConstructor
@Getter
public enum PluginEnableEnum implements IDbColumnEnum {

    /**
     * 启用
     */
    TRUE(1),
    /**
     * 禁用
     */
    FALSE(0),
    ;

    final Integer dbValue;
}
