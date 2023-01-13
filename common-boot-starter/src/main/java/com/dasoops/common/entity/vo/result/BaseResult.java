package com.dasoops.common.entity.vo.result;

import io.swagger.annotations.ApiModelProperty;
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

    /**
     * 响应码
     */
    @ApiModelProperty(value = "响应码", notes = "响应码", example = "200", required = true)
    public Integer code;

    /**
     * 响应信息
     */
    @ApiModelProperty(value = "响应信息", notes = "响应信息", example = "请求成功", required = true)
    public String msg;

}
