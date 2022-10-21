package com.dasoops.cq.boot;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: CqProperties
 * @ClassPath com.dasoops.cq.boot.CqProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq参数
 */
@ConfigurationProperties(prefix = "dasq.cq")
@Getter
@Setter
public class CqProperties {

    /**
     * url
     */
    private String url = "/ws/*/";

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
