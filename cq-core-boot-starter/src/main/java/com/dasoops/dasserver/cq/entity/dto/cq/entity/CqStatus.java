package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title CqStatus
 * @classPath com.dasoops.dasserver.cq.entity.entity.CqStatus
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq状态
 */
@Data
public class CqStatus {
    @JSONField(name = "app_initialized")
    private boolean appInitialized;
    @JSONField(name = "app_enabled")
    private boolean appEnabled;
    @JSONField(name = "plugins_good")
    private JSONObject pluginsGood;
    @JSONField(name = "app_good")
    private boolean appGood;
    @JSONField(name = "online")
    private boolean online;
    @JSONField(name = "good")
    private boolean good;
}
