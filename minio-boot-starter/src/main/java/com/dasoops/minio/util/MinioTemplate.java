package com.dasoops.minio.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;
import com.dasoops.minio.entity.MinioProperties;
import io.minio.*;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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

    public Optional<String> saveImage(File file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String uuid = UUID.fastUUID().toString();
        String type = FileUtil.getType(file);
        InputStream inputStream = FileUtil.getInputStream(file);
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .contentType(type)
                .bucket(properties.getBucket())
                .contentType("image/" + FileUtil.getType(file))
                .object(uuid + "." + type)
                .stream(inputStream, inputStream.available(), -1)
                .build();
        minioClient.putObject(putObjectArgs);
        return Optional.of(uuid + "." + type);
    }

    public Optional<String> saveImage(String url) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
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

    /**
     * 构建图片连接
     *
     * @param imageName 文件名
     * @return {@link String}
     */
    public String buildImagePath(String imageName) {
        return "http://" + properties.getUrl() + ":" + properties.getPort() + "/" + properties.getBucket() + "/" + imageName;
    }

    public String getServerPath() {
        return properties.getUrl();
    }

}
