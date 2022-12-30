package com.dasoops.dasserver.plugin.authwrapper.task;

import com.alibaba.fastjson2.JSON;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.entity.retdata.ApiListData;
import com.dasoops.dasserver.cq.entity.retdata.FriendData;
import com.dasoops.dasserver.cq.websocket.WsWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Title: AuthInitTaskWsWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.task.AuthInitTaskWsWrapperImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 身份验证初始化任务 WsWrapperImpl
 */
@Component
@Slf4j
public class AuthInitTaskWsWrapperImpl implements WsWrapper {

    private final InitTask initTask;

    public AuthInitTaskWsWrapperImpl(InitTask initTask) {
        this.initTask = initTask;
    }

    @Override
    @Async
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        log.debug("AuthInitTaskWsWrapperImpl.afterConnectionEstablishedWrapper()");

        ApiListData<FriendData> friendList = cqTemplate.getFriendList();
        log.debug("friendList: {}", JSON.toJSONString(friendList));


        initTask.initOrUpdate();
    }

    @Override
    @Async
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    @Override
    public Integer getOrder() {
        return 5;
    }


}
