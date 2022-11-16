package com.dasoops.dasserver.plugin.loaj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Title: AutoConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.loaj.AutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.loaj")
@MapperScan("com.dasoops.dasserver.plugin.loaj.mapper")
@EnableTransactionManagement
public class AutoConfiguration {


}
