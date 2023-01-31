package com.dasoops.dasserver.plugin.loaj.entity.param

import com.dasoops.common.entity.param.base.BasePageParam
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @Title: GetReplyPageParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/30
 * @Version 1.0.0
 * @Description: 获取回复页面param
 * @see [GetReplyPageParam]
 */
@ApiModel(value = "获取回复页面param", description = "获取回复页面param")
class GetReplyPageParam : BasePageParam<ReplyDo>() {

    /**
     * 匹配关键词(keyword || reply)
     */
    @ApiModelProperty(value = "like 关键字", notes = "like 关键字", example = "傻狗", required = false)
    var matchKeyword: String? = null

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
}