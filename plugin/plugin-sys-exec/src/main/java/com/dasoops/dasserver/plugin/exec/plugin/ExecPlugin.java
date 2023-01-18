package com.dasoops.dasserver.plugin.exec.plugin;

import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.plugin.exec.ExecProperties;
import com.dasoops.dasserver.plugin.exec.entity.param.ExecParam;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title: TemplatePlugin
 * @ClassPath com.dasoops.dasserver.template.plugin.TemplatePlugin.TemplatePlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: 执行插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ExecPlugin extends CqPlugin {

    private final ExecProperties execProperties;

    @MessageMapping(prefix = "exec", type = MessageMappingTypeEnum.ALL)
    @SuppressWarnings("all")
    public String exec(MappingMessage<ExecParam> message, CqTemplate cqTemplate) {
        String execFileKeyword = message.getParam().getExecFileKeyword();
        String execFilePath = execProperties.getExecPathMap().get(execFileKeyword);
        if (execFilePath == null) {
            return "无效的关键词";
        }
        //放行
        cqTemplate.sendMsg(message, "gogogo");
        new ExecThread(execFilePath).run();
        return "gogogo";
    }


    @AllArgsConstructor
    static class ExecThread extends Thread {
        private final String execFilePath;

        @Override
        public void run() {
            try {
                Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", execFilePath});
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
