package com.dasoops.dasserver.plugin.webmanager.entity.dto

import com.alibaba.excel.annotation.ExcelProperty
import com.dasoops.dasserver.cq.entity.dto.BaseExportDto
import lombok.Data
import lombok.EqualsAndHashCode

/**
 * @Title: ExportConfigDto
 * @ClassPath com.dasoops.dasserver.webManager.entity.dto.ExportConfigDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 出口配置dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
class ExportConfigDto : BaseExportDto() {
    /**
     * 关键字
     */
    @ExcelProperty(value = ["关键字"], index = 1)
    var keyword: String? = null

    /**
     * 值
     */
    @ExcelProperty(value = ["值"], index = 2)
    var value: String? = null

    /**
     * 描述
     */
    @ExcelProperty(value = ["描述"], index = 3)
    var description: String? = null

    /**
     * 是否可以编辑
     */
    @ExcelProperty(value = ["是否可以编辑"], index = 4)
    var canEdit = false
}