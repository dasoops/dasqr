package com.dasoops.dasserver.plugin.code.generate.ts.util.template

/**
 * get请求参数模板
 */
val GET_PARAM_TEMPLATE = """
    |,
    |        param: param
""".trimMargin()

/**
 * post请求参数模板
 */
val POST_PARAM_TEMPLATE = """
    |,
    |        data: param
""".trimMargin()

/**
 * 请求模板
 */
val REQUEST_TEMPLATE = """
    |/**
    | * {description}
    | */
    |export const {path} = function ({paramAfterFunction}): Promise<{result}> {
    |    return axiosClient({
    |        url: "/{path}",
    |        method: "{type}"{paramInAxios}
    |    })
    |}
    |
""".trimMargin()


/**
 * @Title: RequestTemplateDto
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.util.template.RequestTemplateDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/16
 * @Version 1.0.0
 * @Description: 请求模板dto
 * @see [RequestTemplateDto]
 */
data class RequestTemplateDto(
    /**
     * 请求描述
     */
    var description: String? = null,

    /**
     * 请求地址
     */
    var path: String? = null,

    /**
     * 请求参数(方法后)
     */
    var paramAfterFunction: String? = null,

    /**
     * 返回值
     */
    var result: String? = null,

    /**
     * 请求类型
     */
    var type: String? = null,

    /**
     * 请求参数(axios内部变量)
     */
    var paramInAxios: String? = null,
)