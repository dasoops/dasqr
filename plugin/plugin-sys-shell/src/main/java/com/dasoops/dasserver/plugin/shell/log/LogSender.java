package com.dasoops.dasserver.plugin.shell.log;

import com.dasoops.dasserver.plugin.shell.ShellTemplate;
import com.dasoops.dasserver.plugin.shell.entity.vo.LogDto;
import lombok.RequiredArgsConstructor;

/**
 * @Title: LogSender
 * @ClassPath com.dasoops.dasserver.plugin.shell.log.LogSender
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/25
 * @Version 1.0.0
 * @Description: 日志发送方
 * @see Thread
 */
@RequiredArgsConstructor
public class LogSender extends Thread {

    private final ShellTemplate shellTemplate;
    private boolean beStop = false;

    @Override
    public void run() {
        LogQueue.getInstance().clear();
        while (!beStop) {
            LogDto logDto = LogQueue.getInstance().poll();
            shellTemplate.sendLog(logDto);
        }
    }

    public void beStop() {
        beStop = true;
    }
}
