package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseTimePageParam;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: GetImageParam
 * @classPath com.dasoops.dasserver.plugin.image.entity.param.GetImageParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 获取分页图像信息参数
 * @see BaseEasyTimePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取分页图像信息", description = "获取分页图像信息")
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
