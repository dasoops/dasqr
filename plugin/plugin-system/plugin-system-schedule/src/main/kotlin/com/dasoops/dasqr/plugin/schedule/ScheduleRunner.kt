package com.dasoops.dasqr.plugin.schedule

import cn.hutool.cron.CronUtil
import cn.hutool.cron.task.Task
import com.dasoops.dasqr.core.Finder
import com.dasoops.dasqr.core.runner.Runner
import org.ktorm.dsl.eq
import org.slf4j.LoggerFactory

/**
 * 定时任务启动器
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 */
object ScheduleRunner : Runner {
    private val log = LoggerFactory.getLogger(javaClass)
    val scheduleList = mutableListOf<Schedule>()

    override fun init() {
        //重新启动
        CronUtil.restart()
        CronUtil.setMatchSecond(true)

        //添加任务
        ScheduleDao.INSTANCE.findList {
            it.enable eq true
        }.forEach {
            log.info(
                """
                |load schedule:
                |    cron: ${it.cron} 
                |    class: ${it.`class`}
                |    param: ${it.paramJson}
            """.trimMargin()
            )
            val scheduleTask = Finder.getObjectInstacnce<ScheduleTask>(it.`class`)

            val id = CronUtil.schedule(it.cron, Task {
                scheduleTask.run(it.paramJson)
            })

            //留一份方便做拓展
            scheduleList.add(
                Schedule(
                    task = scheduleTask,
                    id = id,
                    sqlDo = it,
                )
            )
        }
    }
}

data class Schedule(
    val task: ScheduleTask,
    val id: String,
    val sqlDo: ScheduleDo
)

/**
 * 定时任务
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [ScheduleTask]
 */
interface ScheduleTask {
    /**
     * 运行
     */
    fun run(paramJson: String?)
}