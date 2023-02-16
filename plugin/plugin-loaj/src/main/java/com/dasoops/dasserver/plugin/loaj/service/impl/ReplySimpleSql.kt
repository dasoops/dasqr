package com.dasoops.dasserver.plugin.loaj.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo
import com.dasoops.dasserver.plugin.loaj.mapper.ReplyMapper
import org.springframework.stereotype.Service

/**
 * @title ReplySimpleSql
 * @classPath com.dasoops.dasserver.plugin.loaj.service.impl.ReplySimpleSql
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/11
 * @version 1.0.0
 * @description 回复简单sql
 * @see [ReplySimpleSql]
 */
@Service
open class ReplySimpleSql : ServiceImpl<ReplyMapper, ReplyDo>()