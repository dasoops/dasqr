package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.param.base.BaseEditParam;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title EditPluginParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.plugin.EditPluginParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 编辑插件param
 * @see BaseFastBuildParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("Plugin")
@ApiModel(value = "编辑插件param", description = "编辑插件param")
public class EditPluginParam extends BaseEditParam<PluginDo>{

    /**
     * 插件名称
     */
    @ApiModelProperty(value = "插件名称", notes = "插件名称", example = "template", required = true)
    private String name;

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径", notes = "类路径", example = "com.dasoops.dasserver.core.TemplatePlugin", required = true)
    private String classPath;

    /**
     * 插件权限等级
     */
    @ApiModelProperty(value = "插件权限等级", notes = "插件权限等级", example = "4", required = true)
    private Integer level;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", notes = "描述", example = "模板插件", required = true)
    private String description;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", notes = "是否启用", example = "1", required = true)
    private Integer enable;
}
