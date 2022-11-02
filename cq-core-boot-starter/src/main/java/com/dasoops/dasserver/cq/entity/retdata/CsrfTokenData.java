package com.dasoops.dasserver.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CsrfTokenData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.CsrfTokenData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: csrfToken数据
 */
@Data
public class CsrfTokenData {
    @JSONField(name = "token")
    private int token;
}
