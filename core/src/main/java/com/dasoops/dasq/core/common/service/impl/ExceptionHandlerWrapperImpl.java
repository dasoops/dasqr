package com.dasoops.dasq.core.common.service.impl;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.exception.handler.ExceptionHandlerWrapper;
import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title: ExceptionHandlerReinforcedImpl
 * @ClassPath com.dasoops.dasq.core.conf.ExceptionHandlerReinforcedImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 异常处理程序增强实现
 * @see ExceptionHandlerWrapper
 */
@Component
public class ExceptionHandlerWrapperImpl implements ExceptionHandlerWrapper {

    @Resource
    private CqService cqService;
    @Resource
    private DasqProperties dasqProperties;

    @Override
    public void after(Long id) {
        if (EventUtil.isEmpty()) {
            cqService.sendMsg(true, Long.valueOf(dasqProperties.getDevGroupId()), StrUtil.format("服务端发生异常,请求人类接管(本条消息为管理群通知),errorId:{}", id));
        }
        cqService.sendMsg(StrUtil.format("服务端发生异常,请求人类接管,errorId:{}", id));
    }
}
