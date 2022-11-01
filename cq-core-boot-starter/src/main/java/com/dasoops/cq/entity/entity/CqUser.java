package com.dasoops.cq.entity.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CqUser
 * @ClassPath com.dasoops.cq.entity.entity.CqUser
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq用户
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
