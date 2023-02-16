package com.dasoops.dasserver.plugin.starcraft2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @title AutoConfiguration
 * @classPath com.dasoops.dasserver.plugin.starcraft2.AutoConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 自动配置
 */

@MapperScan("com.dasoops.dasserver.plugin.starcraft2.mapper")
@ComponentScan("com.dasoops.dasserver.plugin.starcraft2")
@Configuration
public class AutoConfiguration {

}
