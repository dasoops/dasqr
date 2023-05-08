package com.dasoops.dasqr.plugin.log.message

import com.dasoops.common.core.entity.dataenum.DataEnum
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.GroupMessageSyncEvent
import net.mamoe.mirai.event.events.GroupTempMessageEvent
import net.mamoe.mirai.event.events.GroupTempMessageSyncEvent
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.event.events.StrangerMessageEvent

/**
 * 消息类型
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class MessageType : DataEnum {
    /**
     * 群组消息
     */
    GROUP_MESSAGE,

    /**
     * 临时群消息
     */
    GROUP_TEMP_MESSAGE,

    /**
     * 好友消息
     */
    FRIEND_MESSAGE,

    /**
     * 陌生人消息
     */
    STRANGER_MESSAGE;

    override val data = ordinal

    companion object {
        fun get(event: MessageEvent): MessageType {
            return getOrNull(event) ?: throw MessageLogException.UNDEFINED_MESSAGE_TYPE.get()
        }

        fun getOrNull(event: MessageEvent): MessageType? {
            return when (event) {
                is GroupMessageEvent -> GROUP_MESSAGE
                is GroupMessageSyncEvent -> GROUP_MESSAGE

                is GroupTempMessageEvent -> GROUP_TEMP_MESSAGE
                is GroupTempMessageSyncEvent -> GROUP_TEMP_MESSAGE

                is FriendMessageEvent -> FRIEND_MESSAGE
                is StrangerMessageEvent -> STRANGER_MESSAGE

                else -> null
            }
        }
    }
}