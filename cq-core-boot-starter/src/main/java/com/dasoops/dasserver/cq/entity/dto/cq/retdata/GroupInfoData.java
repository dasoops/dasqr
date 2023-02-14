package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: GroupInfoData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.GroupInfoData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 集团信息数据
 */
@Data
public class GroupInfoData {
    @JSONField(name = "group_id")
    private long groupId;

    @JSONField(name = "group_name")
    private String groupName;

    @JSONField(name = "member_count")
    private Integer memberCount;

    @JSONField(name = "max_member_count")
    private Integer maxMemberCount;
}
