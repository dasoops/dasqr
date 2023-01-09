package com.dasoops.dasserver.plugin.reboot.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.plugin.reboot.RebootProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title: plugin
 * @ClassPath com.dasoops.dasserver.core.plugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class RebootPlugin extends CqPlugin {

    private final RebootProperties rebootProperties;

    public RebootPlugin(RebootProperties rebootProperties) {
        this.rebootProperties = rebootProperties;
    }

    @MessageMapping(prefix = "reboot", type = MessageMappingTypeEnum.ALL)
    public String reboot() {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", rebootProperties.getRebootShellFilePath()});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "gogogo";
    }
}
