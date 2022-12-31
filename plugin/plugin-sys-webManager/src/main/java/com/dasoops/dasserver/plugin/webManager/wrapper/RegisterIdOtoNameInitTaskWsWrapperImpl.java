package com.dasoops.dasserver.plugin.webManager.wrapper;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.websocket.WsWrapper;
import com.dasoops.dasserver.plugin.webManager.task.WebManagerInitTask;
import org.springframework.stereotype.Component;

/**
 * @Title: RegisterNameInitWsWrapper
 * @ClassPath com.dasoops.dasserver.plugin.webManager.task.RegisterNameInitWsWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册表用户名称初始化
 * @see WsWrapper
 */
@Component
public class RegisterIdOtoNameInitTaskWsWrapperImpl implements WsWrapper {

    private final WebManagerInitTask webManagerInitTask;

    public RegisterIdOtoNameInitTaskWsWrapperImpl(WebManagerInitTask webManagerInitTask) {
        this.webManagerInitTask = webManagerInitTask;
    }

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        webManagerInitTask.initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate);
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    @Override
    public Integer getOrder() {
        return 20;
    }
}
