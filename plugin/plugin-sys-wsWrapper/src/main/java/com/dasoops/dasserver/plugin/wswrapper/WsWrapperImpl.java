package com.dasoops.dasserver.plugin.wswrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @title WsWrapperImpl
 * @classPath com.dasoops.dasserver.plugin.wswrapper.WsWrapperImpl
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/15
 * @version 1.0.0
 * @description ws增强实现
 */
@Component
@Slf4j
public class WsWrapperImpl implements WsWrapper {

    @Getter
    private Boolean initIsCompleted = false;

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        //todo

        initIsCompleted = true;
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    @Override
    public Integer getOrder() {
        return 10;
    }
}
