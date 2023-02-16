package com.dasoops.dasserver.plugin.webmanager.entity.param.config;

import com.dasoops.common.entity.param.base.BaseEditAndDeleteParam;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title EditConfigParam
 * @classPath com.dasoops.dasserver.webManager.entity.param.EditConfigParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/30
 * @version 1.0.0
 * @description 编辑配置参数
 * @see BaseFastBuildParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("Config")
@ApiModel(value = "编辑配置参数", description = "编辑配置参数")
public class EditConfigParam extends BaseEditAndDeleteParam {

    /**
     * 配置项关键词
     */
    @ApiModelProperty(value = "配置项关键词", notes = "配置项关键词", example = "defaultStyle", required = false)
    private String keyword;

    /**
     * 配置项属性值
     */
    @ApiModelProperty(value = "配置项属性值", notes = "配置项属性值", example = "cool", required = false)
    private String value;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", notes = "描述", example = "默认风格", required = false)
    private String description;

}
