package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqDiscussMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqHeartBeatMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.meta.CqLifecycleMetaEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.notice.*;
import com.dasoops.dasserver.cq.entity.dto.cq.event.request.CqFriendRequestEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.request.CqGroupRequestEvent;
import lombok.Getter;
import lombok.Setter;

/**
 * @title: DbCqPlugin
 * @classPath com.dasoops.dasserver.cq.DbCqPlugin
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/26
 * @version 1.0.0
 * @description Db增强cq插件
 * @see DefaultCqTemplate
 */
public class DbRecordCqPlugin extends CqPlugin implements IPluginRecordSaver {

    @Getter
    @Setter
    private PluginDo pluginDo;

    private final CqPlugin cqPlugin;

    public DbRecordCqPlugin(CqPlugin cqPlugin) {
        this.cqPlugin = cqPlugin;
    }

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return cqPlugin.onPrivateMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return cqPlugin.onGroupMessage(cqTemplate, event);
    }

    @Override
    public PassObj onDiscussMessage(CqTemplate cqTemplate, CqDiscussMessageEvent event) {
        return cqPlugin.onDiscussMessage(cqTemplate, event);
    }

    @Override
    public PassObj onBotSentPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return cqPlugin.onBotSentPrivateMessage(cqTemplate, event);
    }

    @Override
    public PassObj onBotSentGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return cqPlugin.onBotSentGroupMessage(cqTemplate, event);
    }

    @Override
    public PassObj onBotSentDiscussMessage(CqTemplate cqTemplate, CqDiscussMessageEvent event) {
        return cqPlugin.onBotSentDiscussMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupUploadNotice(CqTemplate cqTemplate, CqGroupUploadNoticeEvent event) {
        return cqPlugin.onGroupUploadNotice(cqTemplate, event);
    }

    @Override
    public PassObj onGroupAdminNotice(CqTemplate cqTemplate, CqGroupAdminNoticeEvent event) {
        return cqPlugin.onGroupAdminNotice(cqTemplate, event);
    }

    @Override
    public PassObj onGroupDecreaseNotice(CqTemplate cqTemplate, CqGroupDecreaseNoticeEvent event) {
        return cqPlugin.onGroupDecreaseNotice(cqTemplate, event);
    }

    @Override
    public PassObj onGroupIncreaseNotice(CqTemplate cqTemplate, CqGroupIncreaseNoticeEvent event) {
        return cqPlugin.onGroupIncreaseNotice(cqTemplate, event);
    }

    @Override
    public PassObj onGroupBanNotice(CqTemplate cqTemplate, CqGroupBanNoticeEvent event) {
        return cqPlugin.onGroupBanNotice(cqTemplate, event);
    }

    @Override
    public PassObj onFriendAddNotice(CqTemplate cqTemplate, CqFriendAddNoticeEvent event) {
        return cqPlugin.onFriendAddNotice(cqTemplate, event);
    }

    @Override
    public PassObj onFriendRequest(CqTemplate cqTemplate, CqFriendRequestEvent event) {
        return cqPlugin.onFriendRequest(cqTemplate, event);
    }

    @Override
    public PassObj onGroupRequest(CqTemplate cqTemplate, CqGroupRequestEvent event) {
        return cqPlugin.onGroupRequest(cqTemplate, event);
    }

    @Override
    public PassObj onHeartBeatMeta(CqTemplate cqTemplate, CqHeartBeatMetaEvent event) {
        return cqPlugin.onHeartBeatMeta(cqTemplate, event);
    }

    @Override
    public PassObj onLifecycleMeta(CqTemplate cqTemplate, CqLifecycleMetaEvent event) {
        return cqPlugin.onLifecycleMeta(cqTemplate, event);
    }

    @Override
    public PassObj onGroupRecallNotice(CqTemplate cqTemplate, CqGroupRecallNoticeEvent event) {
        return cqPlugin.onGroupRecallNotice(cqTemplate, event);
    }

    @Override
    public PassObj onFriendRecallNotice(CqTemplate cqTemplate, CqFriendRecallNoticeEvent event) {
        return cqPlugin.onFriendRecallNotice(cqTemplate, event);
    }

    @Override
    public PassObj onGroupCardNotice(CqTemplate cqTemplate, CqGroupCardNoticeEvent event) {
        return cqPlugin.onGroupCardNotice(cqTemplate, event);
    }

    @Override
    public CqPlugin getRawPlugin() {
        return cqPlugin;
    }
}
