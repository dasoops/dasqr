package com.dasoops.dasq.core.common.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: RestTemplateConfiguration
 * @ClassPath com.dasoops.dasq.core.common.conf.RestTemplateConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 其他模板配置
 */
@Configuration
@Slf4j
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
