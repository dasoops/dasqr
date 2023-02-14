package com.dasoops.dasserver.plugin.exec;

import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.plugin.exec.entity.enums.ExecExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title: ExecTemplate
 * @classPath com.dasoops.dasserver.plugin.exec.ExecTemplate
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description 执行Template
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ExecTemplate {

    private final ExecProperties execProperties;

    @SuppressWarnings("all")
    public void exec(String keyword) {
        String execFilePath = execProperties.getExecPathMap().get(keyword);
        if (execFilePath == null) {
            throw new LogicException(ExecExceptionEnum.UNDEFINED_KEYWORD);
        }
        new ExecThread(execFilePath).run();
    }

    @AllArgsConstructor
    @Slf4j
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
                throw new LogicException(ExecExceptionEnum.NO_SUCH_FILE);
            }
        }
    }

}
