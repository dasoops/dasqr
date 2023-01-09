package com.dasoops.dasserver.plugin.loaj.task;

import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajKeyEnum;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: InitTask
 * @ClassPath com.dasoops.dasserver.plugin.loaj.task.InitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 初始化任务
 */
@Slf4j
@Component
public class InitTask {

    private final StringRedisTemplate stringRedisTemplate;
    private final ReplyService replyService;

    public InitTask(StringRedisTemplate stringRedisTemplate, ReplyService replyService) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.replyService = replyService;
    }

    /**
     * 初始化/更新 关键词回复 映射集合
     */
    @PostConstruct
    public void initOrUpdateRelayMap() {
        log.info("初始化/更新 关键词 单对单 回复 映射集合 缓存");
        List<ReplyDo> list = replyService.list();
        if (list.size() <= 0) {
            return;
        }
        //获取 关键词回复 映射集合
        Map<String, String> map = list.stream().collect(Collectors.toMap(ReplyDo::getKeyword, ReplyDo::getReply));
        stringRedisTemplate.opsForHash().putAll(LoajKeyEnum.REPLY.getKey(), map);
    }


}
