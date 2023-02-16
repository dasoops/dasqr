package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseDeleteParam;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title DeleteImageParam
 * @classPath com.dasoops.dasserver.plugin.image.entity.param.DeleteImageParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 删除图片param
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "删除图片param", description = "删除图片param")
@Api("Image")
public class DeleteImageParam extends BaseDeleteParam<ImageDo> {


}
