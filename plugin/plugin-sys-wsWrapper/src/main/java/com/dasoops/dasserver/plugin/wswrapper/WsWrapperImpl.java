package com.dasoops.dasserver.plugin.wswrapper;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.entity.retdata.*;
import com.dasoops.dasserver.cq.websocket.WsWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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
    @Async
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {

        ApiListData<GroupData> groupList = cqTemplate.getGroupList();
        ApiListData<FriendData> friendList = cqTemplate.getFriendList();
        ApiData<LoginInfoData> loginInfo = cqTemplate.getLoginInfo();
        System.out.println( groupList.getData().stream().map(GroupData::getGroupId).collect(Collectors.toList()));
        System.out.println(friendList.getData().toString());
        System.out.println(loginInfo.getData().toString());
    }

    @Override
    public void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

}
