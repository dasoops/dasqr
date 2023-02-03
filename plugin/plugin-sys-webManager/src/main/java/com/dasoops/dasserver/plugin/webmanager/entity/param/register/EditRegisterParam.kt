package com.dasoops.dasserver.plugin.webmanager.entity.param.register

import com.dasoops.common.entity.param.base.BaseEditParam
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @Title: EditRegisterParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/01
 * @Version 1.0.0
 * @Description: 编辑注册对象param
 * @see [EditRegisterParam]
 */
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
    var passPluginList: List<Long>? = ArrayList()

) : BaseEditParam<RegisterDo>()