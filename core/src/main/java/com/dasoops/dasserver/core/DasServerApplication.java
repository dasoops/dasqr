package com.dasoops.dasserver.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @title Application
 * @classPath com.dasoops.core.Application
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 应用程序
 */
@SpringBootApplication
public class DasServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DasServerApplication.class,args);
    }

}
