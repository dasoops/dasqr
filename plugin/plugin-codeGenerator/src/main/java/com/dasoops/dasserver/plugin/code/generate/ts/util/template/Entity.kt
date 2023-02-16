package com.dasoops.dasserver.plugin.code.generate.ts.util.template

/**
 * 接口模板
 */
val ENTITY_TEMPLATE = """
    |/**
    |* {description}
    |*/
    |export interface {name} extends {extend} {
    |{field}
    |}
""".trimMargin()

/**
 * @Title: EntityTemplateDto
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.util.template.EntityTemplateDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/16
 * @Version 1.0.0
 * @Description: 实体模板dto
 * @see [EntityTemplateDto]
 */
data class EntityTemplateDto(
    /**
     * 描述
     */
    var description: String? = null,

    /**
     * 接口名称
     */
    var name: String? = null,

    /**
     * 继承类
     */
    var extend: String? = null,

    /**
     * field
     */
    var field: String? = null
)


/**
 * 字段模板
 */
val FIELD_TEMPLATE = """
    |    /**
    |    * {description}
    |    * example: {example}
    |    */
    |    {name}: {tsType}
""".trimMargin()

