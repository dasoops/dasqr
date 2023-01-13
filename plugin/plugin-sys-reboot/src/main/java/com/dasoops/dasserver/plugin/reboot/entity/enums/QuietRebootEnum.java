package com.dasoops.dasserver.plugin.reboot.entity.enums;

import com.dasoops.common.entity.enums.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: QuietRebootEnum
 * @ClassPath com.dasoops.dasserver.plugin.reboot.entity.enums.QuietRebootEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/13
 * @Version 1.0.0
 * @Description: 静默重启枚举
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