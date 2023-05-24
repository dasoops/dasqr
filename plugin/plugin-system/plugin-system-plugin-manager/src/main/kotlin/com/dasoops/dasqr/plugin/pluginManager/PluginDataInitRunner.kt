package com.dasoops.dasqr.plugin.pluginManager

import cn.hutool.core.collection.CollUtil
import com.dasoops.common.db.ktorm.KtormGlobal.default
import com.dasoops.common.db.ktorm.baseSave
import com.dasoops.common.db.ktorm.baseUpdate
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.runner.Runner
import com.dasoops.dasqr.core.runner.RunnerLevel
import com.dasoops.dasqr.plugin.pluginManager.mapping.*
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.contact.ContactList
import org.ktorm.database.Database
import org.ktorm.dsl.batchInsert
import org.ktorm.dsl.batchUpdate
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList

/**
 * 数据库数据初始化Runner
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 * @see [PluginDataInitRunner]
 */
object PluginDataInitRunner : Runner {
    override val level = RunnerLevel.AFTER_BOT_INIT

    override suspend fun init() {
        val allRegister = RegisterDao.findList {
            it.botId eq IBot.id
        }

        //初始化好友
        initFriend(allRegister.filter { it.type == RegisterType.FRIEND })
        initGroup(allRegister.filter { it.type == RegisterType.GROUP })
        initGroupUser(allRegister.filter { it.type == RegisterType.USER_IN_GROUP })
    }

    private fun initFriend(dbFriendList: List<RegisterDo>) {
        val botFriendList = IBot.friends

        val (deleteFriendList, initFriendList) = calcList(dbFriendList, botFriendList)

        if (deleteFriendList.isNotEmpty()) {
            RegisterDao.deleteIf {
                it.botId eq IBot.id
                it.userId inList deleteFriendList
                it.type eq RegisterType.FRIEND
            }
        }

        if (initFriendList.isNotEmpty()) {
            Database.default.batchInsert(RegisterDos) {
                initFriendList.forEach { id ->
                    item {
                        baseSave(it)
                        set(it.botId, IBot.id)
                        set(it.groupId, null)
                        set(it.userId, id)
                        set(it.type, RegisterType.FRIEND)
                        set(it.authLevel, AuthLevel.EXCLUDE)
                    }
                }
            }
        }
    }

    private fun initGroup(dbList: List<RegisterDo>) {
        val botList = IBot.groups
        val (deleteList, initFriendList) = calcList(dbList, botList)

        if (deleteList.isNotEmpty()) {
            RegisterDao.deleteIf {
                it.botId eq IBot.id
                it.userId inList deleteList
                it.type eq RegisterType.GROUP
            }
        }

        if (initFriendList.isNotEmpty()) {
            Database.default.batchInsert(RegisterDos) {
                initFriendList.forEach { id ->
                    item {
                        baseSave(it)
                        set(it.botId, IBot.id)
                        set(it.groupId, id)
                        set(it.userId, null)
                        set(it.type, RegisterType.GROUP)
                        set(it.authLevel, AuthLevel.EXCLUDE)
                    }
                }
            }
        }
    }

    private fun initGroupUser(dbList: List<RegisterDo>) {
        val botList = IBot.groups.flatMap {
            it.members
        }
        val dbIdList = dbList.map { it.groupId to it.userId }
        val botIdList = botList.map { it.group.id to it.id }
        //数据库包含,bot不包含,删除的群组,删除
        val deleteList = CollUtil.subtract(dbIdList, botIdList)
        //bot包含,数据库不包含,新增加的群组,初始化
        val initFriendList = CollUtil.subtract(botIdList, dbIdList)

        if (deleteList.isNotEmpty()) {
            Database.default.batchUpdate(RegisterDos) {
                deleteList.forEach { (groupId, userId) ->
                    item {
                        set(it.isDelete, false)
                        where {
                            baseUpdate(it)
                            it.botId eq IBot.id
                            it.type eq RegisterType.USER_IN_GROUP
                            it.groupId eq groupId
                            it.userId eq userId
                        }
                    }
                }
            }
        }

        if (initFriendList.isNotEmpty()) {
            Database.default.batchInsert(RegisterDos) {
                initFriendList.forEach { (groupId, userId) ->
                    item {
                        baseSave(it)
                        set(it.botId, IBot.id)
                        set(it.groupId, groupId)
                        set(it.userId, userId)
                        set(it.type, RegisterType.USER_IN_GROUP)
                        set(it.authLevel, AuthLevel.EXCLUDE)
                    }
                }
            }
        }
    }

    private fun <T : Contact> calcList(
        dbList: List<RegisterDo>,
        botList: ContactList<T>
    ): Pair<MutableCollection<Long>, MutableCollection<Long>> {
        val dbIdList = dbList.map { it.userId }
        val botIdList = botList.map { it.id }
        //数据库包含,bot不包含,删除的群组,删除
        val deleteList = CollUtil.subtract(dbIdList, botIdList)
        //bot包含,数据库不包含,新增加的群组,初始化
        val initFriendList = CollUtil.subtract(botIdList, dbIdList)
        return Pair(deleteList, initFriendList)
    }
}