package com.dasoops.dasserver.cq;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.api.IApiRequest;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqGroupAnonymous;
import com.dasoops.dasserver.cq.entity.dto.cq.entity.CqStatus;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.dto.cq.retdata.*;
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
public interface CqTemplate {

    /**
     * 设置webSocket连接session
     *
     * @param session
     */
    void setBotSession(WebSocketSession session);

    /**
     * 获取botId
     *
     * @return long botId
     */
    long getSelfId();

    /**
     * 设置botId
     *
     * @param selfId botId
     */
    void setSelfId(long selfId);

    /**
     * 调用自定义的API
     *
     * @param apiRequest 包含String url, JsonObject params
     * @return 结果
     * @throws IOException          发送异常
     * @throws InterruptedException 线程异常
     */
    ApiData<?> callCustomApi(IApiRequest apiRequest) throws IOException, InterruptedException;

    /**
     * 发送消息
     *
     * @param event   事件
     * @param message 消息
     * @return {@link ApiData}<{@link MessageData}>
     */
    ApiData<MessageData> sendMsg(CqMessageEvent event, String message);

    /**
     * 发送消息
     *
     * @param message 消息
     * @param param   param
     * @return {@link ApiData}<{@link MessageData}>
     */
    ApiData<MessageData> sendMsg(MessageParam<? extends BaseParam> param, String message);

    /**
     * 发送私人味精
     * 发送私聊消息
     *
     * @param qId        对方 QQ 号
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     * @param groupId    群组id
     * @return 结果
     */
    ApiData<MessageData> sendPrivateMsg(Long groupId, Long qId, String message, boolean autoEscape);

    /**
     * 发送私聊消息
     *
     * @param qId     对方 QQ 号
     * @param message 要发送的内容
     * @return 结果
     */
    ApiData<MessageData> sendPrivateMsg(Long qId, String message);

    /**
     * 发送私聊消息
     *
     * @param qId     对方 QQ 号
     * @param message 要发送的内容
     * @return 结果
     */
    ApiData<MessageData> sendPrivateMsg(Long groupId, Long qId, String message);

    /**
     * 发送群消息
     *
     * @param groupId    群号
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     * @return 结果
     */
    ApiData<MessageData> sendGroupMsg(Long groupId, String message, boolean autoEscape);


    /**
     * 发送群消息
     *
     * @param groupId 群号
     * @param message 要发送的内容
     * @return 结果
     */
    ApiData<MessageData> sendGroupMsg(Long groupId, String message);

    /**
     * 发送讨论组消息
     *
     * @param discussId  讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     * @return 结果
     */
    ApiData<MessageData> sendDiscussMsg(Long discussId, String message, boolean autoEscape);

    /**
     * 撤回消息
     *
     * @param messageId 消息 ID
     * @return 结果
     */
    ApiRawData deleteMsg(String messageId);

    /**
     * 发送好友赞
     *
     * @param userId 对方 QQ 号
     * @param times  赞的次数，每个好友每天最多 10 次
     * @return 结果
     */
    ApiRawData sendLike(Long userId, Integer times);

    /**
     * 群组踢人
     *
     * @param groupId          群号
     * @param userId           要踢的 QQ 号
     * @param rejectAddRequest 拒绝此人的加群请求
     * @return 结果
     */
    ApiRawData setGroupKick(Long groupId, Long userId, boolean rejectAddRequest);

    /**
     * 群组单人禁言
     *
     * @param groupId  群号
     * @param userId   要禁言的 QQ 号
     * @param duration 禁言时长，单位秒，0 表示取消禁言
     * @return 结果
     */
    ApiRawData setGroupBan(Long groupId, Long userId, long duration);

    /**
     * 群组匿名用户禁言
     *
     * @param groupId          群号
     * @param cqGroupAnonymous 要禁言的匿名用户对象（群消息上报的 anonymous 字段）
     * @param duration         禁言时长，单位秒，无法取消匿名用户禁言
     * @return 结果
     */
    ApiRawData setGroupAnonymousBan(Long groupId, CqGroupAnonymous cqGroupAnonymous, boolean duration);

    /**
     * 群组匿名用户禁言
     *
     * @param groupId  群号
     * @param flag     要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     * @param duration 禁言时长，单位秒，无法取消匿名用户禁言
     * @return 结果
     */
    ApiRawData setGroupAnonymousBan(Long groupId, String flag, boolean duration);

    /**
     * 群组全员禁言
     *
     * @param groupId 群号
     * @param enable  是否禁言
     * @return 结果
     */
    ApiRawData setGroupWholeBan(Long groupId, boolean enable);

    /**
     * 群组设置管理员
     *
     * @param groupId 群号
     * @param userId  要设置管理员的 QQ 号
     * @param enable  true 为设置，false 为取消
     * @return 结果
     */
    ApiRawData setGroupAdmin(Long groupId, Long userId, boolean enable);

    /**
     * 群组匿名
     *
     * @param groupId 群号
     * @param enable  是否允许匿名聊天
     * @return 结果
     */
    ApiRawData setGroupAnonymous(Long groupId, boolean enable);

    /**
     * 设置群名片（群备注）
     *
     * @param groupId 群号
     * @param userId  要设置的 QQ 号
     * @param card    群名片内容，不填或空字符串表示删除群名片
     * @return 结果
     */
    ApiRawData setGroupCard(Long groupId, Long userId, String card);

