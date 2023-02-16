package com.dasoops.dasserver.plugin.code.generate.ts.entity.dto


data class ExportCodeInfo(
    var requestList: ArrayList<RequestInfo> = ArrayList(),
    var entityList: ArrayList<EntityInfo> = ArrayList()
)