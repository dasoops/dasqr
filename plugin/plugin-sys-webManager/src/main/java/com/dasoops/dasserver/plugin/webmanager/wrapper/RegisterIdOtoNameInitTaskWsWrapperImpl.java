package com.dasoops.dasserver.plugin.webmanager.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import com.dasoops.dasserver.plugin.webmanager.task.WebManagerInitTask;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @Title: RegisterNameInitWsWrapper
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.task.RegisterNameInitWsWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册表用户名称初始化
 * @see WsWrapper
 */
@Component
public class RegisterIdOtoNameInitTaskWsWrapperImpl implements WsWrapper {

    private final WebManagerInitTask webManagerInitTask;

    @Getter
    private Boolean initIsCompleted = false;

    public RegisterIdOtoNameInitTaskWsWrapperImpl(WebManagerInitTask webManagerInitTask) {
        this.webManagerInitTask = webManagerInitTask;
    }

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        webManagerInitTask.initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate);
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
