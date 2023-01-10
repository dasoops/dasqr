package com.dasoops.dasserver.plugin.reboot.plugin;

import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.plugin.reboot.RebootProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title: RebootEvent
 * @ClassPath com.dasoops.dasq.core.common.event.RebootEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description: 重新启动事件
 * @see Thread
 */
@Component
@Slf4j
public class RebootThread extends Thread {

    @Resource
    private RebootProperties rebootProperties;

    @Override
    public void run() {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", rebootProperties.getRebootShellFilePath()});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            throw new LogicException(e);
        }
    }
}
