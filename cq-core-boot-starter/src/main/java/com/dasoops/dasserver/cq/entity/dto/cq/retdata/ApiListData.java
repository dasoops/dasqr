package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: ApiListData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.ApiListData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: api集合数据
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiListData<T> extends BaseApiData {

    @JSONField(name = "data")
    private List<T> data;
}
