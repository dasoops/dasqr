package com.dasoops.cq;

import com.dasoops.cq.conf.CqConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: EnableCq
 * @ClassPath com.dasoops.cq.EnableCq
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: 开启cq模块功能
 * @see Enum
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(CqConfiguration.class)
public @interface EnableCq {
}
