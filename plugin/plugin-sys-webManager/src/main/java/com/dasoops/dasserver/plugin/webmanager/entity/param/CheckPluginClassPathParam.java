package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.dasoops.common.entity.param.SimpleParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CheckPluginClassPathParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.CheckPluginClassPathParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/14
 * @Version 1.0.0
 * @Description: 检查插件类路径param
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "检查插件类路径param", description = "检查插件类路径param")
public class CheckPluginClassPathParam extends SimpleParam {

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径", notes = "类路径", example = "com.dasoops.dasserver.core.TemplatePlugin", required = true)
    private String classPath;

}
