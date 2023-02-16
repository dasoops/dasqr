package com.dasoops.dasserver.plugin.reboot.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title QuietRebootEnum
 * @classPath com.dasoops.dasserver.plugin.reboot.entity.enums.QuietRebootEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/13
 * @version 1.0.0
 * @description 静默重启枚举
 * @see Enum
 * @see IDbColumnEnum
 */
@Getter
@AllArgsConstructor
public enum QuietRebootEnum implements IDbColumnEnum {
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