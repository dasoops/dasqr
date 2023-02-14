package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: ConfigCanEditEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.ConfigCanEditEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/30
 * @version 1.0.0
 * @description 配置可以编辑枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum ConfigCanEditEnum implements IDbColumnEnum {
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
