package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: LoginInfoData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.LoginInfoData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 登录信息数据
 */
@Data
public class LoginInfoData {
    @JSONField(name = "user_id")
    private long userId;

    @JSONField(name = "nickname")
    private String nickname;
}
