package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: CqGroupAnonymous
 * @classPath com.dasoops.dasserver.cq.entity.entity.CqGroupAnonymous
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq组匿名
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