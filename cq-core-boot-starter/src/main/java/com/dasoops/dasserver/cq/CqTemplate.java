package com.dasoops.dasserver.cq;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.api.IApiRequest;
import com.dasoops.dasserver.cq.entity.entity.CqGroupAnonymous;
import com.dasoops.dasserver.cq.entity.entity.CqStatus;
import com.dasoops.dasserver.cq.entity.enums.ApiEnum;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.retdata.*;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @Title: CqTemplate
 * @ClassPath com.dasoops.dasserver.cq.CqTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: cq对外暴露模板类, 提供cq消息发送
 */
@Data
@SuppressWarnings("unused")
public class CqTemplate {

    private WebSocketSession botSession;
    private ApiHandler apiHandler;
    private long selfId;

    public CqTemplate(Long selfId, WebSocketSession botSession, ApiHandler apiHandler) {
        this.selfId = selfId;
        this.botSession = botSession;
        this.apiHandler = apiHandler;
    }


    /**
     * 调用自定义的API
     *
     * @param apiRequest 包含String url, JsonObject params
     * @return 结果
     * @throws IOException          发送异常
     * @throws InterruptedException 线程异常
     */
    @SuppressWarnings("all")
    public ApiData callCustomApi(IApiRequest apiRequest) throws IOException, InterruptedException {
        return apiHandler.sendCusmonApiMessage(botSession, apiRequest).to(ApiData.class);
    }

    /**
     * 发送消息
     *
     * @param event   事件
     * @param message 消息
     * @return {@link ApiData}<{@link MessageData}>
     */
    public ApiData<MessageData> sendMsg(CqMessageEvent event, String message) {
        String messageType = event.getMessageType();
        if ("group".equals(messageType)) {
            return sendGroupMsg(((CqGroupMessageEvent) event).getGroupId(), message, false);
        }
        return sendPrivateMsg(event.getUserId(), message, false);
    }

    /**
     * 发送私聊消息
     *
     * @param qId        对方 QQ 号
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     * @return 结果
     */
    public ApiData<MessageData> sendPrivateMsg(Long qId, String message, boolean autoEscape) {
        ApiEnum action = ApiEnum.SEND_PRIVATE_MSG;

        JSONObject params = new JSONObject();
        params.put("user_id", qId);
        params.put("message", message);
        params.put("auto_escape", autoEscape);

        ApiData<MessageData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<MessageData>>() {
        });

