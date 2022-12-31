package com.dasoops.dasserver.plugin.webManager.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: EditConfigParam
 * @ClassPath com.dasoops.dasserver.webManager.entity.param.EditConfigParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 编辑配置参数
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "编辑配置参数", description = "编辑配置参数")
public class EditConfigParam extends BaseParam {

    /**
     * id
     */
    @ApiModelProperty(value = "id", notes = "id", example = "1", required = true)
    private Long id;

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
