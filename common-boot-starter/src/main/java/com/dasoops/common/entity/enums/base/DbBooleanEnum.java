package com.dasoops.common.entity.enums.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: DbBooleanConvertTinyintEnum
 * @ClassPath com.dasoops.common.entity.enums.base.DbBooleanConvertTinyintEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: db布尔值枚举
 * @see Enum
 * @see IDbColumnEnum
 */
@AllArgsConstructor
@Getter
public enum DbBooleanEnum implements IDbColumnEnum {

    /**
     * 真
     */
    TRUE(0),
    /**
     * 假
     */
    FALSE(1),
    ;

    final Integer dbValue;
}
