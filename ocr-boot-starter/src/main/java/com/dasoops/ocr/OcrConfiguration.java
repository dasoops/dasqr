package com.dasoops.ocr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: OcrConfiguration
 * @ClassPath com.dasoops.ocr.OcrConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/08
 * @Version 1.0.0
 * @Description: ocr配置
 */
@Configuration
@Slf4j
@EnableConfigurationProperties({OcrProperties.class})
@ComponentScan("com.dasoops.ocr")
public class OcrConfiguration {

    @Bean
    public OcrProperties ocrProperties() {
        return new OcrProperties();
    }

    @Bean
    public OcrTemplate ocrTemplate(OcrProperties ocrProperties) {
        return new OcrTemplate(ocrProperties);
    }

}
