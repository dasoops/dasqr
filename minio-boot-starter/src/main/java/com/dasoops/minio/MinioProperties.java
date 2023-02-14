package com.dasoops.minio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @title: MinioProperties
 * @classPath com.dasoops.minio.MinioProperties
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/08
 * @version 1.0.0
 * @description minio配置项
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String bucket;
    private String url;
    private Integer port;
    private String accessKey;
    private String secretKey;
    private String tempDownloadPath;


}
