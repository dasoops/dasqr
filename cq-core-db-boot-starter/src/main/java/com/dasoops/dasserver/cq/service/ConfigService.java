package com.dasoops.dasserver.cq.service;

import com.dasoops.dasserver.cq.entity.enums.ConfigEnum;
import com.dasoops.dasserver.cq.entity.po.ConfigPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
 * @Title: ConfigService
 * @ClassPath com.dasoops.dasserver.cq.service.ConfigService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_CONFIG(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service
 * @see IService
 */
public interface ConfigService extends IService<ConfigPo> {

    /**
     * 获取配置
     *
     * @param config 配置
     * @return {@link Optional}<{@link String}>
     */
    String getConfig(ConfigEnum config);

    /**
     * 更新版本
     *
     * @param version 版本
     * @return boolean 是否成功
     */
    Integer updateVersion(Integer version);

}
