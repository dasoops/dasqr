package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: BooleanData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.BooleanData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description boolean数据
 */
@Data
public class BooleanData {
    @JSONField(name = "yes")
    private boolean yes;
}
