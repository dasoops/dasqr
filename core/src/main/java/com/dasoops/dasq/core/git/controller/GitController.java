package com.dasoops.dasq.core.git.controller;

import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.util.KeywordUtil;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.git.entity.Commits;
import com.dasoops.dasq.core.git.entity.GitProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: GitController
 * @ClassPath com.dasoops.dasq.core.git.controller.GitController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description:
 */
@RestController
@RequestMapping("/git")
public class GitController {

    @Resource
    private CqService cqService;
    @Resource
    private DasqProperties dasqProperties;

    @PostMapping("/push")
    public void push(@RequestBody GitProperties gitProperties) {
        String[] refSplit = gitProperties.getRef().split("/");
        String branch = refSplit[refSplit.length - 1].replace("/", "");

        StringBuilder sb = new StringBuilder();
        sb.append("收到了新的push!\r\n");
        sb.append("sender: ").append(gitProperties.getHeadCommit().getCommitter().getName()).append("(").append(gitProperties.getHeadCommit().getCommitter().getEmail()).append(")\r\n");
        sb.append("branch: ").append(branch).append("\r\n");
        List<Commits> commitList = gitProperties.getCommits();
        for (int i = 0; i < commitList.size(); i++) {
            Commits res = commitList.get(i);
            sb.append("commit").append(i + 1).append(": ").append(res.getMessage()).append("\r\n");
            sb.append("   url").append(i + 1).append(": ").append(res.getUrl()).append("\r\n");
        }

        cqService.sendMsg(true, Long.valueOf(dasqProperties.getDevGroupId()), KeywordUtil.buildAtCqCode(dasqProperties.getAdminId()) + sb);
    }


}
