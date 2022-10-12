package com.dasoops.dasq.core;

import com.dasoops.dasq.core.common.util.BannerUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
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
@MapperScan(value = "com.dasoops.dasq.core.*.mapper")
@ComponentScan(value = "com.dasoops.*")
@ServletComponentScan
public class DasServerApplication {


    public static void main(String[] args) {
        BannerUtil.printBanner();
        SpringApplication.run(DasServerApplication.class, args);
    }

}
