package com.dasoops.dasserver.plugin.webmanager.entity.param.config;

import com.dasoops.common.entity.param.base.BasePageParam;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: GetConfigParam
 * @classPath com.dasoops.dasserver.sys.user.entity.param.GetConfigParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/28
 * @version 1.0.0
 * @description 获取配置参数
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "获取分页配置参数",description = "获取分页配置参数")
public class GetConfigPageParam extends BasePageParam<ConfigDo> {

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
