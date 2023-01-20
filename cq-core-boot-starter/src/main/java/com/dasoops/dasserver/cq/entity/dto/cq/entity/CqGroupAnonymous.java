package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CqGroupAnonymous
 * @ClassPath com.dasoops.dasserver.cq.entity.entity.CqGroupAnonymous
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq组匿名
 */
@Data
public class CqGroupAnonymous {
    @JSONField(name = "id")
    private long id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "flag")
    private String flag;
}