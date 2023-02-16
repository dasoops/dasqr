package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.param.base.BaseAddParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title AddPluginParam
 * @classPath com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/09
 * @version 1.0.0
 * @description 添加插件param
 * @see MessageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("Plugin")
@ApiModel(value = "添加插件param", description = "添加插件param")
public class AddPluginParam extends BaseAddParam<PluginDo> {

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字", notes = "关键字", example = "template", required = true)
    @InjectionParam(order = 0)
    private String keyword;

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径", notes = "类路径", example = "com.dasoops.dasserver.core.TemplatePlugin", required = true)
    @InjectionParam(order = 1)
    private String classPath;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", notes = "描述", example = "模板插件", required = true)
    @InjectionParam(order = 2)
    private String description;

    /**
     * 权限等级
     */
    @ApiModelProperty(value = "权限等级", notes = "权限等级", example = "4", required = true)
    @InjectionParam(order = 3)
    private Integer level;

    /**
     * 是否启用(0:false;1:true)
     */
    @ApiModelProperty(value = "是否启用(0:false;1:true)", notes = "是否启用(0:false;1:true)", example = "1", required = true)
    @InjectionParam(order = 5)
    private Integer enable;
}
