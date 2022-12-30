package com.dasoops.common.entity.vo.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title: BaseResult
 * @ClassPath com.dasoops.common.entity.vo.result.BaseResult
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/14
 * @Version 1.0.0
 * @Description: 返回结果集基类
 * @see IResult
 */
@Getter
@Setter
public abstract class BaseResult implements IResult {

    public Integer code;

    public String msg;

}
