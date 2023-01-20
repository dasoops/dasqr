package com.dasoops.dasserver.plugin.schedule.task;

import com.dasoops.common.task.BaseInitTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.plugin.schedule.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 初始化任务
 * @see BaseInitTask
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InitTask extends BaseInitTask {

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
