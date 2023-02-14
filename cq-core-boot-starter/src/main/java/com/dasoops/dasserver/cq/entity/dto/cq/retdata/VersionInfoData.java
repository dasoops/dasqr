package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: VersionInfoData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.VersionInfoData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 版本信息数据
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
