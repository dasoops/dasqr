package com.dasoops.dasq.core.common.event;

import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title: DestroyEvent
 * @ClassPath com.dasoops.dasq.core.common.event.DestroyEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 破坏事件
 * @see DisposableBean
 */
@Component
public class DestroyEvent implements DisposableBean {

    @Resource
    private CqService cqService;
    @Resource
    private DasqProperties dasqProperties;


    @Override
    public void destroy() throws Exception {
        cqService.sendMsg(true, Long.parseLong(dasqProperties.getDevGroupId()), "DasServer destroy");
    }
}