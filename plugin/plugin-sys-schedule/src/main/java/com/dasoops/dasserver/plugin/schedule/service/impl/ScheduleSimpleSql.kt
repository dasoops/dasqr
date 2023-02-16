package com.dasoops.dasserver.plugin.schedule.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.schedule.entity.dbo.ScheduleDo
import com.dasoops.dasserver.plugin.schedule.mapper.ScheduleMapper
import org.springframework.stereotype.Service


/**
 * @title ScheduleSimpleSql
 * @classPath com.dasoops.dasserver.plugin.schedule.service.impl.ScheduleSimpleSql
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/11
 * @version 1.0.0
 * @description 定时任务简单sql
 * @see [ScheduleSimpleSql]
 */
@Service
open class ScheduleSimpleSql : ServiceImpl<ScheduleMapper, ScheduleDo>()