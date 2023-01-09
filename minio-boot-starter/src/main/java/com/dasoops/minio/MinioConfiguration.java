package com.dasoops.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @Title: MinioConfiguration
 * @ClassPath com.dasoops.minio.configucation.MinioConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: minio配置类
 */
@Slf4j
@EnableConfigurationProperties({MinioProperties.class})
@ConditionalOnProperty(prefix = "minio", value = "enable", havingValue = "true")
public class MinioConfiguration {

    @Bean
    public MinioClient minioClient(MinioProperties properties) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(properties.getUrl(), properties.getPort(), false)
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucket()).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucket()).build());
            }
        } catch (Exception e) {
            log.error("minioClientBucketError:{}", e.getMessage());
        }
        return minioClient;
    }

    @Bean
    public MinioTemplate minioTemplate(MinioClient minioClient, MinioProperties minioProperties) {
        return new MinioTemplate(minioClient, minioProperties);
    }

    @PostConstruct
    public void Injection(MinioProperties minioProperties) {
        MinioUtil.setMinioProperties(minioProperties);
    }

}
