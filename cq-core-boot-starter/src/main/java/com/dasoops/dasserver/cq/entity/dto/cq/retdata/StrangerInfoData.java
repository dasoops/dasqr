package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: StrangerInfoData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.StrangerInfoData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 陌生人信息数据
 */
@Data
public class StrangerInfoData {
    @JSONField(name = "user_id")
    private long userId;

    @JSONField(name = "nickname")
    private String nickname;

    @JSONField(name = "sex")
    private String sex;

    @JSONField(name = "age")
    private int age;
}
