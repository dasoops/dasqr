package com.dasoops.dasserver.cq.simplesql

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo
import com.dasoops.dasserver.cq.entity.dbo.PluginDo
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo
import com.dasoops.dasserver.cq.mapper.ConfigMapper
import com.dasoops.dasserver.cq.mapper.PluginMapper
import com.dasoops.dasserver.cq.mapper.RegisterMapper
import com.dasoops.dasserver.cq.mapper.RegisterMtmPluginMapper
import org.springframework.stereotype.Service

/**
 * @title SimpleSql
 * @classPath com.dasoops.dasserver.cq.simplesql
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/10
 * @version 1.0.0
 * @description 注册简单sql
 * @see [ServiceImpl]
 */

@Service
open class ConfigSimpleSql : ServiceImpl<ConfigMapper, ConfigDo>()

@Service
open class PluginSimpleSql : ServiceImpl<PluginMapper, PluginDo>()

@Service
open class RegisterSimpleSql : ServiceImpl<RegisterMapper, RegisterDo>()

@Service
open class RegisterMtmPluginSimpleSql : ServiceImpl<RegisterMtmPluginMapper, RegisterMtmPluginDo>()