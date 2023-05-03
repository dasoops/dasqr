package com.dasoops.dasqr.core.mapping.log.message

import com.baomidou.mybatisplus.annotation.TableName
import com.dasoops.common.db.entity.dbo.BaseDo

/**
 * 消息日志Do
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-01
 */
@TableName(value = "core_message_log")
class MessageLogDo : BaseDo() {
    /**
     * 发送人qq
     */
    var senderQq: Long? = null

    /**
     * 发送人所在群qq
     */
    var senderGroupQq: Long? = null

    /**
     * 发送人名称(不随其变化更新,请仅用于显示)
     */
    var senderName: String? = null

    /**
     * 值守botqq
     */
    var dutyBotQq: Long? = null

    /**
     * 消息主键
     */
    var msgRowId: Long? = null

    /**
     * 消息
     */
    var msg: String? = null
}