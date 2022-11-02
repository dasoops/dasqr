package com.dasoops.dasserver.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: GroupInfoData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.GroupInfoData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 集团信息数据
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
