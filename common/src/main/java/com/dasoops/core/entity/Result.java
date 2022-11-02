package com.dasoops.core.entity;

/**
 * @Title: Result
 * @ClassPath com.dasoops.dasq.common.entity.Result
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 通用返回结果集
 * @see BaseResult
 */
public class Result extends BaseResult {

    /**
     * 通用成功
     *
     * @param obj data
     * @return {@link Result}
     */
    public static Result success(Object obj) {
        Result result = new Result();
        result.setData(obj);
        return result;
    }

    /**
     * 通用失败
     *
     * @param code code
     * @param msg  msg
     * @return {@link Result}
     */
    public static Result fail(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
