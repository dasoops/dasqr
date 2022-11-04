package com.dasoops.dasserver.cq.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Title: AutoConfiguration
 * @ClassPath com.dasoops.dasserver.cq.conf.AutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: 自动配置
 */
@ComponentScan("com.dasoops.dasserver.cq")
@EnableAsync
public class AutoConfiguration {
}
