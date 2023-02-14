package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: FriendData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.FriendData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 朋友数据
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
