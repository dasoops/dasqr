package com.dasoops.dasserver.plugin.webmanager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: PluginSortVo
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.vo.PluginSortVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 插件排序vo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "插件排序vo", description = "插件排序vo")
public class PluginSortVo extends BaseVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", notes = "主键id", example = "1", required = true)
    private Long rowId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", notes = "名称", example = "模板插件(template)", required = true)
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", notes = "排序", example = "10", required = true)
    private Integer order;

}
