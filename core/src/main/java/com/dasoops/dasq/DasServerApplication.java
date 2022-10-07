package com.dasoops.dasq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class DasServerApplication {


    // todo minio 可装载式文件存储服务
    // todo cq消息接受 按关键词分发处理
    // todo 自定白名单消息过滤

    public static void main(String[] args) {
        SpringApplication.run(DasServerApplication.class, args);
    }

}
