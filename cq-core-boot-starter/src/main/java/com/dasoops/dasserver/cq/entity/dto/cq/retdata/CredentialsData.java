package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CredentialsData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.CredentialsData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 凭证数据
 */
@Data
public class CredentialsData {
    @JSONField(name = "cookies")
    private String cookies;

    @JSONField(name = "csrf_token")
    private int csrfToken;
}
