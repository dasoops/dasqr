package com.dasoops.dasq.core.cq.entity.dto;

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
    @JsonProperty("data")
    private CqResData data;
    @JsonProperty("retcode")
    private Integer retCode;
    private String msg;
    private String status;
    private String wording;
}



