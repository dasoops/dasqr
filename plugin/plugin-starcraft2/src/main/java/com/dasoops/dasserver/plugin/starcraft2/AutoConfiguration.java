package com.dasoops.dasserver.plugin.starcraft2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: AutoConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.AutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 自动配置
 */

@MapperScan("com.dasoops.dasserver.plugin.starcraft2.mapper")
@ComponentScan("com.dasoops.dasserver.plugin.starcraft2")
@Configuration
public class AutoConfiguration {

}
