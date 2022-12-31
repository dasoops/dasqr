package com.dasoops.dasserver.plugin.webAuth;

import com.dasoops.dasserver.plugin.webAuth.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qml
 * @version 1.0.0
 * @ClassName MyMvcConfig.java
 * @Description MyMvcConfig
 * @createTime 2020年02月21日 20:54:00
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final String[] staticPath = {
                "/**/*.html",
                "/**/*.ico",
                "/**/*.js",
                "/**/*.css"
        };
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error", "/register/login", "/git/push", "/alas/error", "/swagger-resources")
                .excludePathPatterns(staticPath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
