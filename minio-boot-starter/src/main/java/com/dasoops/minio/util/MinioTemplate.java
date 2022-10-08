package com.dasoops.minio.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;
import com.dasoops.minio.entity.MinioProperties;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.Optional;

/**
 * @Title: MinioUtil
 * @ClassPath com.dasoops.minio.util.MinioUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: minio对外暴露工具类
 */
@Slf4j
@Service
public class MinioTemplate {

    @Resource
    private MinioClient minioClient;
    @Resource
    private MinioProperties properties;

    public Optional<String> saveImage(File file) {
        String uuid = UUID.fastUUID().toString();
        String type = FileUtil.getType(file);

        try (InputStream inputStream = FileUtil.getInputStream(file)) {
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .contentType(type)
                    .bucket(properties.getBucket())
                    .object(uuid + "." + type)
                    .stream(inputStream, inputStream.available(), -1)
                    .build();
            minioClient.putObject(putObjectArgs);
            return Optional.of(uuid);
        } catch (Exception e) {
            log.error("saveImageError:{}",e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<String> saveImage(String url) {
        File file = HttpUtil.downloadFileFromUrl(url, properties.getTempDownloadPath());
        return saveImage(file);
    }

    public byte[] getImage(String path) {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(properties.getBucket())
                .object(path)
                .build();
        byte[] bytes = new byte[0];
        try {
            GetObjectResponse resp = minioClient.getObject(getObjectArgs);
            bytes = resp.readAllBytes();
        } catch (Exception e) {
            log.error("downloadImageError,{}", e.getMessage());
        }
        return bytes;
    }

    public String getServerPath(){
        return properties.getUrl();
    }


}
