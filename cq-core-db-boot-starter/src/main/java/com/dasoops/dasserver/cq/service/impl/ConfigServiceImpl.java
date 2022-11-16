package com.dasoops.dasserver.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.ExceptionUtil;
import com.dasoops.dasserver.cq.entity.enums.ConfigEnum;
import com.dasoops.dasserver.cq.entity.po.ConfigPo;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.cq.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Title: ConfigServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.ConfigServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_CONFIG(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service实现
 * @see ServiceImpl
 * @see ConfigService
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigPo>
        implements ConfigService {

    @Override
    public String getConfig(ConfigEnum config) {
        //获取配置对象
        Optional<ConfigPo> configPoOpt = this.lambdaQuery().eq(ConfigPo::getKeyword, config.getKey()).oneOpt();
        if (configPoOpt.isEmpty()) {
            ExceptionUtil.buildDbExecuteReturnNotNull();
        }
        return configPoOpt.get().getValue();
    }

    @Override
    public Integer updateVersion(Integer addVersion) {
        //获取版本号对象,获取版本号,增加后更新
        int version = Integer.parseInt(getConfig(ConfigEnum.VERSION));
        int endVersion = version + addVersion;
        Assert.ifTrue(super.lambdaUpdate().eq(ConfigPo::getKeyword, ConfigEnum.VERSION.getKey()).set(ConfigPo::getValue, endVersion).update(), ExceptionUtil::buildDbExecuteReturnNotFalse);
        return endVersion;
    }

}