package com.dasoops.dasserver.cq.conf.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @title: EventProperties
 * @classPath com.dasoops.dasserver.cq.conf.properties.EventProperties
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 事件参数
 */
@ConfigurationProperties(prefix = "dasq.cq.core.event")
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
