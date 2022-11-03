package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Title: Repository
 * @ClassPath com.dasoops.dasq.core.git.entity.Repository
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/17
 * @Version 1.0.0
 * @Description:
 */
@Data
public class Repository {
    private int id;
    private String name;
    private String path;
    @JSONField(name = "full_name")
    private String fullName;
    private Owner owner;
    @JSONField(name = "private")
    private boolean pri;
    @JSONField(name = "html_url")
    private String htmlUrl;
    private String url;
    private String description;
    private boolean fork;
    @JSONField(name = "created_at")
    private Date createdAt;
    @JSONField(name = "updated_at")
    private Date updatedAt;
    @JSONField(name = "pushed_at")
    private Date pushedAt;
    @JSONField(name = "git_url")
    private String gitUrl;
    @JSONField(name = "ssh_url")
    private String sshUrl;
    @JSONField(name = "clone_url")
    private String cloneUrl;
    @JSONField(name = "svn_url")
    private String svnUrl;
    @JSONField(name = "git_http_url")
    private String gitHttpUrl;
    @JSONField(name = "git_ssh_url")
    private String gitSshUrl;
    @JSONField(name = "git_svn_url")
    private String gitSvnUrl;
    private String homepage;
    @JSONField(name = "stargazers_count")
    private int stargazersCount;
    @JSONField(name = "watchers_count")
    private int watchersCount;
    @JSONField(name = "forks_count")
    private int forksCount;
    private String language;
    @JSONField(name = "has_issues")
    private boolean hasIssues;
    @JSONField(name = "has_wiki")
    private boolean hasWiki;
    @JSONField(name = "has_pages")
    private boolean hasPages;
    private String license;
    @JSONField(name = "open_issues_count")
    private int openIssuesCount;
    @JSONField(name = "default_branch")
    private String defaultBranch;
    private String namespace;
    @JSONField(name = "name_with_namespace")
    private String nameWithNamespace;
    @JSONField(name = "path_with_namespace")
    private String pathWithNamespace;

}