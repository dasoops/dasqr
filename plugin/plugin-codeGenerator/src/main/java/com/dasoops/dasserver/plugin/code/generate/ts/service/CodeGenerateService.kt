package com.dasoops.dasserver.plugin.code.generate.ts.service

import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.ExportCodeInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.param.GetExportCodeDataParam

interface CodeGenerateService {
    /**
     * 获取导出代码数据
     * @param [param] param
     * @return [ExportCodeInfo]
     */
    fun getExportCodeData(param: GetExportCodeDataParam): ExportCodeInfo
}
