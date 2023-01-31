package com.dasoops.dasserver.plugin.loaj.entity.vo

import com.baomidou.mybatisplus.annotation.TableField
import com.dasoops.common.entity.vo.base.BaseVo
import io.swagger.annotations.ApiModelProperty

class GetReplyVo : BaseVo() {

    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "15", required = false)
    var rowId: Long? = null;

    /**
     * 触发关键词
     */
    @ApiModelProperty(value = "触发关键词", notes = "触发关键词", example = "傻狗", required = true)
    var keyword: String? = null

    /**
     * 回复
     */
    @ApiModelProperty(value = "回复", notes = "回复", example = "傻狗叫谁", required = true)
    var reply: String? = null

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    @ApiModelProperty(
        value = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)",
        notes = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)",
        example = "1",
        required = true
    )
    var matchType: Int? = null

    /**
     * 忽略大小写
     */
    @ApiModelProperty(value = "忽略大小写", notes = "忽略大小写", example = "1", required = true)
    var ignoreCase: Int? = null

    /**
     * 忽略全半角
     */
    @ApiModelProperty(value = "忽略全半角", notes = "忽略全半角", example = "1", required = true)
    var ignoreDbc: Int? = null

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", notes = "是否启用", example = "1", required = true)
    @TableField("`enable`")
    var enable: Int? = null

}