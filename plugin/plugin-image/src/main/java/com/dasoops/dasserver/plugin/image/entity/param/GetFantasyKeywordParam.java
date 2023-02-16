package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title GetFantasyKeywordParam
 * @classPath com.dasoops.dasserver.plugin.image.entity.param.GetFantasyKeywordParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 获取联想关键词param
 * @see BaseFastBuildParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取联想关键词param", description = "获取联想关键词param")
@Api("Image")
public class GetFantasyKeywordParam extends BaseParam {

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "关键词", required = true)
    private String keyword;

}
