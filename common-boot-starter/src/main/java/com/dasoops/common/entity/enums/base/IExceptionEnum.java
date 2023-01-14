package com.dasoops.common.entity.enums.base;

/**
 * @Title: IExceptionEnum
 * @ClassPath com.dasoops.common.entity.enums.base.IExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/14
 * @Version 1.0.0
 * @Description: iexception枚举
 */
public interface IExceptionEnum {

    /**
     * 获取错误代码
     *
     * @return {@link Integer}
     */
    Integer getCode();

    /**
     * 获取错误描述
     *
     * @return {@link String}
     */
    String getMsg();

}
