package com.dasoops.dasserver.plugin.gitnotice.controller;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.entity.retdata.ApiData;
import com.dasoops.dasserver.cq.entity.retdata.MessageData;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.gitnotice.GitNoticeProperties;
import com.dasoops.dasserver.plugin.gitnotice.entity.dto.Commits;
import com.dasoops.dasserver.plugin.gitnotice.entity.dto.PushNoticeDto;
import com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeTypeEnum;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Title: GitController
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.controller.GitController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: git控制器
 */
@RestController
@RequestMapping("/git")
@Api(tags = "PLUGIN - GIT_NOTICE")
@ApiSupport(author = "DasoopsNicole@gmail.com")
public class GitController {

    private final CqProperties cqProperties;
    private final GitNoticeProperties gitNoticeProperties;
    private final ConfigService configService;

    public GitController(CqProperties cqProperties, GitNoticeProperties gitNoticeProperties, ConfigService configService) {
        this.cqProperties = cqProperties;
        this.gitNoticeProperties = gitNoticeProperties;
        this.configService = configService;
    }

    @PostMapping("/push")
    @ApiOperation(value = "gitPush 消息上报",notes = "gitPush 消息上报")
    public void pushNotice(@RequestBody PushNoticeDto pushNoticeDto) {
        //获取当前配置的用户信息
        Optional<GitNoticeTypeEnum> noticeTypeEnumOpt = getEnum();
        if (noticeTypeEnumOpt.isEmpty()) {
            return;
        }
        GitNoticeTypeEnum noticeTypeEnum = noticeTypeEnumOpt.get();

        //无cq连接抛出异常
        CqTemplate cqTemplate = CqGlobal.findFirst().orElseThrow(() -> new CqLogicException(ExceptionEnum.NO_CQ_CONNECTION));

        //发送git通知
        sendNotice(cqTemplate, noticeTypeEnum, buildCommitNoticeStr(pushNoticeDto));

        //master分支收到消息发送重启通知
        if (isMaster(pushNoticeDto)) {
            Integer version = configService.updateVersion(pushNoticeDto.getTotalCommitsCount());
            sendNotice(cqTemplate, noticeTypeEnum, buildRebootNoticeStr(pushNoticeDto, version));
        }
    }

    /**
     * 构建RebootNoticeStr
     *
     * @param pushNoticeDto 推送通知dto
     * @param version       版本
     * @return {@link String}
     */
    private String buildRebootNoticeStr(PushNoticeDto pushNoticeDto, Integer version) {
        return StrUtil.format("master分支收到提交\r\n(Ver.{}R -> Ver.{}R)\r\n可以使用reboot指令重新编译运行最新版本了捏", version, version - pushNoticeDto.getTotalCommitsCount());
    }

    /**
     * 是Master分支
     *
     * @param pushNoticeDto 推送通知dto
     * @return boolean
     */
    private boolean isMaster(PushNoticeDto pushNoticeDto) {
        String[] refSplit = pushNoticeDto.getRef().split("/");
        String branch = refSplit[refSplit.length - 1].replace("/", "");
        final String master = "master";
        return master.equals(branch);
    }

    /**
     * 发送通知
     *
     * @param cqTemplate     cqTemplate
     * @param noticeTypeEnum 通知枚举
     * @param str            str
     */
    private void sendNotice(CqTemplate cqTemplate, GitNoticeTypeEnum noticeTypeEnum, String str) {
        ApiData<MessageData> resApiData;
        switch (noticeTypeEnum) {
            case GROUP:
                resApiData = cqTemplate.sendGroupMsg(gitNoticeProperties.getNoticeGroupId(), str, false);
                break;
            case PRIVATE:
                resApiData = cqTemplate.sendPrivateMsg(gitNoticeProperties.getNoticeUserId(), str, false);
                break;
            case GROUP_AT_USER:
                resApiData = cqTemplate.sendGroupMsg(gitNoticeProperties.getNoticeGroupId(), CqCodeUtil.at(gitNoticeProperties.getNoticeUserId()) + str, false);
                break;
            case CORE_GROUP:
                resApiData = cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), str, false);
                break;
            case CORE_PRIVATE:
                resApiData = cqTemplate.sendPrivateMsg(cqProperties.getDevUserId(), str, false);
                break;
            case CORE_GROUP_AT_USER:
                resApiData = cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), CqCodeUtil.at(cqProperties.getDevUserId()) + str, false);
                break;
            default:
                resApiData = new ApiData<>();
                resApiData.setStatus("failed");
                break;
        }

        final String failed = "failed";
        if (failed.equals(resApiData.getStatus())) {
            throw new CqLogicException(ExceptionEnum.CQ_RETURN_FAILED,JSON.toJSONString(resApiData));
        }

    }


    /**
     * 构建提交通知str
     *
     * @param pushNoticeDto 推送通知dto
     * @return {@link String}
     */
    private String buildCommitNoticeStr(PushNoticeDto pushNoticeDto) {
        int k = 1 / 0;
        String[] refSplit = pushNoticeDto.getRef().split("/");
        String branch = refSplit[refSplit.length - 1].replace("/", "");

        StringBuilder sb = new StringBuilder();
        sb.append("收到了新的push!\r\n");
        //sender: DasoopsNicole(DasoopsNicole@gmail.com)
        sb.append(StrUtil.format("sender:{}({})\r\n", pushNoticeDto.getHeadCommit().getCommitter().getName(), pushNoticeDto.getHeadCommit().getCommitter().getEmail()));
        //branch: refactor
        sb.append("branch: ").append(branch).append("\r\n");
        List<Commits> commitList = pushNoticeDto.getCommits();
        /*
            commit1: feat():  引入命名线程工厂
            https://gitee.com/dasoopsnicole/dasServer/commit/f4c60b6dc83742d4e0a40d16219505669c36b478
            commit2: build():  架构改动
            https://gitee.com/dasoopsnicole/dasServer/commit/cff8ac47b0b1e07b7ff89c5717352c39249ac81b
        */
        for (int i = 0; i < commitList.size(); i++) {
            Commits res = commitList.get(i);
            sb.append(StrUtil.format("commit{}: {}", i + 1, res.getMessage()));
            sb.append(res.getUrl()).append("\r\n");
        }

        return sb.toString();
    }

    /**
     * 根据字符串获取枚举
     *
     * @return {@link Optional}<{@link GitNoticeTypeEnum}>
     */
    @SuppressWarnings("all")
    private Optional<GitNoticeTypeEnum> getEnum() {
        GitNoticeTypeEnum gitNoticeTypeEnum = EnumUtil.getBy(GitNoticeTypeEnum::getKeyword, gitNoticeProperties.getNoticeType());
        return Optional.ofNullable(gitNoticeTypeEnum);
    }

}