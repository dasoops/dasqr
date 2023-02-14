package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: CookiesData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.CookiesData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cookie数据
 */
@Data
public class CookiesData {
    @JSONField(name = "cookies")
    private String cookies;
}
