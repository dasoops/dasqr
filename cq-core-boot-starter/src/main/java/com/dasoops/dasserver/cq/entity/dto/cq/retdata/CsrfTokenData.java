package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title CsrfTokenData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.CsrfTokenData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description csrfToken数据
 */
@Data
public class CsrfTokenData {
    @JSONField(name = "token")
    private int token;
}
