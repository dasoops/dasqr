package com.dasoops.dasq.core.cq.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Title: Data
 * @ClassPath com.dasoops.dasq.core.cq.entity.pojo.Data
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 数据
 */
@Data
public class CqResData {
    @JSONField(name = "message_id")
    private Long messageId;

}