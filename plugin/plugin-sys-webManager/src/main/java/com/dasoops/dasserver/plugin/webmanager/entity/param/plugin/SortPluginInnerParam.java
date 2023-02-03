package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.dto.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: SortPluginDto
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.dto.SortPluginDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/14
 * @Version 1.0.0
 * @Description: 排序插件param
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
