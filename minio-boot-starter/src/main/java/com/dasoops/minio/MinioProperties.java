package com.dasoops.minio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: MinioProperties
 * @ClassPath com.dasoops.minio.MinioProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: minio配置项
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
