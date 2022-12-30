package com.dasoops.dasserver;

import com.dasoops.dasserver.interceptor.AuthInterceptor;
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

    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthInterceptor())
//                .addPathPatterns("/*")
//                .excludePathPatterns("/error","/user/login","/git/push","/alas/error");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
