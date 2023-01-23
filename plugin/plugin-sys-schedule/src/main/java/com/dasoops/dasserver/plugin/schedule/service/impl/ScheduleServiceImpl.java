package com.dasoops.dasserver.plugin.schedule.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.base.DbBooleanEnum;
import com.dasoops.common.util.RegexUtil;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.exception.ExceptionTemplate;
import com.dasoops.dasserver.plugin.schedule.entity.dbo.ScheduleDo;
import com.dasoops.dasserver.plugin.schedule.mapper.ScheduleMapper;
import com.dasoops.dasserver.plugin.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_schedule(plugin-sys-schedule 任务调度插件记录表)】的数据库操作Service实现
 * @createDate 2023-01-20 12:30:17
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, ScheduleDo>
        implements ScheduleService {

    private final ExceptionTemplate exceptionTemplate;
    private final ApplicationContext applicationContext;

    @Override
    public List<CronTask> getCronTasksList() {
        List<ScheduleDo> scheduleDoList = super.list();
        List<CronTask> cronTaskList = scheduleDoList.stream().map(scheduleDo -> {
            if (scheduleDo.getEnable().equals(DbBooleanEnum.FALSE.getDbValue())) {
                return null;
            }
            String cron = scheduleDo.getCron();
            String cronRegex = "^\\s*($|#|\\w+\\s*=|(\\?|\\*|(?:[0-5]?\\d)(?:(?:-|\\/|\\,)(?:[0-5]?\\d))?(?:,(?:[0-5]?\\d)(?:(?:-|\\/|\\,)(?:[0-5]?\\d))?)*)\\s+(\\?|\\*|(?:[0-5]?\\d)(?:(?:-|\\/|\\,)(?:[0-5]?\\d))?(?:,(?:[0-5]?\\d)(?:(?:-|\\/|\\,)(?:[0-5]?\\d))?)*)\\s+(\\?|\\*|(?:[01]?\\d|2[0-3])(?:(?:-|\\/|\\,)(?:[01]?\\d|2[0-3]))?(?:,(?:[01]?\\d|2[0-3])(?:(?:-|\\/|\\,)(?:[01]?\\d|2[0-3]))?)*)\\s+(\\?|\\*|(?:0?[1-9]|[12]\\d|3[01])(?:(?:-|\\/|\\,)(?:0?[1-9]|[12]\\d|3[01]))?(?:,(?:0?[1-9]|[12]\\d|3[01])(?:(?:-|\\/|\\,)(?:0?[1-9]|[12]\\d|3[01]))?)*)\\s+(\\?|\\*|(?:[1-9]|1[012])(?:(?:-|\\/|\\,)(?:[1-9]|1[012]))?(?:L|W)?(?:,(?:[1-9]|1[012])(?:(?:-|\\/|\\,)(?:[1-9]|1[012]))?(?:L|W)?)*|\\?|\\*|(?:JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)(?:(?:-)(?:JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))?(?:,(?:JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)(?:(?:-)(?:JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))?)*)\\s+(\\?|\\*|(?:[0-6])(?:(?:-|\\/|\\,|#)(?:[0-6]))?(?:L)?(?:,(?:[0-6])(?:(?:-|\\/|\\,|#)(?:[0-6]))?(?:L)?)*|\\?|\\*|(?:MON|TUE|WED|THU|FRI|SAT|SUN)(?:(?:-)(?:MON|TUE|WED|THU|FRI|SAT|SUN))?(?:,(?:MON|TUE|WED|THU|FRI|SAT|SUN)(?:(?:-)(?:MON|TUE|WED|THU|FRI|SAT|SUN))?)*)(|\\s)+(\\?|\\*|(?:|\\d{4})(?:(?:-|\\/|\\,)(?:|\\d{4}))?(?:,(?:|\\d{4})(?:(?:-|\\/|\\,)(?:|\\d{4}))?)*))$";
            if (!RegexUtil.isMatch(cronRegex, cron)) {
                log.error("错误的cron表达式: {},rowId: {}", cron, scheduleDo.getRowId());
                return null;
            }
            try {
                Class<?> methodClass = Class.forName(scheduleDo.getRunMethodClassName());
                Object methodClassObj = applicationContext.getBean(methodClass);
                Class<?> paramClass = Class.forName(scheduleDo.getParameterClassName());
                Method method = methodClass.getMethod(scheduleDo.getRunMethod(), paramClass);
                Object param = JSON.parseObject(scheduleDo.getParameterJson(), paramClass);
                Runnable runnable = () -> {
                    try {
                        method.invoke(methodClassObj, param);
                    } catch (Exception e) {
                        CqGlobal.getAll().forEach(cqTemplate -> {
                            exceptionTemplate.resloveException(cqTemplate, e);
                        });
                    }
                };
                return new CronTask(runnable, cron);
            } catch (Exception e) {
                log.error("schedule初始化异常:", e);
                return null;
            }
        }).filter(Objects::nonNull).toList();
        return cronTaskList;
    }


}




