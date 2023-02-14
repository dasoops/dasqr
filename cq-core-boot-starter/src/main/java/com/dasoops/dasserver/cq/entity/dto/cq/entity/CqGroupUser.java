package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CqGroupUser
 * @classPath com.dasoops.dasserver.cq.entity.entity.CqGroupUser
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq集团用户
 * @see CqUser
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupUser extends CqUser {
    @JSONField(name = "card")
    private String card;
    @JSONField(name = "area")
    private String area;
    @JSONField(name = "level")
    private String level;
    @JSONField(name = "role")
    private String role;
    @JSONField(name = "title")
    private String title;
}
