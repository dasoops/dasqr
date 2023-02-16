package com.dasoops.dasserver.plugin.exec;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @title ExecProperties
 * @classPath com.dasoops.dasserver.plugin.exec.ExecProperties
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description execProperties
 */
@ConfigurationProperties(prefix = "dasq.plugin.exec")
@Data
public class ExecProperties {

    /**
     * 执行路径映射集合
     */
    private Map<String, String> execPathMap;

}
