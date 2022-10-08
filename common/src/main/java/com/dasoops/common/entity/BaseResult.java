package com.dasoops.common.entity;

import lombok.Data;

/**
 * @Title: Result
 * @ClassPath com.dasoops.dasq.common.entity.Result
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 返回结果集基类
 */
@Data
public class BaseResult {

    /**
     * 响应编码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

}
