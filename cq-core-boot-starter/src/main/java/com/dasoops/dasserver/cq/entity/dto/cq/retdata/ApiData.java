package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ApiData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.ApiData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: api数据
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiData<T> extends BaseApiData {

    @JSONField(name = "data")
    private T data;
}
