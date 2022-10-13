package com.dasoops.dasq.core.cq.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Title: CqRes
 * @ClassPath com.dasoops.dasq.core.cq.entity.pojo.CqRes
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq res
 */
@Data
public class CqRes {
    @JSONField(name = "data")
    private CqResData data;
    @JSONField(name = "retcode")
    private Integer retCode;
    private String msg;
    private String status;
    private String wording;
}



