package com.dasoops.dasserver.plugin.schedule.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.plugin.schedule.entity.dbo.ScheduleDo;
import org.springframework.scheduling.config.CronTask;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_schedule(plugin-sys-schedule 任务调度插件记录表)】的数据库操作Service
 * @createDate 2023-01-20 12:30:17
 */
public interface ScheduleService extends IService<ScheduleDo> {

    /**
     * 获取cron任务集合
     *
     * @return {@link List}<{@link CronTask}>
     */
    List<CronTask> getCronTasksList();
}
