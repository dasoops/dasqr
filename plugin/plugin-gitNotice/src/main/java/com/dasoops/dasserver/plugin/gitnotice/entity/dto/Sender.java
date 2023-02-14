package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: Sender
 * @classPath com.dasoops.dasq.core.git.entity.Sender
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/13
 * @version 1.0.0
 * @description 发送方
 */
@Data
public class Sender {
    private int id;
    private String login;
    @JSONField(name = "avatar_url")
    private String avatarUrl;
    @JSONField(name = "html_url")
    private String htmlUrl;
    private String type;
    @JSONField(name = "site_admin")
    private boolean siteAdmin;
    private String name;
    private String email;
    private String username;
    @JSONField(name = "user_name")
    private String userName;
    private String url;
}