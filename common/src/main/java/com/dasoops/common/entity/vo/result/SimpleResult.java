package com.dasoops.common.entity.vo.result;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: Result
 * @ClassPath com.dasoops.dasq.common.entity.Result
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 简单返回结果集
 * @see BaseResult
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleResult extends BaseResult {

    /**
     * 通用成功
     *
     * @return {@link BaseResult}
     */
    public static SimpleResult success() {
        SimpleResult result = new SimpleResult();
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

    /**
     * 通用成功
     *
     * @param msg 返回信息
     * @return {@link SimpleResult}
     */
    public static SimpleResult success(String msg) {
        SimpleResult result = new SimpleResult();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    /**
     * 通用失败
     *
     * @param msg msg
     * @return {@link BaseResult}
     */
    public static SimpleResult fail(String msg) {
        SimpleResult result = new SimpleResult();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

    /**
     * 通用失败
     *
     * @param msg msg
     * @return {@link BaseResult}
     */
    public static SimpleResult fail(Integer code, String msg) {
        SimpleResult result = new SimpleResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 通用失败
     *
     * @param exceptionEnum 异常枚举
     * @return {@link SimpleResult}
     */
    public static SimpleResult fail(IExceptionEnum exceptionEnum) {
        SimpleResult result = new SimpleResult();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        return result;
    }
}
