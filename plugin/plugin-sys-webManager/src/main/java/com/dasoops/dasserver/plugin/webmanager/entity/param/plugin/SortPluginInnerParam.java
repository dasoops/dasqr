package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.dto.base.BaseDto;
import com.dasoops.common.entity.param.base.BaseInnerParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title SortPluginDto
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.dto.SortPluginDto
 * @date 2023/01/14
 * @description 排序插件param
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("Plugin")
@ApiModel(description = "排序插件param")
public class SortPluginInnerParam extends BaseInnerParam {

    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "15", required = true)
    private Long rowId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", notes = "排序", example = "1", required = true)
    private Integer order;

}
