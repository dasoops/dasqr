package com.dasoops.common.entity.param.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BasePageDto
 * @ClassPath cn.qiaoml.bean.dto.BasePageDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/30
 * @Version 1.0.0
 * @Description: 分页数据dto基类
 * @see BaseEasyPageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEasyPageParam extends BaseParam {

    /**
     * 每页显示数量
     */
    @ApiModelProperty(value = "每页显示数量", notes = "每页显示数量", required = false)
    private Integer size = 10;

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码", notes = "当前页码", required = false)
    private Integer current = 1;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数", notes = "总记录数", required = false)
    private Integer total;
}
