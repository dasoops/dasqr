package com.dasoops.dasserver.plugin.loaj.entity.dbo

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.dasoops.common.entity.dbo.base.BaseDo

@TableName(value = "tb_plugin_loaj_reply")
class ReplyDo : BaseDo() {

    /**
     * 触发关键词
     */
    var keyword: String? = null

    /**
     * 回复
     */
    var reply: String? = null

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    var matchType: Int? = null

    /**
     * 忽略大小写
     */
    var ignoreCase: Int? = null

    /**
     * 忽略全半角
     */
    var ignoreDbc: Int? = null

    /**
     * 是否启用
     */
    @TableField("`enable`")
    var enable: Int? = null
}