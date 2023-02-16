package com.dasoops.dasserver.plugin.code.generate.ts.entity.dto

import org.springframework.web.bind.annotation.RequestMethod


/**
 * @title RequestInfo
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.RequestInfo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/15
 * @Version 1.0.0
 * @Description: 接口信息
 * @see [RequestInfo]
 */
data class RequestInfo(

    /**
     * 请求类型
     */
    var type: RequestMethod? = null,

    /**
     * 接口路径
     */
    var path: String? = null,

    /**
     * 请求参数实体类信息
     */
    var paramInfo: EntityInfo? = null,

    /**
     * 返回参数实体类信息
     */
    var resultInfo: EntityInfo? = null,

    /**
     * 接口描述
     */
    var description: String?=null
)