        checkResultCode(result);
        return result;
    }

    /**
     * 发送群消息
     *
     * @param groupId    群号
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     * @return 结果
     */
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

    /**
     * 发送讨论组消息
     *
     * @param discussId  讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     * @return 结果
     */
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

    /**
     * 撤回消息
     *
     * @param messageId 消息 ID
     * @return 结果
     */
    public ApiRawData deleteMsg(String messageId) {
        ApiEnum action = ApiEnum.DELETE_MSG;

        JSONObject params = new JSONObject();
        params.put("message_id", messageId);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 发送好友赞
     *
     * @param userId 对方 QQ 号
     * @param times  赞的次数，每个好友每天最多 10 次
     * @return 结果
     */
    public ApiRawData sendLike(Long userId, Integer times) {
        ApiEnum action = ApiEnum.SEND_LIKE;

        JSONObject params = new JSONObject();
        params.put("user_id", userId);
        params.put("times", times);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 群组踢人
     *
     * @param groupId          群号
     * @param userId           要踢的 QQ 号
     * @param rejectAddRequest 拒绝此人的加群请求
     * @return 结果
     */
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

    /**
     * 群组单人禁言
     *
     * @param groupId  群号
     * @param userId   要禁言的 QQ 号
     * @param duration 禁言时长，单位秒，0 表示取消禁言
     * @return 结果
     */
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

    /**
     * 群组匿名用户禁言
     *
     * @param groupId          群号
     * @param cqGroupAnonymous 要禁言的匿名用户对象（群消息上报的 anonymous 字段）
     * @param duration         禁言时长，单位秒，无法取消匿名用户禁言
     * @return 结果
     */
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

    /**
     * 群组匿名用户禁言
     *
     * @param groupId  群号
     * @param flag     要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     * @param duration 禁言时长，单位秒，无法取消匿名用户禁言
     * @return 结果
     */
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

    /**
     * 群组全员禁言
     *
     * @param groupId 群号
     * @param enable  是否禁言
     * @return 结果
     */
    public ApiRawData setGroupWholeBan(Long groupId, boolean enable) {
        ApiEnum action = ApiEnum.SET_GROUP_WHOLE_BAN;
        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("enable", enable);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }

    /**
     * 群组设置管理员
     *
     * @param groupId 群号
     * @param userId  要设置管理员的 QQ 号
     * @param enable  true 为设置，false 为取消
     * @return 结果
     */
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

    /**
     * 群组匿名
     *
     * @param groupId 群号
     * @param enable  是否允许匿名聊天
     * @return 结果
     */
    public ApiRawData setGroupAnonymous(Long groupId, boolean enable) {
        ApiEnum action = ApiEnum.SET_GROUP_ANONYMOUS;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("enable", enable);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 设置群名片（群备注）
     *
     * @param groupId 群号
     * @param userId  要设置的 QQ 号
     * @param card    群名片内容，不填或空字符串表示删除群名片
     * @return 结果
     */
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

    /**
     * @param groupId   群号
     * @param isDismiss 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散
     * @return 结果
     */
    public ApiRawData setGroupLeave(Long groupId, boolean isDismiss) {
        ApiEnum action = ApiEnum.SET_GROUP_LEAVE;

        JSONObject params = new JSONObject();
        params.put("group_id", groupId);
        params.put("is_dismiss", isDismiss);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 设置群组专属头衔
     *
     * @param groupId      群号
     * @param userId       要设置的 QQ 号
     * @param specialTitle 专属头衔，不填或空字符串表示删除专属头衔
     * @param duration     专属头衔有效期，单位秒，-1 表示永久，不过此项似乎没有效果，可能是只有某些特殊的时间长度有效，有待测试
     * @return 结果
     */
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

    /**
     * 退出讨论组
     *
     * @param discussId 讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     * @return 结果
     */
    public ApiRawData setDiscussLeave(Integer discussId) {
        ApiEnum action = ApiEnum.SET_DISCUSS_LEAVE;

        JSONObject params = new JSONObject();
        params.put("discuss_id", discussId);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 处理加好友请求
     *
     * @param flag    加好友请求的 flag（需从上报的数据中获得）
     * @param approve 是否同意请求
     * @param remark  添加后的好友备注（仅在同意时有效）
     * @return 结果
     */
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

    /**
     * 处理加群请求／邀请
     *
     * @param flag    加群请求的 flag（需从上报的数据中获得）
     * @param subType add 或 invite，请求类型（需要和上报消息中的 subType 字段相符）
     * @param approve 是否同意请求／邀请
     * @param reason  拒绝理由（仅在拒绝时有效）
     * @return 结果
     */
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

    /**
     * 获取登录号信息
     *
     * @return 结果
     */
    public ApiData<LoginInfoData> getLoginInfo() {
        ApiEnum action = ApiEnum.GET_LOGIN_INFO;

        ApiData<LoginInfoData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<LoginInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取陌生人信息
     *
     * @param userId  QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 结果
     */
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

    /**
     * 获取好友列表
     *
     * @return 结果
     */
    public ApiListData<FriendData> getFriendList() {
        ApiEnum action = ApiEnum.GET_FRIEND_LIST;
        ApiListData<FriendData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiListData<FriendData>>() {
        });

        checkResultCode(result);
        return result;
    }

    /**
     * 获取群列表
     *
     * @return 结果
     */
    public ApiListData<GroupData> getGroupList() {
        ApiEnum action = ApiEnum.GET_GROUP_LIST;

        ApiListData<GroupData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiListData<GroupData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取群信息
     *
     * @param groupId 群号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 结果
     */
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

    /**
     * 获取群成员信息
     *
     * @param groupId 群号
     * @param userId  QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 结果
     */
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

    /**
     * 获取群成员列表
     * <p>
     * 响应内容为 JSON 数组，每个元素的内容和上面的 /get_group_member_info 接口相同，但对于同一个群组的同一个成员，获取列表时和获取单独的成员信息时，某些字段可能有所不同，例如 area、title 等字段在获取列表时无法获得，具体应以单独的成员信息为准。
     *
     * @param groupId 群号
     * @return 结果
     */
    public ApiListData<GroupMemberInfoData> getGroupMemberList(Long groupId) {
        ApiEnum action = ApiEnum.GET_GROUP_MEMBER_LIST;
        JSONObject params = new JSONObject();

        params.put("group_id", groupId);
        ApiListData<GroupMemberInfoData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiListData<GroupMemberInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }


    /**
     * 获取 Cookies
     *
     * @param domain 需要获取 cookies 的域名
     * @return 结果
     */
    public ApiData<CookiesData> getCookies(String domain) {
        ApiEnum action = ApiEnum.GET_COOKIES;

        JSONObject params = new JSONObject();
        params.put("domain", domain);

        ApiData<CookiesData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<CookiesData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取 CSRF Token
     *
     * @return 结果
     */
    public ApiData<CsrfTokenData> getCsrfToken() {
        ApiEnum action = ApiEnum.GET_CSRF_TOKEN;

        ApiData<CsrfTokenData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<CsrfTokenData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取 QQ 相关接口凭证
     * 即上面两个接口的合并
     *
     * @param domain 需要获取 cookies 的域名
     * @return 结果
     */
    public ApiData<CredentialsData> getCredentials(String domain) {
        ApiEnum action = ApiEnum.GET_CREDENTIALS;

        JSONObject params = new JSONObject();
        params.put("domain", domain);

        ApiData<CredentialsData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<CredentialsData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取语音
     *
     * @param file      收到的语音文件名（CQ 码的 file 参数），如 0B38145AA44505000B38145AA4450500.silk
     * @param outFormat 要转换到的格式，目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac
     * @param fullPath  是否返回文件的绝对路径（Windows 环境下建议使用，Docker 中不建议）
     * @return 结果
     */
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

    /**
     * 获取图片
     *
     * @param file 收到的图片文件名（CQ 码的 file 参数），如 6B4DE3DFD1BD271E3297859D41C530F5.jpg
     * @return 结果
     */
    public ApiData<FileData> getImage(String file) {
        ApiEnum action = ApiEnum.GET_IMAGE;

        JSONObject params = new JSONObject();
        params.put("file", file);

        ApiData<FileData> result = apiHandler.sendApiMessage(botSession, action, params).to(new TypeReference<ApiData<FileData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 检查是否可以发送图片
     *
     * @return 结果
     */
    public ApiData<BooleanData> canSendImage() {
        ApiEnum action = ApiEnum.CAN_SEND_IMAGE;

        ApiData<BooleanData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<BooleanData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 检查是否可以发送语音
     *
     * @return 结果
     */
    public ApiData<BooleanData> canSendRecord() {
        ApiEnum action = ApiEnum.CAN_SEND_RECORD;

        ApiData<BooleanData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<BooleanData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取插件运行状态
     *
     * @return 结果
     */
    public ApiData<CqStatus> getStatus() {
        ApiEnum action = ApiEnum.GET_STATUS;

        ApiData<CqStatus> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<CqStatus>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 获取 酷Q 及 HTTP API 插件的版本信息
     * 参数
     *
     * @return 结果
     */
    public ApiData<VersionInfoData> getVersionInfo() {
        ApiEnum action = ApiEnum.GET_VERSION_INFO;

        ApiData<VersionInfoData> result = apiHandler.sendApiMessage(botSession, action, null).to(new TypeReference<ApiData<VersionInfoData>>() {
        });


        checkResultCode(result);
        return result;
    }

    /**
     * 重启 HTTP API 插件
     *
     * @param delay 要延迟的毫秒数，如果默认情况下无法重启，可以尝试设置延迟为 2000 左右
     * @return 结果
     */
    public ApiRawData setRestartPlugin(int delay) {
        ApiEnum action = ApiEnum.SET_RESTART_PLUGIN;

        JSONObject params = new JSONObject();
        params.put("delay", delay);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 清理数据目录
     *
     * @param dataDir 收到清理的目录名，支持 image、record、show、bface
     * @return 结果
     */
    public ApiRawData cleanDataDir(String dataDir) {
        ApiEnum action = ApiEnum.CLEAN_DATA_DIR;

        JSONObject params = new JSONObject();
        params.put("data_dir", dataDir);

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, params).to(ApiRawData.class);


        checkResultCode(result);
        return result;
    }

    /**
     * 清理插件日志
     *
     * @return 结果
     */
    public ApiRawData cleanPluginLog() {
        ApiEnum action = ApiEnum.CLEAN_PLUGIN_LOG;

        ApiRawData result = apiHandler.sendApiMessage(botSession, action, null).to(ApiRawData.class);

        checkResultCode(result);
        return result;
    }


    private void checkResultCode(ApiListData<?> result) {
        if (result.getRetcode() != 0) {
            throw new CqLogicException(CqExceptionEnum.RESPONSE_ERROR);
        }
    }

    private void checkResultCode(ApiData<?> result) {
        if (result.getRetcode() != 0) {
            throw new CqLogicException(CqExceptionEnum.RESPONSE_ERROR);
        }
    }

    private void checkResultCode(ApiRawData result) {
        if (result.getRetcode() != 0) {
            throw new CqLogicException(CqExceptionEnum.RESPONSE_ERROR);
        }
    }
}
