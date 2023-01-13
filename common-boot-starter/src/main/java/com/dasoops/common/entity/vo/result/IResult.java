package com.dasoops.common.entity.vo.result;

import java.io.Serializable;

/**
 * @Title: BaseResult<T>
 * @ClassPath cn.qiaoml.bean.vo.result.BaseResult<T>
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/30
 * @Version 1.0.0
 * @Description: 基本结果
 * @see Serializable
 */
public interface IResult extends Serializable {

    /**
     * 获取返回编号
     *
     * @return {@link Integer}
     */
    Integer getCode();

    /**
     * 设置返回编号
     *
     * @param code 编号
     */
    void setCode(Integer code);

    /**
     * 获取返回信息
     *
     * @return {@link String}
     */
    String getMsg();

    /**
     * 设置返回信息
     *
     * @param msg 味精
     */
    void setMsg(String msg);

}
