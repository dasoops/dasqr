package com.dasoops.common.entity.enums.base;

/**
 * @Title: ISortColumnEnum
 * @ClassPath com.dasoops.common.entity.enums.base.ISortColumnEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: sort列枚举
 */
public interface ISortColumnEnum {

    /**
     * 获取交互值
     *
     * @return {@link Integer}
     */
    Integer getIntegerValue();

    /**
     * 获取字段名字
     *
     * @return {@link String}
     */
    String getColumnName();

}
