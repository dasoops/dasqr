package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: Owner
 * @ClassPath com.dasoops.dasq.core.git.entity.Owner
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description: 老板
 */
@Data
public class Owner {
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