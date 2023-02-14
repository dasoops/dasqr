package com.dasoops.dasserver.plugin.image.task;

import com.dasoops.common.task.BaseTask;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @title: ImageInitTask
 * @classPath com.dasoops.dasserver.plugin.image.task.ImageInitTask
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/01
 * @version 1.0.0
 * @description 图片初始化任务
 * @see BaseTask
 */
@Component
@Slf4j
public class ImageInitTask extends BaseTask {

    private final ImageService imageService;

    public ImageInitTask(ImageService imageService) {
        this.imageService = imageService;
        initOrUpdateAll();
    }

    @PostConstruct
    public void initOrUpdateAll() {
        initOrUpdateImageKeywordList();
    }

    public void initOrUpdateImageKeywordList() {
        imageService.initOrUpdateImageKeywordList();
    }

}
