package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.dasoops.common.entity.param.base.BaseEasyPageParam;
import com.dasoops.common.entity.param.base.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetConfigParam
 * @ClassPath com.dasoops.dasserver.sys.user.entity.param.GetConfigParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 获取配置参数
 * @see BaseEasyPageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "获取分页配置参数",description = "获取分页配置参数")
public class GetConfigPageParam extends BasePageParam {

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字", notes = "关键字", example = "defalut", required = false)
    private String keyword;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", notes = "描述", example = "默认", required = false)
    private String description;
}