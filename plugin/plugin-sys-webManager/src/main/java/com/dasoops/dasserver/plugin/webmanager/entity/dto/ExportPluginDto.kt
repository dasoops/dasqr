package com.dasoops.dasserver.plugin.webmanager.entity.dto

import lombok.EqualsAndHashCode
import com.dasoops.dasserver.cq.entity.dto.BaseExportDto
import com.alibaba.excel.annotation.ExcelProperty
import lombok.Data

/**
 * @Title: ExportPluginDto
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportPluginDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 导出插件dto
 * @see BaseExportDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
class ExportPluginDto : BaseExportDto() {
    /**
     * 名称
     */
    private val name: String? = null

    /**
     * 描述
     */
    private val description: String? = null

    /**
     * 类路径
     */
    private val classPath: String? = null

    /**
     * 排序
     */
    private val order: Int? = null

    /**
     * 权限等级
     */
    private val level: Int? = null
}