package com.dasoops.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: GroupData
 * @ClassPath com.dasoops.cq.entity.retdata.GroupData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 组数据
 */
@Data
public class GroupData {
    @JSONField(name = "group_id")
    private long groupId;

    @JSONField(name = "group_name")
    private String groupName;
}
