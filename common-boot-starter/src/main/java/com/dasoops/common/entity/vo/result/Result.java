package com.dasoops.common.entity.vo.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: Result
 * @ClassPath com.dasoops.dasq.common.entity.Result
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 通用返回结果集
 * @see BaseResult
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Result<T> extends BaseResult {

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", notes = "返回数据", example = "{\"id\":1,\"name\":\"A\"}", required = true)
    private T data;


    /**
     * 通用成功
     *
     * @return {@link BaseResult}
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

    /**
     * 通用成功
     *
     * @param t data
     * @return {@link Result}
     */
    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setData(t);
        return result;
    }

    /**
     * 通用成功
     *
     * @param t data
     * @return {@link Result}
     */
    public static <T> Result<T> success(String msg, T t) {
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(t);
        return result;
    }

    /**
     * 通用失败
     *
     * @param msg msg
     * @return {@link BaseResult}
     */
    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<T>();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

}
