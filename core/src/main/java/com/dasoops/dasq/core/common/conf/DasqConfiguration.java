package com.dasoops.dasq.core.common.conf;


import com.dasoops.dasq.core.common.entity.DasqProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: DasqConfiguration
 * @ClassPath com.dasoops.dasq.core.common.conf.DasqConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: dasq配置
 */

@Configuration
@Slf4j
public class DasqConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "dasq")
    public DasqProperties dasqProperties() {
        return new DasqProperties();
    }

}
