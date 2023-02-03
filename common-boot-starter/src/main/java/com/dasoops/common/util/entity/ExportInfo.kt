package com.dasoops.common.util.entity

import org.apache.poi.ss.formula.functions.T

/**
 * @Title: ExportDto
 * @ClassPath com.dasoops.common.util.entity.ExportDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/01
 * @Version 1.0.0
 * @Description: 导出dto
 * @see [ExportDto]
 */
data class ExportDto<T>(

    /**
     * sheet编号
     */
    val sheetNo: Int = 0,

    /**
     * sheet名称
     */
    val sheetName: String = "sheet0",

    /**
     * 数据集合
     */
    val dataList: List<T>,

    /**
     * 数据类对象
     */
    val dataClass: Class<T>,
)