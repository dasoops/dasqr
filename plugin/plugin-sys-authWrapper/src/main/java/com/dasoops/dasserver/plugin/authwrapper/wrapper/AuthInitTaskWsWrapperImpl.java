package com.dasoops.dasserver.plugin.authwrapper.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import com.dasoops.dasserver.plugin.authwrapper.task.AuthTask;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @title AuthInitTaskWsWrapperImpl
 * @classPath com.dasoops.dasserver.plugin.authwrapper.wrapper.AuthInitTaskWsWrapperImpl
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/28
 * @version 1.0.0
 * @description 身份验证初始化任务 WsWrapperImpl
 */
@Component
@Slf4j
public class AuthInitTaskWsWrapperImpl implements WsWrapper {

    private final AuthTask authTask;

    @Getter
    private Boolean initIsCompleted = false;

    public AuthInitTaskWsWrapperImpl(AuthTask authTask) {
        this.authTask = authTask;
    }

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        authTask.initOrUpdateAll(cqTemplate);
        initIsCompleted = true;
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {
    }

    @Override
    public Integer getOrder() {
        return 5;
    }


}
