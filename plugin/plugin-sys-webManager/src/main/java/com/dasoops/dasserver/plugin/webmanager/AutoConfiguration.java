package com.dasoops.dasserver.plugin.webmanager;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Title: Configuration
 * @ClassPath com.dasoops.dasserver.webManager.Configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.webmanager")
@MapperScan("com.dasoops.dasserver.plugin.webmanager.mapper")
public class AutoConfiguration {

}
