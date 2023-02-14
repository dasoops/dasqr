package com.dasoops.dasserver.plugin.schedule.task;

import com.dasoops.common.task.BaseTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @title: InitTask
 * @classPath com.dasoops.dasserver.plugin.schedule.task.InitTask
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 初始化任务
 * @see BaseTask
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InitTask extends BaseTask {

//    private final ScheduleService scheduleService;
//
//    @PostConstruct
//    public void initTask() {
//
//        List<CronTask> cronTaskList = scheduleService.getCronTasksList();
//
//        new SchedulingConfigurer() {
//            @Override
//            public void configureTasks(@NotNull ScheduledTaskRegistrar taskRegistrar) {
//                taskRegistrar.setCronTasksList(cronTaskList);
//            }
//        };
//    }


}
