package com.dasoops.dasserver.plugin.exec;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: AutoConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.exec.AutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.exec")
@EnableConfigurationProperties(ExecProperties.class)
public class AutoConfiguration {

}
