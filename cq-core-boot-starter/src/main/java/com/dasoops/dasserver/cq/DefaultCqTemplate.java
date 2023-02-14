package com.dasoops.dasserver.cq;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.api.IApiRequest;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqGroupAnonymous;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqStatus;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.dto.cq.retdata.*;
import com.dasoops.dasserver.cq.entity.enums.ApiEnum;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @title: CqTemplate
 * @classPath com.dasoops.dasserver.cq.CqTemplate
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/20
 * @version 1.0.0
 * @description cq对外暴露模板类, 提供cq消息发送
 */
public class DefaultCqTemplate implements CqTemplate {

    @Setter
    private WebSocketSession botSession;

    @Setter
    @Getter
    private long selfId;

    private final ApiHandler apiHandler;

    public DefaultCqTemplate(Long selfId, WebSocketSession botSession, ApiHandler apiHandler) {
        this.selfId = selfId;
        this.botSession = botSession;
        this.apiHandler = apiHandler;
    }

    @Override
    public ApiData<?> callCustomApi(IApiRequest apiRequest) throws IOException, InterruptedException {
        return apiHandler.sendCusmonApiMessage(botSession, apiRequest).to(ApiData.class);
    }

    @Override
    public ApiData<MessageData> sendMsg(CqMessageEvent event, String message) {
        String messageType = event.getMessageType();
        if ("group".equals(messageType)) {
            return sendGroupMsg(((CqGroupMessageEvent) event).getGroupId(), message, false);
        }
        return sendPrivateMsg(null, event.getUserId(), message, false);
    }

    @Override
    public ApiData<MessageData> sendMsg(MessageParam<? extends BaseParam> param, String message) {
        if (param.getIsGroup()) {
            return sendGroupMsg(param.getGroupId(), message, false);
        }
        return sendPrivateMsg(null, param.getUserId(), message, false);
    }

    @Override
    public ApiData<MessageData> sendPrivateMsg(Long groupId, Long qId, String message, boolean autoEscape) {
        ApiEnum action = ApiEnum.SEND_PRIVATE_MSG;

        JSONObject params = new JSONObject();
        params.put("user_id", qId);
        params.put("group_id", groupId);
        params.put("message", message);
        params.put("auto_escape", autoEscape);

        ApiData<MessageData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<MessageData>>() {
        });

        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<MessageData> sendPrivateMsg(Long qId, String message) {
        return sendPrivateMsg(null, qId, message, false);
    }

    @Override
    public ApiData<MessageData> sendPrivateMsg(Long groupId, Long qId, String message) {
        return sendPrivateMsg(groupId, qId, message, false);
    }

