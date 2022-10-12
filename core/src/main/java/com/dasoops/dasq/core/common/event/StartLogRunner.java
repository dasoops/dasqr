package com.dasoops.dasq.core.common.event;

import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.util.BannerUtil;
import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title: groupSendRunner
 * @ClassPath com.dasoops.dasq.core.common.runner.groupSendRunner
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 项目启动消息通知
 * @see ApplicationRunner
 */
@Component
@Order(value = 1)
public class StartLogRunner implements ApplicationRunner {

    @Resource
    private CqService cqService;
    @Resource
    private DasqProperties dasqProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        cqService.sendMsg(true, Long.parseLong(dasqProperties.getDevGroupId()), "DasServer Start,Ver." + dasqProperties.getVersion() + (dasqProperties.getIsDemo() ? "D" : "R"));
    }
}