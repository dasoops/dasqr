package com.dasoops.dasserver.plugin.reboot.plugin;

import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.plugin.reboot.RebootProperties;
import com.dasoops.dasserver.plugin.reboot.entity.enums.QuietRebootEnum;
import com.dasoops.dasserver.plugin.reboot.entity.enums.RebootConfigHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class RebootPlugin extends CqPlugin {

    private final RebootProperties rebootProperties;
    private final ConfigCache configCache;

    @SuppressWarnings("all")
    @MessageMapping(prefix = "reboot", type = MessageMappingTypeEnum.ALL)
    public String reboot(CqTemplate cqTemplate, MappingMessage<SimpleParam> param) {
        QuietRebootEnum quietRebootEnum = configCache.getEnumConfig(RebootConfigHashKeyEnum.QUIET_REBOOT, QuietRebootEnum.class);
        if (quietRebootEnum.equals(QuietRebootEnum.FALSE)) {
            cqTemplate.sendMsg(param, "gogogo");
        }
        //改start会有问题,同步异步
        new RebootThread(rebootProperties).run();
        if (quietRebootEnum.equals(QuietRebootEnum.FALSE)) {
            return "compile complete,to reboot";
        }
        return null;
    }

    @AllArgsConstructor
    static class RebootThread extends Thread {
        private final RebootProperties rebootProperties;

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

}