    /**
     * @param groupId   群号
     * @param isDismiss 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散
     * @return 结果
     */
    ApiRawData setGroupLeave(Long groupId, boolean isDismiss);

    /**
     * 设置群组专属头衔
     *
     * @param groupId      群号
     * @param userId       要设置的 QQ 号
     * @param specialTitle 专属头衔，不填或空字符串表示删除专属头衔
     * @param duration     专属头衔有效期，单位秒，-1 表示永久，不过此项似乎没有效果，可能是只有某些特殊的时间长度有效，有待测试
     * @return 结果
     */
    ApiRawData setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, int duration);

    /**
     * 退出讨论组
     *
     * @param discussId 讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     * @return 结果
     */
    ApiRawData setDiscussLeave(Integer discussId);

    /**
     * 处理加好友请求
     *
     * @param flag    加好友请求的 flag（需从上报的数据中获得）
     * @param approve 是否同意请求
     * @param remark  添加后的好友备注（仅在同意时有效）
     * @return 结果
     */
    ApiRawData setFriendAddRequest(String flag, boolean approve, String remark);

    /**
     * 处理加群请求／邀请
     *
     * @param flag    加群请求的 flag（需从上报的数据中获得）
     * @param subType add 或 invite，请求类型（需要和上报消息中的 subType 字段相符）
     * @param approve 是否同意请求／邀请
     * @param reason  拒绝理由（仅在拒绝时有效）
     * @return 结果
     */
    ApiRawData setGroupAddRequest(String flag, String subType, boolean approve, String reason);

    /**
     * 获取登录号信息
     *
     * @return 结果
     */
    ApiData<LoginInfoData> getLoginInfo();

    /**
     * 获取陌生人信息
     *
     * @param userId  QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 结果
     */
    ApiData<StrangerInfoData> getStrangerInfo(Long userId, boolean noCache);

    /**
     * 获取好友列表
     *
     * @return 结果
     */
    ApiListData<FriendData> getFriendList();

    /**
     * 获取群列表
     *
     * @return 结果
     */
    ApiListData<GroupData> getGroupList();

    /**
     * 获取群信息
     *
     * @param groupId 群号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 结果
     */
    ApiData<GroupInfoData> getGroupInfo(Long groupId, boolean noCache);

    /**
     * 获取群成员信息
     *
     * @param groupId 群号
     * @param userId  QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 结果
     */
    ApiData<GroupMemberInfoData> getGroupMemberInfo(Long groupId, Long userId, boolean noCache);

    /**
     * 获取群成员列表
     * <p>
     * 响应内容为 JSON 数组，每个元素的内容和上面的 /get_group_member_info 接口相同，但对于同一个群组的同一个成员，获取列表时和获取单独的成员信息时，某些字段可能有所不同，例如 area、title 等字段在获取列表时无法获得，具体应以单独的成员信息为准。
     *
     * @param groupId 群号
     * @return 结果
     */
    ApiListData<GroupMemberInfoData> getGroupMemberList(Long groupId);


    /**
     * 获取 Cookies
     *
     * @param domain 需要获取 cookies 的域名
     * @return 结果
     */
    ApiData<CookiesData> getCookies(String domain);

    /**
     * 获取 CSRF Token
     *
     * @return 结果
     */
    ApiData<CsrfTokenData> getCsrfToken();

    /**
     * 获取 QQ 相关接口凭证
     * 即上面两个接口的合并
     *
     * @param domain 需要获取 cookies 的域名
     * @return 结果
     */
    ApiData<CredentialsData> getCredentials(String domain);

    /**
     * 获取语音
     *
     * @param file      收到的语音文件名（CQ 码的 file 参数），如 0B38145AA44505000B38145AA4450500.silk
     * @param outFormat 要转换到的格式，目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac
     * @param fullPath  是否返回文件的绝对路径（Windows 环境下建议使用，Docker 中不建议）
     * @return 结果
     */
    ApiData<FileData> getRecord(String file, String outFormat, boolean fullPath);

    /**
     * 获取图片
     *
     * @param file 收到的图片文件名（CQ 码的 file 参数），如 6B4DE3DFD1BD271E3297859D41C530F5.jpg
     * @return 结果
     */
    ApiData<FileData> getImage(String file);

    /**
     * 检查是否可以发送图片
     *
     * @return 结果
     */
    ApiData<BooleanData> canSendImage();

    /**
     * 检查是否可以发送语音
     *
     * @return 结果
     */
    ApiData<BooleanData> canSendRecord();

    /**
     * 获取插件运行状态
     *
     * @return 结果
     */
    ApiData<CqStatus> getStatus();

    /**
     * 获取 酷Q 及 HTTP API 插件的版本信息
     * 参数
     *
     * @return 结果
     */
    ApiData<VersionInfoData> getVersionInfo();

    /**
     * 重启 HTTP API 插件
     *
     * @param delay 要延迟的毫秒数，如果默认情况下无法重启，可以尝试设置延迟为 2000 左右
     * @return 结果
     */
    ApiRawData setRestartPlugin(int delay);

    /**
     * 清理数据目录
     *
     * @param dataDir 收到清理的目录名，支持 image、record、show、bface
     * @return 结果
     */
    ApiRawData cleanDataDir(String dataDir);

    /**
     * 清理插件日志
     *
     * @return 结果
     */
    ApiRawData cleanPluginLog();

}
