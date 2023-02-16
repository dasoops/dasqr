package com.dasoops.dasserver.plugin.code.generate.ts.controller

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.IoUtil
import cn.hutool.core.io.file.FileWriter
import cn.hutool.core.util.ZipUtil
import cn.hutool.http.ContentType
import com.dasoops.dasserver.plugin.code.generate.ts.entity.param.GetExportCodeDataParam
import com.dasoops.dasserver.plugin.code.generate.ts.service.CodeGenerateService
import com.dasoops.dasserver.plugin.code.generate.ts.util.ExportUtil
import com.dasoops.dasserver.plugin.code.generate.ts.util.TemplateUtil
import com.github.xiaoymin.knife4j.annotations.ApiSupport
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

const val basePath = "./temp/"

@RequestMapping("codeGenerate")
@RestController
@Api(tags = ["plugin - codeGenerate"])
@ApiSupport(author = "DasoopsNicole@gmail.com")
class CodeGenerateController(
    private val codeGenerateService: CodeGenerateService
) {

    @ApiOperation(value = "下载代码文件")
    @GetMapping("downloadCodeFile")
    fun downloadCodeFile(param: GetExportCodeDataParam, response: HttpServletResponse) {
        //扫包
        val (requestList, entityList) = codeGenerateService.getExportCodeData(param)

        //构建文件集合
        val (paramFileStrMap, voFileStrMap) = TemplateUtil.buildEntityFile(entityList)
        val requestFileStrMap = TemplateUtil.buildRequestFile(requestList)

        //导出到指定路径
        createFile(paramFileStrMap, "$basePath/code/entity/param/")
        createFile(voFileStrMap, "$basePath/code/entity/vo/")
        createFile(requestFileStrMap, "$basePath/code/request/")

        //压缩
        val zipFile = ZipUtil.zip("$basePath/code", "$basePath/code.zip")

        //设置响应头
        ExportUtil.setResponse(response, "code", "zip", ContentType.OCTET_STREAM)

        //导出
        IoUtil.write(response.outputStream, true, zipFile.readBytes())

        //毁尸灭迹
        FileUtil.del(basePath)

    }

    private fun createFile(paramFileStrMap: Map<String, String>, dirPath: String) {
        paramFileStrMap.entries.stream().map {
            val file = FileUtil.touch("$dirPath${it.key}.ts")
            val writer = FileWriter.create(file, Charsets.UTF_8)
            writer.append(it.value)
        }.toList()
    }
}