package com.dasoops.dasserver.plugin.pluginloader.anno;

import com.dasoops.dasserver.plugin.pluginloader.config.DynamicConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启动态扩展的注解
 * @author rongdi
 * @date 2021-03-06
 * @blog https://www.cnblogs.com/rongdi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({DynamicConfig.class})
public @interface EnableDynamic {
}
