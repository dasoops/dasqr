package com.dasoops.dasq.core.common.event;

import com.dasoops.dasq.core.common.entity.DasqProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

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
public class RebootEvent extends Thread {

    @Resource
    private DasqProperties dasqProperties;

    @Override
    public void run() {
        try {
            Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", dasqProperties.getRebootShellPath()});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
