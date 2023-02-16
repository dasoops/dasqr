package com.dasoops.dasserver.plugin.webmanager.entity.param.register

import com.dasoops.common.entity.param.base.BaseEditParam
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @title EditRegisterParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/01
 * @version 1.0.0
 * @description 编辑注册对象param
 * @see [EditRegisterParam]
 */
@Api("Register")
@ApiModel(value = "编辑注册对象param", description = "编辑注册对象param")
data class EditRegisterParam(

    /**
     * level
     */
    @ApiModelProperty(value = "level", example = "4", required = true)
    var level: Int? = null,

    /**
     * 可使用插件RowId集合
     */
    @ApiModelProperty(value = "可使用插件RowId集合", example = "[0,1]", required = true)
    var passPluginList: List<Long>? = null

) : BaseEditParam<RegisterDo>()