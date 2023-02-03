package com.dasoops.common.util.entity

import com.dasoops.common.exception.LogicException
import org.apache.poi.ss.formula.functions.T

/**
 * @Title: ExportDto
 * @ClassPath com.dasoops.common.util.entity.ExportDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/01
 * @Version 1.0.0
 * @Description: 导出dto
 * @see [ExportInfo]
 */
data class ExportInfo<out T>(

    /**
     * 数据集合
     */
    val dataList: List<T>,

    /**
     * 数据类对象
     */
    val dataClass: Class<out T>,

    /**
     * sheet编号
     */
    val sheetNo: Int = 0,

    /**
     * sheet名称
     */
    val sheetName: String = "sheet0",

    ) {

    companion object {
        @JvmSynthetic
        inline fun <reified T> ktBuild(dataList: List<T>): ExportInfo<T> {
            return ExportInfo(dataList, T::class.java)
        }

        @JvmSynthetic
        inline fun <reified T> ktBuild(dataList: List<T>, sheetNo: Int, sheetName: String): ExportInfo<T> {
            return ExportInfo(dataList, T::class.java, sheetNo, sheetName)
        }

        fun build(dataList: List<T>): ExportInfo<T> {
            if (dataList.isEmpty()) {
                throw LogicException(ExportExceptionEnum.DATA_NULL)
            }
            val java: Class<out T> = dataList.first()::class.java
            return ExportInfo(dataList, java)
        }
    }
}