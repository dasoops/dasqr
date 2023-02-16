package com.dasoops.dasserver.plugin.webmanager.entity.param.register

import com.dasoops.common.entity.param.base.BasePageParam
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @title GetRegisterParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/01
 * @version 1.0.0
 * @description 获取注册对象param
 * @see [GetRegisterParam]
 */
@Api("Register")
@ApiModel(value = "获取注册对象param", description = "获取注册对象param")
data class GetRegisterParam(
    /**
     * 最小Level
     */
    @ApiModelProperty(value = "最小Level", notes = "最小Level", example = "1", required = false)
    var minLevel: Int? = null,

    /**
     * user关键字
     */
    @ApiModelProperty(value = "user关键字", notes = "user关键字", example = "_776465218", required = false)
    var keyword: String? = null,

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型(0:user;1:group)", notes = "类型", example = "0", required = true)
    var type: Int? = null
) : BasePageParam<RegisterDo>()
