package com.dasoops.dasserver.plugin.image.entity.param;


import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetFantastyUserParam
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.param.GetFantastyUserParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 获取联想用户param
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取联想用户param", description = "获取联想用户param")
public class GetFantastyUserParam extends BaseParam {

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "77646 / Das", required = true)
    private String keyword;

}
