package com.dasoops.dasserver.plugin.loaj.entity.dto

import com.alibaba.excel.annotation.ExcelProperty
import com.dasoops.dasserver.cq.entity.dto.BaseExportDto

class ExportReplyDto : BaseExportDto() {

    /**
     * 触发关键词
     */
    @ExcelProperty(value = ["触发关键词"], order = 1)
    var keyword: String? = null

    /**
     * 回复
     */
    @ExcelProperty(value = ["回复"], order = 2)
    var reply: String? = null

    /**
     * 匹配类型
     */
    @ExcelProperty(value = ["匹配类型"], order = 3)
    var matchType: String? = null

    /**
     * 忽略大小写
     */
    @ExcelProperty(value = ["忽略大小写"], order = 4)
    var ignoreCase: Boolean? = null

    /**
     * 忽略全半角
     */
    @ExcelProperty(value = ["忽略全半角"], order = 5)
    var ignoreDbc: Boolean? = null

    /**
     * 是否启用
     */
    @ExcelProperty(value = ["是否启用"], order = 6)
    var enable: Boolean? = null

}