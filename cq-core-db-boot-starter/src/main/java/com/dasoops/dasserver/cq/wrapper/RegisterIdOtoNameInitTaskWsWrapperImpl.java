package com.dasoops.dasserver.cq.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.task.RegisterInitTask;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @title RegisterNameInitWsWrapper
 * @classPath com.dasoops.dasserver.plugin.webmanager.task.RegisterNameInitWsWrapper
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 注册表用户名称初始化
 * @see WsWrapper
 */
@Component
@RequiredArgsConstructor
public class RegisterIdOtoNameInitTaskWsWrapperImpl implements WsWrapper {

    private final RegisterInitTask registerInitTask;

    @Getter
    private Boolean initIsCompleted = false;


    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        registerInitTask.initOrUpdateAll(cqTemplate);
        initIsCompleted = true;
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    @Override
    public Integer getOrder() {
        return 20;
    }
}
