package com.dasoops.dasserver.plugin.reboot;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: configuration
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/02
 * @Version 1.0.0
 * @Description: 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.reboot.*")
@EnableConfigurationProperties(RebootProperties.class)
public class AutoConfiguration {

}
