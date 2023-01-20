package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: LoginInfoData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.LoginInfoData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 登录信息数据
 */
@Data
public class LoginInfoData {
    @JSONField(name = "user_id")
    private long userId;

    @JSONField(name = "nickname")
    private String nickname;
}
