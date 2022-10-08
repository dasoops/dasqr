package com.dasoops.minio.configucation;

import com.dasoops.minio.entity.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: MinioConfiguration
 * @ClassPath com.dasoops.minio.configucation.MinioConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: minio配置类
 */
@Configuration
@Slf4j
@EnableConfigurationProperties({MinioConfiguration.class})
@ConfigurationProperties(prefix = "empty")
@ConditionalOnProperty(prefix = "minio", value = "enable", havingValue = "true")
public class MinioConfiguration {

    private MinioClient minioClient;

    @Bean
    public MinioClient minioClient(MinioProperties properties) {
        if (minioClient == null) {
            minioClient = MinioClient.builder()
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
        }
        return minioClient;

    }

    @Bean
    @ConfigurationProperties(prefix = "minio")
    public MinioProperties minioProperties() {
        return new MinioProperties();
    }


}
