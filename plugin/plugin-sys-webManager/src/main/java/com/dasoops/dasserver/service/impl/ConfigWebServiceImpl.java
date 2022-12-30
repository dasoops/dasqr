package com.dasoops.dasserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.cq.entity.enums.ConfigCanEditEnum;
import com.dasoops.dasserver.cq.mapper.ConfigMapper;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.entity.enums.ConfigExceptionEnum;
import com.dasoops.dasserver.entity.param.EditConfigParam;
import com.dasoops.dasserver.entity.param.GetConfigEasyPageParam;
import com.dasoops.dasserver.service.ConfigWebService;
import org.springframework.stereotype.Service;

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
public class ConfigWebServiceImpl extends ServiceImpl<ConfigMapper, ConfigDo>
        implements ConfigWebService {

    @Override
    public IPage<ConfigDo> getConfigPageData(GetConfigEasyPageParam param) {
        Assert.allMustNotNull(param);
        String keyword = param.getKeyword();
        String description = param.getDescription();

        IPage<ConfigDo> page = super.lambdaQuery()
                .like(keyword != null && !"".equals(keyword), ConfigDo::getKeyword, keyword)
                .like(description != null && !"".equals(description), ConfigDo::getDescription, description)
                .page(param.getSelectPage(ConfigDo.class));

        return page;
    }

    @Override
    public void editConfig(EditConfigParam param) {
        Assert.allMustNotNull(param, param.getKeyword(), param.getValue(), param.getDescription());

        String keyword = param.getKeyword();
        Long id = param.getId();

        //不同id是否有相同关键字
        Long count = super.lambdaQuery().eq(ConfigDo::getKeyword, keyword).ne(ConfigDo::getId, id).count();
        if (count > 0) {
            throw new LogicException(ConfigExceptionEnum.REPEAT_KEYWORD);
        }

        ConfigDo oldConfigDo = super.lambdaQuery().eq(ConfigDo::getId, id).one();
        if (oldConfigDo == null) {
            throw new LogicException(ConfigExceptionEnum.UNDEFINED_ID);
        }
        if (oldConfigDo.getCanEdit().equals(ConfigCanEditEnum.FALSE.getDbValue())) {
            throw new LogicException(ConfigExceptionEnum.CANT_EDIT);
        }

        ConfigDo newConfigDo = new ConfigDo();
        newConfigDo.setId(id);
        newConfigDo.setKeyword(keyword);
        newConfigDo.setValue(param.getValue());
        newConfigDo.setDescription(param.getDescription());

        super.updateById(newConfigDo);
    }
}