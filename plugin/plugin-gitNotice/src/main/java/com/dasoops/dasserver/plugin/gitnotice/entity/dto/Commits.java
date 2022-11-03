package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Title: Commits
 * @ClassPath com.dasoops.dasq.core.git.entity.Commits
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description: 提交
 */
@Data
public class Commits {
    private String id;
    @JSONField(name = "tree_id")
    private String treeId;
    private boolean distinct;
    private String message;
    private Date timestamp;
    private String url;
    private Author author;
    private Committer committer;
    private String added;
    private String removed;
    private List<String> modified;

}