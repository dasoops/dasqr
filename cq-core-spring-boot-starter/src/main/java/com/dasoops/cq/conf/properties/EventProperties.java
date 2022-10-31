package com.dasoops.cq.conf.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: EventProperties
 * @ClassPath com.dasoops.cq.conf.properties.EventProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 事件参数
 */
@ConfigurationProperties(prefix = "dasq.cq.event")
@Getter
@Setter
public class EventProperties {
    /**
     * 线程池核心线程数量
     */
    private Integer corePoolSize = 5;
    /**
     * 线程池线程数最大值
     */
    private Integer maxPoolSize = 20;
    /**
     * 线程保持时间
     */
    private Integer keepAliveTime = 2000;
    /**
     * 工作队列大小
     */
    private Integer workQueueSize = 512;
}
