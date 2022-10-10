package com.dasoops.dasq.core.cq.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: Sender
 * @ClassPath com.dasoops.dasq.core.cq.entity.dto.Sender
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 发送方
 */
@Data
public class Sender {

    private Integer age;

    private String nickname;

    private String sex;

    @JSONField(name = "user_id")
    private Long userId;
}
