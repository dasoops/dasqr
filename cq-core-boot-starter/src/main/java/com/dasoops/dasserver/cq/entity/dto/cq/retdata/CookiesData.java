package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CookiesData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.CookiesData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cookie数据
 */
@Data
public class CookiesData {
    @JSONField(name = "cookies")
    private String cookies;
}
