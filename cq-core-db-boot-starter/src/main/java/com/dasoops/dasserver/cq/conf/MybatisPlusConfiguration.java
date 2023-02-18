package com.dasoops.dasserver.cq.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title MybatisPlusConfiguration
 * @classPath com.dasoops.dasq.conf.MybatisPlusConfiguration
 * @date 2022/10/07
 * @description mybatis plus 自动填充,分页插件配置
 * @see MetaObjectHandler
 */
@Configuration
public class MybatisPlusConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
