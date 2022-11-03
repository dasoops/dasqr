package com.dasoops.dasserver.plugin.gitnotice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Title: configuration
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/02
 * @Version 1.0.0
 * @Description: 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.gitnotice.*")
@MapperScan("com.dasoops.dasserver.plugin.gitnotice.mapper")
@EnableConfigurationProperties(GitNoticeProperties.class)
@EnableTransactionManagement
public class AutoConfiguration {

}
