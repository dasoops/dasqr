package com.dasoops.dasqr.plugin.pluginManager.runner

import cn.hutool.core.collection.CollUtil
import com.dasoops.common.db.ktorm.KtormGlobal.default
import com.dasoops.common.db.ktorm.baseSave
import com.dasoops.common.db.ktorm.baseUpdate
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.plugin.pluginManager.mapping.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.ktorm.database.Database
import org.ktorm.dsl.*

/**
 * 数据库数据初始化Runner
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/24
 * @see [RegisterRunner]
 */
object RegisterRunner {
    suspend fun init() = withContext(Dispatchers.IO) {
        val allRegister = RegisterDao.findList {
            it.botId eq IBot.id
        }

        listOf(
            launch(Dispatchers.IO) {
                initGroupUser(allRegister.filter { it.type == RegisterType.USER_IN_GROUP })
            },
            launch(Dispatchers.IO) {
                initGroup(allRegister.filter { it.type == RegisterType.GROUP })
            },
            launch(Dispatchers.IO) {
                initFriend(allRegister.filter { it.type == RegisterType.FRIEND })
            }
        ).joinAll()
    }

    private fun initFriend(dbFriendList: List<RegisterDo>) {
        val botFriendList = IBot.friends

        val (deleteFriendList, initFriendList) =
            calcList(dbFriendList.map { it.userId!! }, botFriendList.map { it.id })

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
        val (deleteList, initList) =
            calcList(dbList.map { it.groupId!! }, botList.map { it.id })

        if (deleteList.isNotEmpty()) {
            RegisterDao.deleteIf {
                it.botId eq IBot.id
                it.userId inList deleteList
                it.type eq RegisterType.GROUP
            }
        }

        if (initList.isNotEmpty()) {
            Database.default.batchInsert(RegisterDos) {
                initList.forEach { id ->
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
                            if (groupId != null){
                                it.groupId eq groupId
                            }else{
                                it.groupId.isNull()
                            }
                            if (userId != null){
                                it.userId eq userId
                            }else{
                                it.userId.isNull()
                            }
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

    private fun calcList(
        dbList: Collection<Long>,
        botList: Collection<Long>,
    ): Pair<MutableCollection<Long>, MutableCollection<Long>> {
        //数据库包含,bot不包含,删除的群组,删除
        val deleteList = CollUtil.subtract(dbList, botList)
        //bot包含,数据库不包含,新增加的群组,初始化
        val initFriendList = CollUtil.subtract(botList, dbList)
        return Pair(deleteList, initFriendList)
    }
}