package com.dasoops.dasserver.plugin.reboot.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: QuietBootEnum
 * @classPath com.dasoops.dasserver.plugin.reboot.entity.enums.QuietBootEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/13
 * @version 1.0.0
 * @description 静默启动枚举
 * @see Enum
 * @see IDbColumnEnum
 */
@Getter
@AllArgsConstructor
public enum QuietBootEnum implements IDbColumnEnum {
    /**
     * 否
     */
    FALSE(0),
    /**
     * 是
     */
    TRUE(1),
    ;

    final Integer dbValue;
}