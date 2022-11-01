package com.dasoops.cq.entity.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqGroupUser
 * @ClassPath com.dasoops.cq.entity.entity.CqGroupUser
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq集团用户
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
