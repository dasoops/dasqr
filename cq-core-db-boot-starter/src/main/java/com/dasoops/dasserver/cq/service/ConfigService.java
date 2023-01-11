package com.dasoops.dasserver.cq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.entity.enums.ConfigHashKeyEnum;

import java.util.Optional;

/**
 * @Title: ConfigService
 * @ClassPath com.dasoops.dasserver.cq.service.ConfigService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_config(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service
 * @see IService
 */
public interface ConfigService extends IService<ConfigDo> {

    /**
     * 获取配置
     *
     * @param config 配置
     * @return {@link Optional}<{@link String}>
     */
    String getConfig(ConfigHashKeyEnum config);

    /**
     * 更新版本
     *
     * @param version 版本
     * @return boolean 是否成功
     */
    Integer updateVersion(Integer version);

    /**
     * 从云端版本号更新本地版本号
     */
    void updateLocalVersionFromCloudVersion();
}
