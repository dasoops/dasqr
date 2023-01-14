package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ConfigCanEditEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.ConfigCanEditEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 配置可以编辑枚举
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
