package com.dasoops.dasserver.plugin.wswrapper;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.websocket.WsWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: WsWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.wswrapper.WsWrapperImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: ws增强实现
 */
@Component
@Slf4j
public class WsWrapperImpl implements WsWrapper {

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        //todo
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    @Override
    public Integer getOrder() {
        return 10;
    }
}
