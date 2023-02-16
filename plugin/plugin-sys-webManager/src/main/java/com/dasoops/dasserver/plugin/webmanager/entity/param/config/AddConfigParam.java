package com.dasoops.dasserver.plugin.webmanager.entity.param.config;

import com.dasoops.common.entity.param.base.BaseAddParam;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title AddConfigParam
 * @classPath com.dasoops.dasserver.webManager.entity.param.AddConfigParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/30
 * @version 1.0.0
 * @description 添加配置参数
 * @see BaseFastBuildParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("Config")
@ApiModel(value = "添加配置参数", description = "添加配置参数")
public class AddConfigParam extends BaseAddParam<ConfigDo> {

    /**
     * 配置项关键词
     */
    @ApiModelProperty(value = "配置项关键词", notes = "配置项关键词", example = "defaultStyle", required = true)
    private String keyword;

    /**
     * 配置项属性值
     */
    @ApiModelProperty(value = "配置项属性值", notes = "配置项属性值", example = "cool", required = true)
    private String value;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", notes = "描述", example = "默认风格", required = true)
    private String description;

    /**
     * 是否支持编辑
     */
    @ApiModelProperty(value = "是否支持编辑", notes = "是否支持编辑(0:false,1:true)", allowableValues = "0,1", example = "1", required = false)
    private Integer canEdit;

}
