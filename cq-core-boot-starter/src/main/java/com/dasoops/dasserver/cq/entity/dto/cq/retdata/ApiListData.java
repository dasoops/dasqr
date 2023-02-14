package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title: ApiListData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.ApiListData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description api集合数据
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiListData<T> extends BaseApiData {

    @JSONField(name = "data")
    private List<T> data;
}
