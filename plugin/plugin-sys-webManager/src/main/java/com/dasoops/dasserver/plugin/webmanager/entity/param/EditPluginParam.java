package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.dasoops.common.entity.param.base.BaseEditAndDeleteParam;
import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: EditPluginParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.EditPluginParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 编辑插件param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EditPluginParam extends BaseEditAndDeleteParam {

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
