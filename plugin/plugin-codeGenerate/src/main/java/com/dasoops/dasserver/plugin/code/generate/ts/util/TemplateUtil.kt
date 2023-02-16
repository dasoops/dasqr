package com.dasoops.dasserver.plugin.code.generate.ts.util

import com.dasoops.common.util.StrUtil
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.EntityInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.FieldInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.RequestInfo
import com.dasoops.dasserver.plugin.code.generate.ts.util.template.*
import org.springframework.web.bind.annotation.RequestMethod
import java.util.stream.Collectors

/**
 * @Title: TemplateUtil
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.util.TemplateUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/16
 * @Version 1.0.0
 * @Description: 模板工具
 * @see [TemplateUtil]
 */
class TemplateUtil {

    companion object {
        fun buildFileAnno() {

        }

        /**
         * 构建请求
         */
        fun buildRequest(requestInfo: RequestInfo): String {
            val dto = RequestTemplateDto().apply {
                description = requestInfo.description!!
                path = requestInfo.path?.substringAfterLast("/")?.removePrefix("/") ?: ""
                type = requestInfo.type?.name ?: ""
                result = if (requestInfo.resultInfo?.name == null) {
                    "SimpleResult"
                } else {
                    "Result<${requestInfo.resultInfo?.name}>"
                }
                paramInAxios = if (requestInfo.paramInfo?.name != null) {
                    when (requestInfo.type) {
                        RequestMethod.GET -> GET_PARAM_TEMPLATE
                        RequestMethod.POST -> POST_PARAM_TEMPLATE
                        else -> ""
                    }
                } else {
                    ""
                }
                paramAfterFunction = if (requestInfo.paramInfo?.name != null) {
                    "param: ${requestInfo.paramInfo?.name}"
                } else {
                    ""
                }
            }
            return StrUtil.formatForObj(REQUEST_TEMPLATE, dto)
        }

        /**
         * 构建实体类
         */
        fun buildEntity(entityInfo: EntityInfo): String {
            val fieldStr = buildField(entityInfo.fieldList!!)

            val dto = EntityTemplateDto().apply {
                description = entityInfo.description!!
                name = entityInfo.name!!
                extend = entityInfo.extend!!.simpleName
                field = fieldStr
            }

            return StrUtil.formatForObj(ENTITY_TEMPLATE, dto)
        }

        fun buildField(fieldList: List<FieldInfo>): String {
            return fieldList.joinToString(",\r\n\r\n") {
                if (it.required == false) {
                    it.name += "?"
                }
                StrUtil.formatForObj(FIELD_TEMPLATE, it)
            }
        }

        fun buildEntityFileGroupingByGroup(suffix:String,entityList: List<EntityInfo>): Map<String, String> {
            return entityList.stream()
                //按group分组
                .collect(Collectors.groupingBy { it.group }).entries.stream()
                .collect(Collectors.toMap(
                    { "${it.key}$suffix" },
                    { it.value.joinToString("\r\n\r\n") { entityInfo -> buildEntity(entityInfo) } }
                ))
        }

        /**
         * 构建实体文件
         * @param [entityList] 实体集合
         * @return [Pair<Map<String, String>, Map<String, String>>]
         * Pair<ParamMap,VoMap>
         */
        fun buildEntityFile(entityList: List<EntityInfo>): Pair<Map<String, String>, Map<String, String>> {
            val groupByType = entityList.stream().collect(Collectors.groupingBy { it.isParam })
            return buildEntityFileGroupingByGroup("Param",groupByType[true]!!) to buildEntityFileGroupingByGroup("Vo",groupByType[false]!!)
        }

        fun buildRequestFile(requestList: List<RequestInfo>): Map<String, String> {
            return requestList.stream()
                .collect(Collectors.groupingBy { it.path?.substringBeforeLast("/")?.removePrefix("/") ?: "Default" }).entries.stream()
                .collect(Collectors.toMap(
                    { "${StrUtil.upperFirst(it.key)}Request" },
                    { it.value.joinToString("\r\n") { requestInfo -> buildRequest(requestInfo) } }
                ))
        }
    }

}