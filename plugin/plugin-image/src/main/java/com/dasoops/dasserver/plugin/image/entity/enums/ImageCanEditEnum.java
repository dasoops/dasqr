package com.dasoops.dasserver.plugin.image.entity.enums;


import com.dasoops.common.entity.enums.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ImageCanEditEnum
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.enums.ImageCanEditEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/02
 * @Version 1.0.0
 * @Description: 图片是否可以编辑枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum ImageCanEditEnum implements IDbColumnEnum {
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
