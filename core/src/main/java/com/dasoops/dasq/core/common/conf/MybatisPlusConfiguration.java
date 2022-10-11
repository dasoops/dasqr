package com.dasoops.dasq.core.common.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.dasoops.dasq.core.common.util.EventUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @Title: MybatisPlusConfiguration
 * @ClassPath com.dasoops.dasq.conf.MybatisPlusConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: mybatis plus 自动填充,分页插件配置
 * @see MetaObjectHandler
 */
@Configuration
@Slf4j
public class MybatisPlusConfiguration {


    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }
}
