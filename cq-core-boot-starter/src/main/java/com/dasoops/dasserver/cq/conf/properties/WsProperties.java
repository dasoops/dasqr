package com.dasoops.dasserver.cq.conf.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: CqProperties
 * @ClassPath com.dasoops.dasserver.cq.boot.CqProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq参数
 */
@ConfigurationProperties(prefix = "dasq.cq.core.ws")
@Getter
@Setter
public class WsProperties {

    /**
     * url
     */
    private String url = "/ws/DasServer/";

    /**
     * 文本消息缓冲区大小
     */
    private Integer maxTextMessageBufferSize = 512000;

    /**
     * 二进制消息缓冲区大小
     */
    private Integer maxBinaryMessageBufferSize = 512000;

    /**
     * 连接最长闲置时间(默认15min)
     */
    private Long maxSessionIdleTimeout = 15 * 60000L;

    /**
     * api超时时间(默认2min)
     */
    private Long apiTimeout = 120000L;

}