package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: BooleanData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.BooleanData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: boolean数据
 */
@Data
public class BooleanData {
    @JSONField(name = "yes")
    private boolean yes;
}
