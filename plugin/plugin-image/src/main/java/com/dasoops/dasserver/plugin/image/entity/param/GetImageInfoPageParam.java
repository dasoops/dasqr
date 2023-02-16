package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseTimePageParam;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title GetImageInfoPageParam
 * @classPath com.dasoops.dasserver.plugin.image.entity.param.GetImageInfoPageParam
 * @date 2023/02/16
 * @description 获取分页图像信息Param
 * @see BaseTimePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取分页图像信息Param", description = "获取分页图像信息Param")
@Api("Image")
public class GetImageInfoPageParam extends BaseTimePageParam<ImageDo> {

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "测试", required = false)
    private String keyword;

    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建用户", notes = "创建用户", example = "776465218", required = false)
    private String createUser;

}
