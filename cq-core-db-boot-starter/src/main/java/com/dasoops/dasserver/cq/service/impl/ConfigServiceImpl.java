package com.dasoops.dasserver.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.cq.mapper.ConfigMapper;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.entity.enums.ConfigHashKeyEnum;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Title: ConfigServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.ConfigServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_config(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service实现
 * @see ServiceImpl
 * @see ConfigService
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigDo>
        implements ConfigService {

    private final ConfigCache configCache;

    public ConfigServiceImpl(ConfigCache configCache) {
        this.configCache = configCache;
    }

    @Override
    public String getConfig(ConfigHashKeyEnum config) {
        //获取配置对象
        Optional<ConfigDo> configDoOptinal = super.lambdaQuery().eq(ConfigDo::getKeyword, config.getKey()).oneOpt();
        if (configDoOptinal.isEmpty()) {
            throw new LogicException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_NULL);
        }
        return configDoOptinal.get().getValue();
    }

    @Override
    public Integer updateVersion(Integer addVersion) {
        //获取版本号对象,获取版本号,增加后更新
        int version = Integer.parseInt(getConfig(ConfigHashKeyEnum.CLOUD_VERSION));
        int endVersion = version + addVersion;
        super.lambdaUpdate().eq(ConfigDo::getKeyword, ConfigHashKeyEnum.CLOUD_VERSION.getKey()).set(ConfigDo::getValue, endVersion).update();
        configCache.setConfig(ConfigHashKeyEnum.CLOUD_VERSION, String.valueOf(endVersion));
        return endVersion;
    }

    @Override
    public void updateLocalVersionFromCloudVersion() {
        int version = Integer.parseInt(getConfig(ConfigHashKeyEnum.CLOUD_VERSION));
        super.lambdaUpdate().eq(ConfigDo::getKeyword, ConfigHashKeyEnum.LOCAL_VERSION.getKey()).set(ConfigDo::getValue, version).update();
        configCache.setConfig(ConfigHashKeyEnum.LOCAL_VERSION, String.valueOf(version));
    }

}