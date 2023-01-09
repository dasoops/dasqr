package com.dasoops.minio;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;
import io.minio.*;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;

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
public class MinioTemplate {

    private final MinioClient minioClient;
    private final MinioProperties properties;

    public MinioTemplate(MinioClient minioClient, MinioProperties properties) {
        this.minioClient = minioClient;
        this.properties = properties;
    }

    /**
     * 保存图像
     *
     * @param file 文件
     * @return {@link Optional}<{@link String}> 文件名
     * @throws IOException               IO异常
     * @throws ServerException           服务器异常
     * @throws InsufficientDataException 足够数据异常
     * @throws ErrorResponseException    错误反应异常
     * @throws NoSuchAlgorithmException  没有这样算法异常
     * @throws InvalidKeyException       无效关键例外
     * @throws InvalidResponseException  无效反应异常
     * @throws XmlParserException        xml解析器异常
     * @throws InternalException         内部异常
     */
    public String saveImage(File file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String uuid = UUID.fastUUID().toString();
        String type = FileUtil.getType(file);
        InputStream inputStream = FileUtil.getInputStream(file);
        String filename = uuid + "." + type;
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .contentType(type)
                .bucket(properties.getBucket())
                .contentType("image/" + type)
                .object(filename)
                .stream(inputStream, inputStream.available(), -1)
                .build();
        minioClient.putObject(putObjectArgs);
        log.info("minio putObject({})", filename);
        return filename;
    }

    public String saveImage(InputStream inputStream, String contentType) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String uuid = UUID.fastUUID().toString();
        String type = contentType.substring(contentType.lastIndexOf("/") + 1);
        String filename = uuid + "." + type;
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .contentType(contentType)
                .bucket(properties.getBucket())
                .object(filename)
                .stream(inputStream, inputStream.available(), -1)
                .build();
        minioClient.putObject(putObjectArgs);
        log.info("minio putObject({})", filename);
        return filename;
    }

    /**
     * 保存图像
     *
     * @param url url
     * @return {@link Optional}<{@link String}> 文件名
     * @throws ServerException           服务器异常
     * @throws InsufficientDataException 足够数据异常
     * @throws ErrorResponseException    错误反应异常
     * @throws IOException               IO异常
     * @throws NoSuchAlgorithmException  没有这样算法异常
     * @throws InvalidKeyException       无效关键例外
     * @throws InvalidResponseException  无效反应异常
     * @throws XmlParserException        xml解析器异常
     * @throws InternalException         内部异常
     */
    public String saveImage(String url) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        File file = HttpUtil.downloadFileFromUrl(url, properties.getTempDownloadPath());
        return saveImage(file);
    }

    /**
     * 获取图像字节数组
     *
     * @param path 路径
     * @return {@link byte[]}
     */
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
     * 检查文件是否存在
     *
     * @param fileName 文件名称
     * @return boolean
     */
    public boolean checkFileIsExists(String fileName) {
        try {
            StatObjectArgs statObjectArgs = StatObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(fileName)
                    .build();
            minioClient.statObject(statObjectArgs);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
