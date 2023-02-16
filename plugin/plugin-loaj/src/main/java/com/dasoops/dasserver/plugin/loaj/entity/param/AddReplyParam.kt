package com.dasoops.dasserver.plugin.loaj.entity.param

import com.dasoops.common.entity.param.base.BaseAddParam
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @title AddReplyParam
 * @classPath com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/30
 * @version 1.0.0
 * @description 添加回复param
 * @see [AddReplyParam]
 */
@ApiModel(value = "添加回复param", description = "添加回复param")
@Api("Reply")
class AddReplyParam : BaseAddParam<ReplyDo>() {
    /**
     * 触发关键词
     */
    @ApiModelProperty(value = "触发关键词", notes = "触发关键词", example = "傻狗", required = true)
    @InjectionParam(order = 0)
    var keyword: String? = null

    /**
     * 回复
     */
    @ApiModelProperty(value = "回复", notes = "回复", example = "傻狗叫谁", required = true)
    @InjectionParam(order = 1)
    var reply: String? = null

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    @ApiModelProperty(
        value = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)",
        notes = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)",
        example = "0",
        required = true
    )
    var matchType: Int? = null

    /**
     * 忽略大小写
     */
    @ApiModelProperty(value = "忽略大小写", notes = "忽略大小写", example = "0", required = true)
    var ignoreCase: Int? = null

    /**
     * 忽略全半角
     */
    @ApiModelProperty(value = "忽略全半角", notes = "忽略全半角", example = "0", required = true)
    var ignoreDbc: Int? = null

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", notes = "是否启用", example = "1", required = true)
    var enable: Int? = null
}
