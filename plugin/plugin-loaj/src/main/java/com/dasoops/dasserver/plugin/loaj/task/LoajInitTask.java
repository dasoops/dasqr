package com.dasoops.dasserver.plugin.loaj.task;

import com.dasoops.common.task.BaseTask;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @title InitTask
 * @classPath com.dasoops.dasserver.plugin.loaj.task.InitTask
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/11
 * @version 1.0.0
 * @description 初始化任务
 */
@Slf4j
@Component
public class LoajInitTask extends BaseTask {

    private final ReplyService replyService;

    public LoajInitTask(ReplyService replyService) {
        this.replyService = replyService;
    }

    /**
     * 初始化/更新 关键词回复 映射集合
     */
    @PostConstruct
    public void initOrUpdateRelayMap2Cache() {
        replyService.initOrUpdateRelayMap2Cache();
    }


}
