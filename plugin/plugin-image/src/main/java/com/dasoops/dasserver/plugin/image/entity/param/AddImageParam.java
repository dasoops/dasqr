package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: AddImageParam
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.param.AddImageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 添加图片param
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "添加图片param", description = "添加图片param")
public class AddImageParam extends BaseParam {

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "我也是aoe", required = true)
    private String keyword;

    /**
     * 图片名称
     */
    @ApiModelProperty(value = "图片名称", notes = "图片名称", example = "af541241-e00b-494c-ae9c-9e923c362599.jpg", required = true)
    private String fileName;

}
