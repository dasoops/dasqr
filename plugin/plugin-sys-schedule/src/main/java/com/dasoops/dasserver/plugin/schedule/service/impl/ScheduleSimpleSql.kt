package com.dasoops.dasserver.plugin.schedule.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.schedule.entity.dbo.ScheduleDo
import com.dasoops.dasserver.plugin.schedule.mapper.ScheduleMapper
import org.springframework.stereotype.Service


/**
 * @Title: ScheduleSimpleSql
 * @ClassPath com.dasoops.dasserver.plugin.schedule.service.impl.ScheduleSimpleSql
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/11
 * @Version 1.0.0
 * @Description: 定时任务简单sql
 * @see [ScheduleSimpleSql]
 */
@Service
open class ScheduleSimpleSql : ServiceImpl<ScheduleMapper, ScheduleDo>()