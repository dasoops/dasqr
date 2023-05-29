package com.dasoops.dasqr.plugin.pluginManager.runner

import cn.hutool.core.collection.CollUtil
import com.dasoops.common.db.ktorm.KtormGlobal.default
import com.dasoops.common.db.ktorm.baseSave
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.plugin.PluginPool
import com.dasoops.dasqr.plugin.pluginManager.mapping.*
import com.dasoops.dasqr.plugin.pluginManager.runner.PluginRunner.pluginDo
import org.ktorm.database.Database
import org.ktorm.dsl.AssignmentsBuilder
import org.ktorm.dsl.batchInsert
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList

/**
 * 插件单对多注册对象跑步者
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 */
object PluginOtmRegisterRunner {
    fun init() {
        //已注册的插件-注册用户集合
        val loadList = PluginPool.INSTANCE.loadList
        val pluginDoIdOtoLoadPlugin = loadList.associateBy { it.pluginDo.rowId }
        val otmDoGroupByPluginRowId = PluginOtmRegisterDao.findList {
            it.pluginRowId inList loadList.map { loadPlugin -> loadPlugin.pluginDo.rowId }
        }.groupBy { pluginDoIdOtoLoadPlugin[it.pluginRowId]!! }

        //注册用户集合
        val registerDoList = RegisterDao.findList { it.botId eq IBot.id }
        val registerRowIdOtoRegisterDo = registerDoList.associateBy { it.rowId }

        //缺失的Do
        val missingOtmDoList = mutableListOf<AssignmentsBuilder.(it: PluginOtmRegisterDos) -> Unit>()

        loadList.forEach { loadPlugin ->
            val pluginDo = loadPlugin.pluginDo

            //先判断个size
            val loadPluginRegisterDoList = otmDoGroupByPluginRowId[loadPlugin] ?: emptyList()
            if (loadPluginRegisterDoList.size == registerDoList.size) {
                return@forEach
            }

            //注册了,但是插件用户映射表没有的
            missingOtmDoList.addAll(CollUtil.subtract(
                registerDoList.map { it.rowId },
                loadPluginRegisterDoList.map { it.registerRowId }
            ).map {
                val registerDo = registerRowIdOtoRegisterDo[it]!!
                return@map item(registerDo, pluginDo)
            })
        }
        if (missingOtmDoList.isNotEmpty()) {
            Database.default.batchInsert(PluginOtmRegisterDos) {
                missingOtmDoList.forEach {
                    item(it)
                }
            }
        }
    }

    private fun item(
        registerDo: RegisterDo,
        pluginDo: PluginDo,
    ): AssignmentsBuilder.(it: PluginOtmRegisterDos) -> Unit {
        val item: AssignmentsBuilder.(it: PluginOtmRegisterDos) -> Unit = {
            baseSave(it)
            set(it.botId, IBot.id)
            set(it.groupId, registerDo.groupId)
            set(it.registerRowId, registerDo.rowId)
            set(it.userId, registerDo.userId)
            set(it.listenerHostClassName, pluginDo.listenerHostClass)
            set(it.listenerHostMethodName, pluginDo.methodName)
            set(it.pluginRowId, pluginDo.rowId)
            set(it.registerType, registerDo.type)
            set(it.pass, AuthLevel.isAuth(pluginDo.authLevel, registerDo.authLevel))
        }
        return item
    }


}