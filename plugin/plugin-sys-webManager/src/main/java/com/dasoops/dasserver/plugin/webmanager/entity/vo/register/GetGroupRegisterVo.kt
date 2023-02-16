package com.dasoops.dasserver.plugin.webmanager.entity.vo.register

import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@Api("Register")
@ApiModel(value = "获取群组注册集合vo", description = "获取群组注册集合vo")
class GetGroupRegisterVo(
    /**
     * 群组用户集合
     */
    @ApiModelProperty(value = "群组用户集合", example = "", required = true)
    var groupUserList: List<GetGroupRegisterInnerVo>? = null
) : GetRegisterVo()
