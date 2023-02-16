package com.dasoops.dasserver.plugin.code.generate.ts.util

import cn.hutool.http.ContentType
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletResponse

/**
 * @Title: ExportUtil
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.util.ExportUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/16
 * @Version 1.0.0
 * @Description: 导出工具
 * @see [ExportUtil]
 */
class ExportUtil {

    companion object {

        /**
         * 设置响应
         * @param [response] 响应
         * @param [fileName] 文件名称
         * @param [contentType] 内容类型
         */
        fun setResponse(response: HttpServletResponse, fileName: String, fileTypeSuffix: String, contentType: String) {
            /**
             * xlsx的ContentType
             */
            //文件编码,类型
            response.contentType = contentType
            response.characterEncoding = "utf-8"
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition")

            //文件名
            val encodeFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replace("\\+".toRegex(), "%20")
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''$encodeFileName.$fileTypeSuffix")
        }

        /**
         * 设置响应
         * @param [response] 响应
         * @param [fileName] 文件名称
         * @param [contentType] 内容类型
         */
        fun setResponse(response: HttpServletResponse, fileName: String, fileTypeSuffix: String, contentType: ContentType) {
            setResponse(response, fileName, fileTypeSuffix, contentType.value)
        }
    }

}