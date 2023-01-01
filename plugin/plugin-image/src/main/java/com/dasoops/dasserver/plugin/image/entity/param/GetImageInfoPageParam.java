package com.dasoops.dasserver.plugin.image.entity.param;

import com.dasoops.common.entity.param.base.BaseEasyTimePageParam;
import com.dasoops.common.entity.param.base.BaseTimePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetImageParam
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.param.GetImageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 获取分页图像信息
 * @see BaseEasyTimePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取分页图像信息", description = "获取分页图像信息")
public class GetImageInfoPageParam extends BaseTimePageParam {

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
