package com.dasoops.dasserver.plugin.webmanager.entity.vo.plugin;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title GetPluginVo
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.vo.plugin.GetPluginVo
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 获取插件vo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("Plugin")
@ApiModel(value = "获取插件vo", description = "获取插件vo")
public class GetPluginVo extends BaseVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", notes = "主键id", example = "1", required = true)
    private Long rowId;

    /**
     * 插件名称
     */
    @ApiModelProperty(value = "插件名称", notes = "插件名称", example = "templatePlugin", required = true)
    private String name;

    /**
     * 插件描述
     */
    @ApiModelProperty(value = "插件描述", notes = "插件描述", example = "模板插件", required = true)
    private String description;

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径", notes = "类路径", example = "com.dasoops.dasserver.core.TemplatePlugin", required = true)
    private String classPath;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", notes = "排序", example = "10", required = true)
    private Integer order;

    /**
     * 权限等级
     */
    @ApiModelProperty(value = "权限等级", notes = "权限等级", example = "4", required = true)
    private Integer level;

    /**
     * 是否启用(0:false;1:true)
     */
    @ApiModelProperty(value = "是否启用(0:false;1:true)", notes = "是否启用(0:false;1:true)", example = "0", required = true)
    private Integer enable;

    /**
     * 插件状态(0:未启用;1:未加载;2:加载;3:无记录)
     */
    @ApiModelProperty(value = "插件状态(0:未启用;1:未加载;2:加载;3:无记录)", notes = "插件状态(0:未启用;1:未加载;2:加载;3:无记录)", example = "1", required = true)
    private Integer status;

}
