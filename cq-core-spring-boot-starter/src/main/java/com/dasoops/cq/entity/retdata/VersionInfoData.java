package com.dasoops.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: VersionInfoData
 * @ClassPath com.dasoops.cq.entity.retdata.VersionInfoData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 版本信息数据
 */
@Data
public class VersionInfoData {

    @JSONField(name = "coolq_directory")
    private String coolqDirectory;

    @JSONField(name = "coolq_edition")
    private String coolqEdition;

    @JSONField(name = "plugin_version")
    private String pluginVersion;

    @JSONField(name = "plugin_build_number")
    private long pluginBuildNumber;

    @JSONField(name = "plugin_build_configuration")
    private String pluginBuildConfiguration;

}
