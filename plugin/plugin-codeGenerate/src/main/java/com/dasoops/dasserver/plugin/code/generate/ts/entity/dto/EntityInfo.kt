package com.dasoops.dasserver.plugin.code.generate.ts.entity.dto


/**
 * @title EntityInfo
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.EntityInfo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/15
 * @Version 1.0.0
 * @Description: 实体类信息
 * @see [EntityInfo]
 */
data class EntityInfo(

    /**
     * 字段集合
     */
    var fieldList: List<FieldInfo>? = null,

    /**
     * 描述
     */
    var description: String? = null,

    /**
     * 实体类名称
     */
    var name: String? = null,

    /**
     * 继承类
     */
    var extend: Class<*>? = null,

    /**
     * 组
     */
    var group: String? = null,

    /**
     * 是否为param
     * false为vo
     */
    var isParam: Boolean? = null,
)