package com.dasoops.common.entity;

/**
 * @Title: Result
 * @ClassPath com.dasoops.dasq.common.entity.Result
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 通用返回结果集
 * @see BaseResult
 */
public class Result<T> extends BaseResult<T> {

    /**
     * 通用成功
     *
     * @param t data
     * @return {@link Result}
     */
    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setData(t);
        return result;
    }

    /**
     * 通用失败
     *
     * @param code code
     * @param msg  msg
     * @return {@link Result}
     */
    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }


}
