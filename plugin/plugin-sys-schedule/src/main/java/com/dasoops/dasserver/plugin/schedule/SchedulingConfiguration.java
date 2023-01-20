package com.dasoops.dasserver.plugin.schedule;

import com.dasoops.dasserver.plugin.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: SchedulingConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.schedule.SchedulingConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 调度配置
 * @see SchedulingConfigurer
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SchedulingConfiguration implements SchedulingConfigurer {

    private final ScheduleService scheduleService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        List<CronTask> cronTaskList = scheduleService.getCronTasksList();
        taskRegistrar.setCronTasksList(cronTaskList);
    }
}
