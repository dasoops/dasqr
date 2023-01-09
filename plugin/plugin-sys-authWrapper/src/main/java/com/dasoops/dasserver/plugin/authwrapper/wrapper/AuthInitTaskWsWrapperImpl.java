package com.dasoops.dasserver.plugin.authwrapper.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import com.dasoops.dasserver.plugin.authwrapper.task.AuthInitTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: AuthInitTaskWsWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.wrapper.AuthInitTaskWsWrapperImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 身份验证初始化任务 WsWrapperImpl
 */
@Component
@Slf4j
public class AuthInitTaskWsWrapperImpl implements WsWrapper {

    private final AuthInitTask authInitTask;

    public AuthInitTaskWsWrapperImpl(AuthInitTask authInitTask) {
        this.authInitTask = authInitTask;
    }

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        authInitTask.initOrUpdateAll(cqTemplate);
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    @Override
    public Integer getOrder() {
        return 5;
    }


}
