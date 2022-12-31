package com.dasoops.dasserver.plugin.webManager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: Configuration
 * @ClassPath com.dasoops.dasserver.webManager.Configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.webManager")
@MapperScan("com.dasoops.dasserver.plugin.webManager.mapper")
public class AutoConfiguration {

}
