package com.dasoops.dasqr.plugin.pluginManager.runner

import cn.hutool.core.collection.CollUtil
import com.dasoops.common.core.util.ClassUtil
import com.dasoops.common.db.ktorm.KtormGlobal.default
import com.dasoops.common.db.ktorm.baseSave
import com.dasoops.dasqr.core.plugin.LoadPlugin
import com.dasoops.dasqr.core.plugin.PluginPool
import com.dasoops.dasqr.plugin.pluginManager.mapping.AuthLevel
import com.dasoops.dasqr.plugin.pluginManager.mapping.PluginDao
import com.dasoops.dasqr.plugin.pluginManager.mapping.PluginDo
import com.dasoops.dasqr.plugin.pluginManager.mapping.PluginDos
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.expression.BinaryExpression

/**
 * 插件数据启动类
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 * @see [PluginRunner]
 */
object PluginRunner {

    lateinit var loadPluginDoExtensionMap: Map<LoadPlugin, PluginDo>

    fun init() {
        val loadList = PluginPool.INSTANCE.loadList

        //基于已加载插件查询有记录的插件
        lateinit var expression: BinaryExpression<Boolean>
        loadList.forEachIndexed { index, it ->
            expression = if (index == 0) {
                (PluginDos.listenerHostClass eq ClassUtil.getUserClass(it.listenerHost).name) and (PluginDos.methodName eq it.methodName)
            } else {
                expression.or((PluginDos.listenerHostClass eq ClassUtil.getUserClass(it.listenerHost).name) and (PluginDos.methodName eq it.methodName))
            }
        }
        var dbList = PluginDao.findList { expression }

        val loadMap = loadList.associateBy { ClassUtil.getUserClass(it.listenerHost).name to it.methodName }
        var dbMap = dbList.associateBy { it.listenerHostClass to it.methodName }

        //加载了但是没有数据库记录的
        val missingDbRecordList = CollUtil.subtract(loadMap.keys, dbMap.keys)
        if (missingDbRecordList.isNotEmpty()) {
            Database.default.batchInsert(PluginDos) {
                missingDbRecordList.forEach {
                    val loadPlugin = loadMap[it]!!
                    val dasqrPlugin = loadPlugin.from
                    item { pluginDos ->
                        baseSave(pluginDos)
                        set(PluginDos.enable, true)
                        set(PluginDos.pluginAuthor, dasqrPlugin.author)
                        set(PluginDos.pluginDescription, dasqrPlugin.description)
                        set(pluginDos.pluginVersion, dasqrPlugin.version)
                        set(pluginDos.pluginName, dasqrPlugin.name)
                        set(pluginDos.listenerHostClass, it.first)
                        set(PluginDos.methodName, it.second)
                        set(pluginDos.order, Int.MAX_VALUE)
                        set(pluginDos.authLevel, AuthLevel.NORMAL)
                    }
                }
            }
            dbList = PluginDao.findList { expression }
            dbMap = dbList.associateBy { it.listenerHostClass to it.methodName }
        }

        loadPluginDoExtensionMap = loadList.associateWith { dbMap[ClassUtil.getUserClass(it.listenerHost).name to it.methodName]!! }
    }

    val LoadPlugin.pluginDo: PluginDo
        get() = loadPluginDoExtensionMap[this]!!
}