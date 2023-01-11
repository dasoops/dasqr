package com.dasoops.dasserver.plugin.gitnotice.controller;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.gitnotice.entity.dto.Commits;
import com.dasoops.dasserver.plugin.gitnotice.entity.dto.PushNoticeDto;
import com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeBotXSelfIdEnum;
import com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeRefEnum;
import com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeTypeEnum;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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

    private final ConfigCache configCache;
    private final ConfigService configService;

    public GitController(ConfigCache configCache, ConfigService configService) {
        this.configCache = configCache;
        this.configService = configService;
    }

    @PostMapping("/push")
    @ApiOperation(value = "gitPush 消息上报", notes = "gitPush 消息上报")
    public void pushNotice(@RequestBody PushNoticeDto pushNoticeDto) {
        //是否需要提醒
        GitNoticeTypeEnum noticeTypeEnum = configCache.getEnumConfig(GitConfigHashKeyEnum.GIT_NOTICE_TYPE, GitNoticeTypeEnum.class);
        if (noticeTypeEnum.equals(GitNoticeTypeEnum.NONE)) {
            return;
        }

        //检查提醒分支
        List<String> noticeRefList = configCache.getStringListConfig(GitConfigHashKeyEnum.GIT_NOTICE_REFS);
        String ref = getRef(pushNoticeDto);
        //检查是否为全部
        if (!noticeRefList.contains(GitNoticeRefEnum.ALL.getDbValue())) {
            //检查是否提醒分支
            if (!noticeRefList.contains(ref)) {
                return;
            }
        }

        //获取需要发送提醒的CqTemplate集合
        String gitNoticeXSelfId = configCache.getStringConfig(GitConfigHashKeyEnum.GIT_NOTICE_X_SELF_ID);
        List<CqTemplate> cqTemplateList;
        if (gitNoticeXSelfId.equals(GitNoticeBotXSelfIdEnum.ALL.getDbValue())) {
            cqTemplateList = CqGlobal.getAll();
        } else {
            List<Long> xSelfIdList = StrUtil.split(gitNoticeXSelfId, ",").stream().map(Long::valueOf).toList();
            cqTemplateList = xSelfIdList.stream().map(CqGlobal::get).filter(Objects::nonNull).toList();
        }

        //发送提醒消息
        Long groupId = configCache.getLongConfig(GitConfigHashKeyEnum.GIT_NOTICE_GROUP);
        Long userId = configCache.getLongConfig(GitConfigHashKeyEnum.GIT_NOTICE_USER);
        String commitNoticeString = buildCommitNoticeStr(pushNoticeDto);
        sendNotice(noticeTypeEnum, cqTemplateList, groupId, userId, commitNoticeString);

        //是否是重启分支(即新版本)
        List<String> rebootNoticeRefList = configCache.getStringListConfig(GitConfigHashKeyEnum.GIT_REBOOT_NOTICE_REFS);
        if (!rebootNoticeRefList.contains(ref)) {
            return;
        }

        //更新版本号
        Integer cloudVersion = configService.updateVersion(pushNoticeDto.getCommits().size());
        String rebootNoticeStr = buildRebootNoticeStr(pushNoticeDto, cloudVersion);
        sendNotice(noticeTypeEnum, cqTemplateList, groupId, userId, rebootNoticeStr);
    }

    private void sendNotice(GitNoticeTypeEnum noticeTypeEnum, List<CqTemplate> cqTemplateList, Long groupId, Long userId, String rebootNoticeStr) {
        switch (noticeTypeEnum) {
            case GROUP -> cqTemplateList.forEach(cqTemplate -> cqTemplate.sendGroupMsg(groupId, rebootNoticeStr));
            case PRIVATE -> cqTemplateList.forEach(cqTemplate -> cqTemplate.sendPrivateMsg(userId, rebootNoticeStr));
            case GROUP_AT_USER -> cqTemplateList.forEach(cqTemplate -> cqTemplate.sendGroupMsg(groupId, CqCodeUtil.at(userId) + rebootNoticeStr));
        }
    }

    /**
     * 构建RebootNoticeStr
     *
     * @param dto          推送通知dto
     * @param cloudVersion 云版本
     * @return {@link String}
     */
    private String buildRebootNoticeStr(PushNoticeDto dto, Integer cloudVersion) {
        return StrUtil.format("{}分支收到提交\r\n(Ver.{}R -> Ver.{}R)\r\n可以使用reboot指令重新编译运行最新版本了捏", getRef(dto), cloudVersion, cloudVersion - dto.getTotalCommitsCount());
    }


    /**
     * 构建提交通知str
     *
     * @param pushNoticeDto 推送通知dto
     * @return {@link String}
     */
    private String buildCommitNoticeStr(PushNoticeDto pushNoticeDto) {
        String branch = getRef(pushNoticeDto);

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
     * 获取分支
     *
     * @param pushNoticeDto 推送消息dto
     * @return {@link String}
     */
    private String getRef(PushNoticeDto pushNoticeDto) {
        String[] refSplit = pushNoticeDto.getRef().split("/");
        return refSplit[refSplit.length - 1].replace("/", "");
    }

}