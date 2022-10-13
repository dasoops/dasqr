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
        StringBuilder sb = new StringBuilder();
        sb.append("收到了新的push!\r\n");
        sb.append("sender: ").append(gitProperties.getSender().getName()).append("(").append(gitProperties.getSender().getEmail()).append(")\r\n");

        for (int i = 0; i <= gitProperties.getCommits().size(); i++) {
            Commits res = gitProperties.getCommits().get(i);
            sb.append("commit").append(i).append(": ").append(res.getCommitter().getName()).append("(").append(res.getCommitter().getEmail()).append(")\r\n");
        }

        cqService.sendMsg(true, Long.valueOf(dasqProperties.getDevGroupId()), KeywordUtil.buildAtCqCode(dasqProperties.getAdminId()) + sb);
    }


}