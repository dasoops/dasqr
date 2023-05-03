package com.dasoops.dasqr.core.mapping.conf

import com.baomidou.mybatisplus.annotation.TableName
import com.dasoops.common.db.entity.dbo.BaseDo
import java.util.*

/**
 * 配置Do
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-01
 */
@TableName(value = "core_config")
class ConfigDo : BaseDo() {
    /**
     * 关键词
     */
    var keyword: String? = null

    /**
     * 值
     */
    var value: Any? = null

    /**
     * 描述
     */
    var description: String? = null
}