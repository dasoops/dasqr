package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: ApiData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.ApiData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description api数据
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiData<T> extends BaseApiData {

    @JSONField(name = "data")
    private T data;
}
