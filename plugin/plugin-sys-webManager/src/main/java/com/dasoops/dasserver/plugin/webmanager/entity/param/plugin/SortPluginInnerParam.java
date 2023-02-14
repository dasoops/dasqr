package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.dto.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title: SortPluginDto
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.dto.SortPluginDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/14
 * @version 1.0.0
 * @description 排序插件param
 * @see BaseDto
 */
@Data
public class SortPluginInnerParam {

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
