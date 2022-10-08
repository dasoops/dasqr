package com.dasoops.minio.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: MinioProperties
 * @ClassPath com.dasoops.minio.entity.MinioProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: minio配置项
 */
@Data
public class MinioProperties {

    private String bucket;
    private String url;
    private Integer port;
    private String accessKey;
    private String secretKey;
    private String tempDownloadPath;


}
