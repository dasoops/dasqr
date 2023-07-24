package com.dasoops.dasqr.plugin.pluginManager.auth

import com.dasoops.common.core.util.ClassUtil
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.listener.DslEventHandlerMetaData
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.GroupDslEventHandlerMetaData
import com.dasoops.dasqr.plugin.config.Cache
import com.dasoops.dasqr.plugin.pluginManager.mapping.PluginOtmRegisterDao
import com.dasoops.dasqr.plugin.pluginManager.mapping.RegisterType
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.ListenerHost
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageEvent
import org.ktorm.dsl.eq
import org.ktorm.dsl.isNull
import org.ktorm.entity.filter
import org.ktorm.entity.first
import org.slf4j.LoggerFactory
import java.lang.reflect.Method

/**
 * 身份验证
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 */
object Auth {

    private val log = LoggerFactory.getLogger(javaClass)

    private inline fun Boolean.ifFalse(func: () -> Unit) {
        if (!this) func()
    }

    // 10分钟缓存 key -> Pair<Sender,插件标识符(全限定类目 + 方法名)>
    val authCache = Cache.newTimedCache<Pair<Contact, String>, Boolean>(Auth::class, 60 * 1000 * 10)

    fun auth(clazz: Class<DslListenerHost>, metaData: DslEventHandlerMetaData, messageEvent: MessageEvent): Boolean {
        //通用参数
        val isGroupMessage = metaData is GroupDslEventHandlerMetaData
        val listenerHostClassName = ClassUtil.getUserClass(clazz, "$$").name
        val listenerHostMethodName = metaData.name

        return auth(isGroupMessage, messageEvent, listenerHostClassName, listenerHostMethodName)
    }

    fun auth(method: Method, listenerHost: ListenerHost, messageEvent: MessageEvent): Boolean {
        //暂不对非群组信息/好友信息的消息进行权限校验
        if (messageEvent !is GroupMessageEvent && messageEvent !is FriendMessageEvent) {
            return true
        }
        //通用参数
        val isGroupMessage = messageEvent is GroupMessageEvent
        val listenerHostClassName = ClassUtil.getUserClass(listenerHost::class.java, "$$").name
        val listenerHostMethodName = method.name

        return auth(isGroupMessage, messageEvent, listenerHostClassName, listenerHostMethodName)
    }

    private fun auth(
        isGroupMessage: Boolean,
        messageEvent: MessageEvent,
        listenerHostClassName: String,
        listenerHostMethodName: String,
    ): Boolean {
        val sender = messageEvent.sender
        val pluginTag = "$listenerHostClassName.$listenerHostMethodName"
        /*
        1. [群组消息]   群是否具有插件权限
        2. [好友消息]   好友是否具有插件权限
        3. [群组消息]   群组内用户是否具有插件权限
         */


        if (isGroupMessage) {
            //step 1
            messageEvent as GroupMessageEvent
            authCache.getOrNullAndSet(messageEvent.group to pluginTag) {
                PluginOtmRegisterDao.sequenceOf()
                    .filter { it.botId eq IBot.id }
                    .filter { it.registerType eq RegisterType.GROUP }
                    .filter { it.listenerHostClassName eq listenerHostClassName }
                    .filter { it.listenerHostMethodName eq listenerHostMethodName }
                    .filter { it.groupId eq messageEvent.group.id }
                    .filter { it.userId.isNull() }
                    .first().pass
            }.ifFalse {
                log.trace(
                    """
                    [auth_step_1] ${sender.nick} $pluginTag return false;
                """.trimIndent()
                )
                return false
            }
        } else {
            //step 2
            messageEvent as FriendMessageEvent
            authCache.getOrNullAndSet(messageEvent.sender to pluginTag) {
                PluginOtmRegisterDao.sequenceOf()
                    .filter { it.botId eq IBot.id }
                    .filter { it.registerType eq RegisterType.FRIEND }
                    .filter { it.listenerHostClassName eq listenerHostClassName }
                    .filter { it.listenerHostMethodName eq listenerHostMethodName }
                    .filter { it.userId eq messageEvent.user.id }
                    .filter { it.groupId.isNull() }
                    .first().pass
            }.ifFalse {
                log.trace(
                    """
                    [auth_step_2] ${sender.nick} $pluginTag return false;
                """.trimIndent()
                )
                return false
            }
        }

        //step 3
        if (isGroupMessage) {
            authCache.getOrNullAndSet(sender to pluginTag) {
                PluginOtmRegisterDao.sequenceOf()
                    .filter { it.botId eq IBot.id }
                    .filter { it.registerType eq RegisterType.USER_IN_GROUP }
                    .filter { it.listenerHostClassName eq listenerHostClassName }
                    .filter { it.listenerHostMethodName eq listenerHostMethodName }
                    .filter { it.userId eq sender.id }
                    .apply {
                        if (sender is Member) {
                            filter { it.groupId eq sender.group.id }
                        } else {
                            filter { it.groupId.isNull() }
                        }
                    }
                    .first().pass
            }.ifFalse {
                log.trace("""
                    [auth_step_3] ${sender.nick} $pluginTag return false;
                """.trimIndent())
                return false
            }
        }

        log.trace("""
            [auth] ${sender.nick} $pluginTag() return true;
        """.trimIndent())
        return true
    }
}