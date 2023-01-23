package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseDeleteParam;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: DeleteImageParam
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.param.DeleteImageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 删除图片param
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "删除图片param", description = "删除图片param")
public class DeleteImageParam extends BaseDeleteParam<ImageDo> {


}
