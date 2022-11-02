package com.dasoops.dasserver.cq.entity.retdata;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: ApiRawData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.ApiRawData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: api原始数据
 */
@Data
public class ApiRawData {
    @JSONField(name = "status")
    private String status;

    @JSONField(name = "retcode")
    private int retcode;

    @JSONField(name = "data")
    private JSONObject data;
}
