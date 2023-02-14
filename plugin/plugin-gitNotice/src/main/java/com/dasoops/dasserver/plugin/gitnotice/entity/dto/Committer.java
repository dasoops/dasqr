package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: Committer
 * @classPath com.dasoops.dasq.core.git.entity.Committer
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/13
 * @version 1.0.0
 * @description 提交者
 */
@Data
public class Committer {
    private String name;
    private String email;
    private String username;
    @JSONField(name = "user_name")
    private String userName;
    private String url;

}