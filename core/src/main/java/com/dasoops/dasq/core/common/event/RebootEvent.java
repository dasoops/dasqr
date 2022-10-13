package com.dasoops.dasq.core.common.event;

import com.dasoops.dasq.core.common.entity.DasqProperties;
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
public class RebootEvent extends Thread {

    @Resource
    private DasqProperties dasqProperties;

    @Override
    public void run() {
        try {
            log.info("1");
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", dasqProperties.getRebootShellPath()});
            log.info("2");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
