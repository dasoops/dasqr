package com.dasoops.dasserver.plugin.gitnotice.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @title: Author
 * @classPath com.dasoops.dasq.core.git.entity.Author
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/13
 * @version 1.0.0
 * @description 作者
 */
@Data
public class Author {
    private Date time;
    private String name;
    private String email;
    private String username;
    @JSONField(name = "user_name")
    private String userName;
    private String url;

}