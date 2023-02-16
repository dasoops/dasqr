package com.dasoops.dasserver.plugin.code.generate.ts.entity.param

import com.dasoops.common.entity.param.base.BaseParam
import com.dasoops.common.entity.param.base.IParam
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import io.swagger.annotations.Tag
import lombok.Data
import lombok.EqualsAndHashCode

/**
 * @title GetExportCodeDataParam
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.entity.param.GetExportCodeDataParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/14
 * @Version 1.0.0
 * @Description: 获取导出代码数据param
 * @see [GetExportCodeDataParam]
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("CodeGenerate")
@ApiModel(description = "获取导出代码数据param")
data class GetExportCodeDataParam(

    /**
     * 基路径
     */
    @ApiModelProperty(value = "基路径", example = "com.dasoops", required = true)
    var basePath: String? = null
) : BaseParam()