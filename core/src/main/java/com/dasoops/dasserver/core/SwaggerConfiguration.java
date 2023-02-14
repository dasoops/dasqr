package com.dasoops.dasserver.core;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @title: SwaggerConfiguration
 * @classPath com.dasoops.dasserver.core.SwaggerConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/30
 * @version 1.0.0
 * @description Swagger 配置
 */
@Configuration
@EnableKnife4j
@EnableSwagger2WebMvc
public class SwaggerConfiguration {
    @Bean
    public Docket ignoreErrorController() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("(?!/error.*).*"))
                .build();
    }
}
