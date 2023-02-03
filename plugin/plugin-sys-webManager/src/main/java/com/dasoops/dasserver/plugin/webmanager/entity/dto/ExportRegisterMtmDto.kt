package com.dasoops.dasserver.plugin.webmanager.entity.dto

import com.alibaba.excel.annotation.ExcelProperty

/**
 * @Title: ExportRegisterMtmDto
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterMtmDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/01
 * @Version 1.0.0
 * @Description: 导出注册对象多对多dto
 * @see [ExportRegisterMtmDto]
 */
data class ExportRegisterMtmDto(

    /**
     * 注册用户行id
     */
    @ExcelProperty(value = ["rowId"], index = 0)
    var registerRowId: Long? = null,

    /**
     * 插件id
     */
    @ExcelProperty(value = ["插件id"], index = 1)
    var pluginId: Long? = null,

    /**
     * 是否放行
     */
    @ExcelProperty(value = ["是否放行"], index = 2)
    var isPass: Boolean? = null,
)