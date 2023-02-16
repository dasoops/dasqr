package com.dasoops.dasserver.plugin.exec;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @title AutoConfiguration
 * @classPath com.dasoops.dasserver.plugin.exec.AutoConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.exec")
@EnableConfigurationProperties(ExecProperties.class)
public class AutoConfiguration {

}
