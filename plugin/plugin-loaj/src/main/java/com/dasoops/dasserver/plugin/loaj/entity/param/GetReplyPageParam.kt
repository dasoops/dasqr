package com.dasoops.dasserver.plugin.loaj.entity.param

import com.dasoops.common.entity.param.base.BasePageParam
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @title GetReplyPageParam
 * @classPath com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/30
 * @version 1.0.0
 * @description 获取回复页面param
 * @see [GetReplyPageParam]
 */
@ApiModel(value = "获取回复页面param", description = "获取回复页面param")
@Api("Reply")
data class GetReplyPageParam(
    /**
     * 匹配关键词(keyword || reply)
     */
    @ApiModelProperty(value = "like 关键字", notes = "like 关键字", example = "傻狗", required = false)
    var matchKeyword: String? = null,

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    @ApiModelProperty(
        value = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)",
        notes = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)",
        example = "[0,1]",
        required = false
    )
    var matchTypeList: List<Int>? = null

) : BasePageParam<ReplyDo>()