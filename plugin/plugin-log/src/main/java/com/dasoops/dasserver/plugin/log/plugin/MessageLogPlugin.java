package com.dasoops.dasserver.plugin.log.plugin;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.conf.AsyncMongoTemplate;
import com.dasoops.dasserver.cq.entity.dto.cq.event.CqEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqDiscussMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqLifecycleMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.notice.*;
import com.dasoops.dasserver.cq.entity.dto.cq.event.request.CqFriendRequestEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.request.CqGroupRequestEvent;
import com.dasoops.dasserver.plugin.log.entity.dbo.MessageDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: MessageLogPlugin
 * @ClassPath com.dasoops.dasserver.plugin.log.plugin.MessageLogPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 消息日志插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class MessageLogPlugin extends CqPlugin {



    private final AsyncMongoTemplate asyncMongoTemplate;

    public MessageLogPlugin(AsyncMongoTemplate asyncMongoTemplate) {
        this.asyncMongoTemplate = asyncMongoTemplate;
    }

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onDiscussMessage(CqTemplate cqTemplate, CqDiscussMessageEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupUploadNotice(CqTemplate cqTemplate, CqGroupUploadNoticeEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupAdminNotice(CqTemplate cqTemplate, CqGroupAdminNoticeEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupDecreaseNotice(CqTemplate cqTemplate, CqGroupDecreaseNoticeEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupIncreaseNotice(CqTemplate cqTemplate, CqGroupIncreaseNoticeEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupBanNotice(CqTemplate cqTemplate, CqGroupBanNoticeEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onFriendAddNotice(CqTemplate cqTemplate, CqFriendAddNoticeEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onFriendRequest(CqTemplate cqTemplate, CqFriendRequestEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupRequest(CqTemplate cqTemplate, CqGroupRequestEvent event) {
        onMessage(event);
        return PassObj.pass(event);
    }

    @Override
    public PassObj onHeartBeatMeta(CqTemplate cqTemplate, CqHeartBeatMetaEvent event) {
        return super.onHeartBeatMeta(cqTemplate, event);
    }

    @Override
    public PassObj onLifecycleMeta(CqTemplate cqTemplate, CqLifecycleMetaEvent event) {
        return super.onLifecycleMeta(cqTemplate, event);
    }

    private void onMessage(CqEvent event) {
        save(event);
        log.info("(MessageLogPlugin) 接收到消息{}", JSON.toJSONString(event));
    }

    private void save(CqEvent event) {
        MessageDo messageDo = new MessageDo();
        BeanUtil.copyProperties(event, messageDo);
        messageDo.setTime(event.getTime());
        asyncMongoTemplate.save(messageDo);
    }
}
