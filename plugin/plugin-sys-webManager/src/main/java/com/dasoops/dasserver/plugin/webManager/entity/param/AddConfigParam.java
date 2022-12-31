package com.dasoops.dasserver.plugin.webManager.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: AddConfigParam
 * @ClassPath com.dasoops.dasserver.webManager.entity.param.AddConfigParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 添加配置参数
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddConfigParam extends BaseParam {

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
