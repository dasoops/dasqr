package com.dasoops.dasq.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: DasServerApplication
 * @ClassPath com.dasoops.dasserver.DasServerApplication
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/09/30
 * @Version 1.0.0
 * @Description: dasServer
 */

@SpringBootApplication
@MapperScan(value="com.dasoops.dasq.*.mapper")
@ComponentScan(value = "com.dasoops.*")
public class DasServerApplication {

    // todo cq消息接受 按关键词分发处理
    // todo 自定白名单消息过滤

    public static void main(String[] args) {
        SpringApplication.run(DasServerApplication.class, args);
    }

}
