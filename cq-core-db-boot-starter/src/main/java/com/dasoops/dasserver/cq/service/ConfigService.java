package com.dasoops.dasserver.cq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum;

import java.util.Optional;

/**
 * @title ConfigService
 * @classPath com.dasoops.dasserver.cq.service.ConfigService
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_config(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service
 * @see IService
 */
public interface ConfigService {

    /**
     * 初始化配置
     */
    void initOrUpdateConfig();

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

    /**
     * 初始化或更新快速失败图片
     */
    void initOrUpdateFastFailImage();

    /**
     * 设置配置
     *
     * @param redisHashKeyEnum 复述,散列值枚举
     * @param value            值
     */
    void setConfig(IRedisHashKeyEnum redisHashKeyEnum, String value);
}
