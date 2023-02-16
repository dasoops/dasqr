package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title CredentialsData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.CredentialsData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 凭证数据
 */
@Data
public class CredentialsData {
    @JSONField(name = "cookies")
    private String cookies;

    @JSONField(name = "csrf_token")
    private int csrfToken;
}
