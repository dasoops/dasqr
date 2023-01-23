package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseEditParam;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: EditImageParam
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.param.EditImageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 编辑图片参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "编辑图片参数", description = "编辑图片参数")
public class EditImageInfoParam extends BaseEditParam<ImageDo> {


    /**
     * 图片关键词
     */
    @ApiModelProperty(value = "图片关键词", notes = "图片关键词", example = "奥欸奥", required = true)
    private String keyword;

    /**
     * 图片名称
     */
    @ApiModelProperty(value = "图片名称", notes = "图片名称", example = "af541241-e00b-494c-ae9c-9e923c362599.jpg", required = true)
    private String fileName;

}
