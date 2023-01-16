package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class DeleteImageParam extends BaseParam {

    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "65", required = true)
    private Long rowId;

}
