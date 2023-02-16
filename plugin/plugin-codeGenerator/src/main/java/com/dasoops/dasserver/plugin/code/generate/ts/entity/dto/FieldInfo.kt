package com.dasoops.dasserver.plugin.code.generate.ts.entity.dto

/**
 * @title FieldInfo
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.FieldInfo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/15
 * @Version 1.0.0
 * @Description: 字段信息
 * @see [FieldInfo]
 */
data class FieldInfo(

    /**
     * 名称
     */
    var name: String? = null,

    /**
     * 类型
     */
    var javaType: Class<*>? = null,

    /**
     * 类型
     */
    var tsType: String? = null,

    /**
     * 描述
     */
    var description: String? = null,

    /**
     * 示例参数
     */
    var example: String? = null,

    /**
     * 是否必须
     */
    var required: Boolean? = null

)