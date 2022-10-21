package com.dasoops.core;

import com.dasoops.cq.EnableCq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title: Application
 * @ClassPath com.dasoops.core.Application
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 应用程序
 */
@SpringBootApplication
@EnableCq
public class DasServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DasServerApplication.class,args);
    }
}
