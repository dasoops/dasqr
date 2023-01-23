package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ApiRawData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.ApiRawData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: api原始数据
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiRawData extends BaseApiData {

    @JSONField(name = "data")
    private JSONObject data;

}
