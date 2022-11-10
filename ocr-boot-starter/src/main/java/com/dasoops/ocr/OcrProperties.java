package com.dasoops.ocr;

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
@ConfigurationProperties(prefix = "ocr.tencent")
public class OcrProperties {

    /**
     * id
     */
    private String secretId;

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 终点
     */
    private String endPoint = "ocr.tencentcloudapi.com";

    /**
     * 地域
     */
    private String region = "ap-beijing";


}
