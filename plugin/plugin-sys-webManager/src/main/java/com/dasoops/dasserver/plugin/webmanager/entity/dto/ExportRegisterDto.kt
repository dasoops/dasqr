package com.dasoops.dasserver.plugin.webmanager.entity.dto

import com.alibaba.excel.annotation.ExcelProperty

/**
 * @title ExportRegisterDto
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/01
 * @version 1.0.0
 * @description 导出注册对象dto
 * @see [ExportRegisterDto]
 */
data class ExportRegisterDto(

    /**
     * rowId
     */
    @ExcelProperty(value = ["rowId"], index = 0)
    var rowId: Long? = null,

    /**
     * 用户id
     */
    @ExcelProperty(value = ["用户id"], index = 1)
    var registerId: Long? = null,

    /**
     * 类型(group;user)
     */
    @ExcelProperty(value = ["类型"], index = 2)
    var type: String? = null,

    /**
     * 权限等级
     */
    @ExcelProperty(value = ["权限等级"], index = 3)
    var level: Long? = null,
)