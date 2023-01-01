package com.dasoops.dasserver.plugin.image.task;

import com.dasoops.common.task.BaseInitTask;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import org.springframework.stereotype.Component;

/**
 * @Title: ImageInitTask
 * @ClassPath com.dasoops.dasserver.plugin.image.task.ImageInitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: 图片初始化任务
 * @see BaseInitTask
 */
@Component
public class ImageInitTask extends BaseInitTask {

    private final ImageService imageService;

    public ImageInitTask(ImageService imageService) {
        this.imageService = imageService;
    }

    public void initOrUpdateAll() {

    }

    public void initOrUpdateImageKeywordList() {
        imageService.initOrUpdateImageKeywordList();
    }

}
