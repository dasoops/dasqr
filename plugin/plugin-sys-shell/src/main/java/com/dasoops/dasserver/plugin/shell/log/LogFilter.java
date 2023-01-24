package com.dasoops.dasserver.plugin.shell.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.dasoops.dasserver.plugin.shell.entity.vo.LogDto;

/**
 * @Title: logFilter
 * @ClassPath com.dasoops.dasserver.plugin.shell.logFilter
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/25
 * @Version 1.0.0
 * @Description: 日志过滤器
 * @see Filter
 */
public class LogFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        LogDto logDto = new LogDto();
        logDto.setLevel(event.getLevel().levelStr);
        logDto.setMsg(event.getFormattedMessage());
        LogQueue.getInstance().push(logDto);
        return FilterReply.ACCEPT;
    }
}
