package com.dasoops.dasserver.plugin.shell.log;

import com.dasoops.dasserver.plugin.shell.ShellTemplate;
import com.dasoops.dasserver.plugin.shell.entity.vo.LogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class LogSender extends Thread {

    private final ShellTemplate shellTemplate;
    private boolean beStop = false;

    @Override
    public void run() {
        LogQueue.getInstance().clear();
        try {
            while (!beStop) {
                LogDto logDto = LogQueue.getInstance().poll();
                shellTemplate.sendLog(logDto);
            }
        } catch (Exception e) {
            log.error("sendLog Error");
        }
    }

    public void beStop() {
        beStop = true;
    }
}