    @Override
    public ApiData<MessageData> sendGroupMsg(Long groupId, String message, boolean autoEscape) {

        ApiEnum action = ApiEnum.SEND_GROUP_MSG;


        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("message", message);
        params.put("auto_escape", autoEscape);


        ApiData<MessageData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<MessageData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<MessageData> sendGroupMsg(Long groupId, String message) {
        return sendGroupMsg(groupId, message, false);
    }

    @Override
    public ApiData<MessageData> sendDiscussMsg(Long discussId, String message, boolean autoEscape) {
        ApiEnum action = ApiEnum.SEND_DISCUSS_MSG;

        JSONObject params = new JSONObject();
        params.put("discuss_id", discussId);
        params.put("message", message);
        params.put("auto_escape", autoEscape);

        ApiData<MessageData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<MessageData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData deleteMsg(String messageId) {
        ApiEnum action = ApiEnum.DELETE_MSG;

        JSONObject params = new JSONObject();
        params.put("message_id", messageId);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData sendLike(Long userId, Integer times) {
        ApiEnum action = ApiEnum.SEND_LIKE;

        JSONObject params = new JSONObject();
        params.put("user_id", userId);
        params.put("times", times);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupKick(Long groupId, Long userId, boolean rejectAddRequest) {
        ApiEnum action = ApiEnum.SET_GROUP_KICK;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("user_id", userId);
        params.put("reject_add_request", rejectAddRequest);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupBan(Long groupId, Long userId, long duration) {
        ApiEnum action = ApiEnum.SET_GROUP_BAN;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("user_id", userId);
        params.put("duration", duration);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupAnonymousBan(Long groupId, CqGroupAnonymous cqGroupAnonymous, boolean duration) {
        ApiEnum action = ApiEnum.SET_GROUP_ANONYMOUS_BAN;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("anonymous", cqGroupAnonymous);
        params.put("duration", duration);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupAnonymousBan(Long groupId, String flag, boolean duration) {
        ApiEnum action = ApiEnum.SET_GROUP_ANONYMOUS_BAN;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("flag", flag);
        params.put("duration", duration);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupWholeBan(Long groupId, boolean enable) {
        ApiEnum action = ApiEnum.SET_GROUP_WHOLE_BAN;
        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("enable", enable);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupAdmin(Long groupId, Long userId, boolean enable) {
        ApiEnum action = ApiEnum.SET_GROUP_ADMIN;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("user_id", userId);
        params.put("enable", enable);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupAnonymous(Long groupId, boolean enable) {
        ApiEnum action = ApiEnum.SET_GROUP_ANONYMOUS;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("enable", enable);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupCard(Long groupId, Long userId, String card) {
        ApiEnum action = ApiEnum.SET_GROUP_CARD;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("user_id", userId);
        params.put("card", card);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupLeave(Long groupId, boolean isDismiss) {
        ApiEnum action = ApiEnum.SET_GROUP_LEAVE;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("is_dismiss", isDismiss);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, int duration) {
        ApiEnum action = ApiEnum.SET_GROUP_SPECIAL_TITLE;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("user_id", userId);
        params.put("special_title", specialTitle);
        params.put("duration", duration);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setDiscussLeave(Integer discussId) {
        ApiEnum action = ApiEnum.SET_DISCUSS_LEAVE;

        JSONObject params = new JSONObject();
        params.put("discuss_id", discussId);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setFriendAddRequest(String flag, boolean approve, String remark) {
        ApiEnum action = ApiEnum.SET_FRIEND_ADD_REQUEST;

        JSONObject params = new JSONObject();
        params.put("flag", flag);
        params.put("approve", approve);
        params.put("remark", remark);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setGroupAddRequest(String flag, String subType, boolean approve, String reason) {
        ApiEnum action = ApiEnum.SET_GROUP_ADD_REQUEST;

        JSONObject params = new JSONObject();
        params.put("flag", flag);
        params.put("sub_type", subType);
        params.put("approve", approve);
        params.put("reason", reason);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<LoginInfoData> getLoginInfo() {
        ApiEnum action = ApiEnum.GET_LOGIN_INFO;

        ApiData<LoginInfoData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<LoginInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<StrangerInfoData> getStrangerInfo(Long userId, boolean noCache) {

        ApiEnum action = ApiEnum.GET_STRANGER_INFO;

        JSONObject params = new JSONObject();
        params.put("user_id", userId);
        params.put("no_cache", noCache);

        ApiData<StrangerInfoData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<StrangerInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiListData<FriendData> getFriendList() {
        ApiEnum action = ApiEnum.GET_FRIEND_LIST;
        ApiListData<FriendData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiListData<FriendData>>() {
        });

        checkResultCode(result);
        return result;
    }

    @Override
    public ApiListData<GroupData> getGroupList() {
        ApiEnum action = ApiEnum.GET_GROUP_LIST;

        ApiListData<GroupData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiListData<GroupData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<GroupInfoData> getGroupInfo(Long groupId, boolean noCache) {
        ApiEnum action = ApiEnum.GET_GROUP_INFO;
        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("no_cache", noCache);
        ApiData<GroupInfoData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<GroupInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<GroupMemberInfoData> getGroupMemberInfo(Long groupId, Long userId, boolean noCache) {
        ApiEnum action = ApiEnum.GET_GROUP_MEMBER_INFO;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("user_id", userId);
        params.put("no_cache", noCache);

        ApiData<GroupMemberInfoData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<GroupMemberInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiListData<GroupMemberInfoData> getGroupMemberList(Long groupId) {
        ApiEnum action = ApiEnum.GET_GROUP_MEMBER_LIST;
        JSONObject params = new JSONObject();

        params.put("group_id", groupId);
        ApiListData<GroupMemberInfoData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiListData<GroupMemberInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<CookiesData> getCookies(String domain) {
        ApiEnum action = ApiEnum.GET_COOKIES;

        JSONObject params = new JSONObject();
        params.put("domain", domain);

        ApiData<CookiesData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<CookiesData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<CsrfTokenData> getCsrfToken() {
        ApiEnum action = ApiEnum.GET_CSRF_TOKEN;

        ApiData<CsrfTokenData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<CsrfTokenData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<CredentialsData> getCredentials(String domain) {
        ApiEnum action = ApiEnum.GET_CREDENTIALS;

        JSONObject params = new JSONObject();
        params.put("domain", domain);

        ApiData<CredentialsData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<CredentialsData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<FileData> getRecord(String file, String outFormat, boolean fullPath) {
        ApiEnum action = ApiEnum.GET_RECORD;

        JSONObject params = new JSONObject();
        params.put("file", file);
        params.put("out_format", outFormat);
        params.put("full_path", fullPath);

        ApiData<FileData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<FileData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<FileData> getImage(String file) {
        ApiEnum action = ApiEnum.GET_IMAGE;

        JSONObject params = new JSONObject();
        params.put("file", file);

        ApiData<FileData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<FileData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<BooleanData> canSendImage() {
        ApiEnum action = ApiEnum.CAN_SEND_IMAGE;

        ApiData<BooleanData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<BooleanData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<BooleanData> canSendRecord() {
        ApiEnum action = ApiEnum.CAN_SEND_RECORD;

        ApiData<BooleanData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<BooleanData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<CqStatus> getStatus() {
        ApiEnum action = ApiEnum.GET_STATUS;

        ApiData<CqStatus> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<CqStatus>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiData<VersionInfoData> getVersionInfo() {
        ApiEnum action = ApiEnum.GET_VERSION_INFO;

        ApiData<VersionInfoData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<VersionInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData setRestartPlugin(int delay) {
        ApiEnum action = ApiEnum.SET_RESTART_PLUGIN;

        JSONObject params = new JSONObject();
        params.put("delay", delay);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData cleanDataDir(String dataDir) {
        ApiEnum action = ApiEnum.CLEAN_DATA_DIR;

        JSONObject params = new JSONObject();
        params.put("data_dir", dataDir);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    @Override
    public ApiRawData cleanPluginLog() {
        ApiEnum action = ApiEnum.CLEAN_PLUGIN_LOG;

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, null).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }

    private void checkResultCode(BaseApiData result) {
        if (result.getRetcode() != 0) {
            if (result.getWording() == null) {
                throw new CqLogicException(CqExceptionEnum.RESPONSE_ERROR);
            }
            if (result.getWording().contains("参考")) {
                throw new CqLogicException(CqExceptionEnum.SEND_ERROR);
            }
            if ("empty message".equals(result.getWording())) {
                throw new CqLogicException(CqExceptionEnum.EMPTY_MSG);
            }
            throw new CqLogicException(CqExceptionEnum.RESPONSE_ERROR);
        }
    }
}
