package com.dasoops.dasq.core.dq.methodstrategy.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: getMsgDto
 * @ClassPath com.dasoops.dasq.core.dq.methodstrategy.entity.getMsgDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/19
 * @Version 1.0.0
 * @Description: 得到dto
 */
@Data
public class GetMsgDto {
    @JSONField(name = "data")
    private MsgData msgData;
    private int retcode;
    private String status;
}