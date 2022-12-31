package com.dasoops.dasserver.plugin.gitnotice.entity.dto;


import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Title: GitProperties
 * @ClassPath com.dasoops.dasq.core.git.entity.GitProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description: gitPush数据传输对象
 */
@Data
@ApiModel(value = "PushNoticeDto",description = "gitee 上报dto")
public class PushNoticeDto {
    @JSONField(name = "hook_name")
    private String hookName;
    private String password;
    @JSONField(name = "hook_id")
    private int hookId;
    @JSONField(name = "hook_url")
    private String hookUrl;
    private String timestamp;
    private String sign;
    private String ref;
    private String before;
    private String after;
    private boolean created;
    private boolean deleted;
    private String compare;
    private List<Commits> commits;
    @JSONField(name = "head_commit")
    private HeadCommit headCommit;
    @JSONField(name = "total_commits_count")
    private int totalCommitsCount;
    @JSONField(name = "commits_more_than_ten")
    private boolean commitsMoreThanTen;
    private Repository repository;
    private Sender sender;
    private Enterprise enterprise;

}