package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: CqUser
 * @classPath com.dasoops.dasserver.cq.entity.entity.CqUser
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq用户
 */
@Data
public class CqUser {
    @JSONField(name = "user_id")
    private long userId;
    @JSONField(name = "nickname")
    private String nickname;
    @JSONField(name = "sex")
    private String sex;
    @JSONField(name = "age")
    private int age;
}
