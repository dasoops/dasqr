package com.dasoops.minio;

import lombok.Setter;

/**
 * @Title: MinioUtil
 * @ClassPath com.dasoops.minio.MinioUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: minio工具
 */
public class MinioUtil {

    @Setter
    public static MinioProperties minioProperties;

    /**
     * 构建图片连接
     *
     * @param imageName 文件名
     * @return {@link String}
     */
    public static String buildImagePath(String imageName) {
        return "http://" + getServerPath() + ":" + minioProperties.getPort() + "/" + minioProperties.getBucket() + "/" + imageName;
    }

    /**
     * 获取服务器路径
     *
     * @return {@link String}
     */
    public static String getServerPath() {
        return minioProperties.getUrl();
    }

}
