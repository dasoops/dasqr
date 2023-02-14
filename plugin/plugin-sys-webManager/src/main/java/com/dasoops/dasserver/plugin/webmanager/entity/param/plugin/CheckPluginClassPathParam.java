package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CheckPluginClassPathParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.plugin.CheckPluginClassPathParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/14
 * @version 1.0.0
 * @description 检查插件类路径param
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "检查插件类路径param", description = "检查插件类路径param")
public class CheckPluginClassPathParam extends BaseParam {

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径", notes = "类路径", example = "com.dasoops.dasserver.core.TemplatePlugin", required = true)
    private String classPath;

    /**
     * 检查是否是重复的类路径(0:false;1:true)
     */
    @ApiModelProperty(value = "检查是否是重复的类路径(0:false;1:true)", notes = "检查是否是重复的类路径(0:false;1:true)", example = "0", required = true)
    private Integer checkRepeatClassPath;

}
