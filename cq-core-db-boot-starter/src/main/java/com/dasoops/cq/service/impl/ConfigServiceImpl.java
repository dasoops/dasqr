package com.dasoops.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.cq.entity.enums.ConfigEnum;
import com.dasoops.cq.entity.po.ConfigPo;
import com.dasoops.cq.service.ConfigService;
import com.dasoops.cq.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Title: ConfigServiceImpl
 * @ClassPath com.dasoops.cq.service.impl.ConfigServiceImpl
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
    public Optional<String> getConfig(ConfigEnum config) {
        //获取配置对象
        Optional<ConfigPo> configPoOpt = this.lambdaQuery().eq(ConfigPo::getKeyword, config.getName()).oneOpt();
        if (configPoOpt.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(configPoOpt.get().getValue());
    }

    @Override
    public boolean updateVersion(Integer version) {
        //获取版本号对象,获取版本号,增加后更新
        return getConfig(ConfigEnum.VERSION).map(
                verStr -> super.lambdaUpdate().eq(ConfigPo::getKeyword, ConfigEnum.VERSION.getName()).set(ConfigPo::getValue, Integer.parseInt(verStr) + version).update()
        ).orElse(false);
    }

}