package com.dasoops.dasserver.plugin.exec;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Title: ExecProperties
 * @ClassPath com.dasoops.dasserver.plugin.exec.ExecProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: execProperties
 */
@ConfigurationProperties(prefix = "dasq.plugin.exec")
@Data
public class ExecProperties {

    /**
     * 执行路径映射集合
     */
    private Map<String, String> execPathMap;

}
