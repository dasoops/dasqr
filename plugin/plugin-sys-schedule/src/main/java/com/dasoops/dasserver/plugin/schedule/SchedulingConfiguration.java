package com.dasoops.dasserver.plugin.schedule;

import com.dasoops.dasserver.plugin.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @title: SchedulingConfiguration
 * @classPath com.dasoops.dasserver.plugin.schedule.SchedulingConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 调度配置
 * @see SchedulingConfigurer
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SchedulingConfiguration implements SchedulingConfigurer {

    private final ScheduleService scheduleService;

    @Override
    public void configureTasks(@NotNull ScheduledTaskRegistrar taskRegistrar) {
        List<CronTask> cronTaskList = scheduleService.getCronTasksList();
        taskRegistrar.setCronTasksList(cronTaskList);
    }
}
