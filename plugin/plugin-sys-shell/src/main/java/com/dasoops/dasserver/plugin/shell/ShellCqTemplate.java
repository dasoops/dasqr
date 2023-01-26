package com.dasoops.dasserver.plugin.shell;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.api.IApiRequest;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqGroupAnonymous;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqStatus;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.dto.cq.retdata.*;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellExceptionEnum;
import org.springframework.web.socket.WebSocketSession;

/**
 * @Title: ShellShamCqTemplate
 * @ClassPath com.dasoops.dasserver.plugin.shell.ShellShamCqTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: shellShamcqTemplate
 * @see CqTemplate
 */
public class ShellCqTemplate implements CqTemplate {

    private final ShellTemplate shellTemplate;

    public ShellCqTemplate(ShellTemplate shellTemplate) {
        this.shellTemplate = shellTemplate;
    }

    @Override
    public void setBotSession(WebSocketSession session) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public long getSelfId() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public void setSelfId(long selfId) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<?> callCustomApi(IApiRequest apiRequest) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<MessageData> sendMsg(CqMessageEvent event, String message) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendMsg(MessageParam<? extends BaseParam> param, String message) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendPrivateMsg(Long groupId, Long qId, String message, boolean autoEscape) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendPrivateMsg(Long qId, String message) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendPrivateMsg(Long groupId, Long qId, String message) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendGroupMsg(Long groupId, String message, boolean autoEscape) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendGroupMsg(Long groupId, String message) {
        shellTemplate.sendMsg(message);
        return null;
    }

    @Override
    public ApiData<MessageData> sendDiscussMsg(Long discussId, String message, boolean autoEscape) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData deleteMsg(String messageId) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData sendLike(Long userId, Integer times) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupKick(Long groupId, Long userId, boolean rejectAddRequest) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupBan(Long groupId, Long userId, long duration) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupAnonymousBan(Long groupId, CqGroupAnonymous cqGroupAnonymous, boolean duration) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupAnonymousBan(Long groupId, String flag, boolean duration) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupWholeBan(Long groupId, boolean enable) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupAdmin(Long groupId, Long userId, boolean enable) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupAnonymous(Long groupId, boolean enable) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupCard(Long groupId, Long userId, String card) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupLeave(Long groupId, boolean isDismiss) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, int duration) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setDiscussLeave(Integer discussId) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setFriendAddRequest(String flag, boolean approve, String remark) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setGroupAddRequest(String flag, String subType, boolean approve, String reason) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<LoginInfoData> getLoginInfo() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<StrangerInfoData> getStrangerInfo(Long userId, boolean noCache) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiListData<FriendData> getFriendList() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiListData<GroupData> getGroupList() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<GroupInfoData> getGroupInfo(Long groupId, boolean noCache) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<GroupMemberInfoData> getGroupMemberInfo(Long groupId, Long userId, boolean noCache) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiListData<GroupMemberInfoData> getGroupMemberList(Long groupId) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<CookiesData> getCookies(String domain) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<CsrfTokenData> getCsrfToken() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<CredentialsData> getCredentials(String domain) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<FileData> getRecord(String file, String outFormat, boolean fullPath) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<FileData> getImage(String file) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<BooleanData> canSendImage() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<BooleanData> canSendRecord() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<CqStatus> getStatus() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiData<VersionInfoData> getVersionInfo() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData setRestartPlugin(int delay) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData cleanDataDir(String dataDir) {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }

    @Override
    public ApiRawData cleanPluginLog() {
        throw new LogicException(ShellExceptionEnum.UNSUPPORTED_OPERATION);
    }
}
