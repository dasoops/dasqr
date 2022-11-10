package com.dasoops.common.entity.enums;

/**
 * @Title: BaseExceptionCode
 * @ClassPath com.dasoops.dasserver.core.Exception.enums.BaseExceptionCode
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 异常枚举基类
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
