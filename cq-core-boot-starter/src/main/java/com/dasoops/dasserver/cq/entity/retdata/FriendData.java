package com.dasoops.dasserver.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: FriendData
 * @ClassPath com.dasoops.dasserver.cq.entity.retdata.FriendData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 朋友数据
 */
@Data
public class FriendData {
    @JSONField(name="user_id")
    private long userId;

    @JSONField(name = "nickname")
    private String nickname;

    @JSONField(name = "remark")
    private String remark;
}
