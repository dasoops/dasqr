package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title GroupData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.GroupData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 组数据
 */
@Data
public class GroupData {
    @JSONField(name = "group_id")
    private long groupId;

    @JSONField(name = "group_name")
    private String groupName;
}
