package com.dasoops.dasserver;

import com.dasoops.common.entity.param.base.BasePageParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: Configuration
 * @ClassPath com.dasoops.dasserver.Configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 配置
 */
@org.springframework.context.annotation.Configuration
@ComponentScan({"com.dasoops.dasserver.controller", "com.dasoops.dasserver.service"})
public class Configuration {

}
