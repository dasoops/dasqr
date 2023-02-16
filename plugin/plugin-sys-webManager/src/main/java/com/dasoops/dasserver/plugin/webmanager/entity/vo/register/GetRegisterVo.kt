package com.dasoops.dasserver.plugin.webmanager.entity.vo.register

import com.dasoops.common.entity.vo.base.BasePageVo
import com.dasoops.common.entity.vo.base.BaseVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@Api("Register")
@ApiModel(value = "获取用户vo", description = "获取用户vo")
open class GetRegisterVo(
    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "1", required = true)
    var rowId: Long? = null,

    /**
     * 显示名称
     */
    @ApiModelProperty(value = "显示名称", notes = "显示名称", example = "(776465218) Das", required = true)
    var showName: String? = null,

    /**
     * 可用插件数(用户 / 组)
     */
    @ApiModelProperty(value = "可用插件数(用户 / 组|all)", example = "16", required = true)
    var passPluginCountShow: String? = null,
): BaseVo()