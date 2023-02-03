package com.dasoops.dasserver.plugin.webmanager.entity.param.register

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "获取用户vo", description = "获取用户vo")
data class GetRegisterVo(
    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "1", required = true)
    val rowId: Long,

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", notes = "类型", example = "0", required = true)
    val type: Int,

    /**
     * 用户显示
     */
    @ApiModelProperty(value = "用户显示", notes = "用户显示", example = "(776465218)Das", required = true)
    val userShow: String,

    /**
     * 可用插件数(用户 / 组)
     */
    @ApiModelProperty(value = "可用插件数", example = "16", required = true)
    val passPluginCountShow: String,

    )