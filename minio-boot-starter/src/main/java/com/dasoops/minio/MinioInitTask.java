package com.dasoops.minio;

import com.dasoops.common.task.BaseInitTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Title: MinioInitTask
 * @ClassPath com.dasoops.minio.MinioInitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: minio初始化任务
 * @see BaseInitTask
 */
@Component
@RequiredArgsConstructor
public class MinioInitTask extends BaseInitTask {

    private final MinioProperties minioProperties;

    @PostConstruct
    public void Injection() {
        MinioUtil.setMinioProperties(minioProperties);
    }
}
