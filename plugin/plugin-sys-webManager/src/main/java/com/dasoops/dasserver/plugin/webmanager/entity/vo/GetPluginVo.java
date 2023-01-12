package com.dasoops.dasserver.plugin.webmanager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetPluginVo
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 获取插件vo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取插件vo", description = "获取插件vo")
public class GetPluginVo extends BaseVo {

    /**
     * 插件名称
     */
    @ApiModelProperty(value = "插件名称", notes = "插件名称", example = "模板插件(templatePlugin)", required = true)
    private String pluginName;

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

}
