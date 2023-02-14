package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: PluginEnableEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.PluginEnableEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/09
 * @version 1.0.0
 * @description 插件启用枚举
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
