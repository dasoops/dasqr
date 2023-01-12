package com.dasoops.dasserver.plugin.webmanager.entity;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: SortParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.SortParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 排序param
 * @see BaseParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "排序Param", description = "排序Param")
public class BaseSortParam extends BaseParam {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", notes = "主键id", example = "10", required = true)
    private Long rowId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", notes = "排序", example = "5", required = true)
    private Integer order;

}
