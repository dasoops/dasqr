package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @title Commits
 * @classPath com.dasoops.dasq.core.git.entity.Commits
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/13
 * @version 1.0.0
 * @description 提交
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