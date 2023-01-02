package com.dasoops.dasserver.plugin.webManager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.WebLogicException;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.cq.entity.enums.ConfigCanEditEnum;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.plugin.webManager.entity.dto.ExportConfigDto;
import com.dasoops.dasserver.plugin.webManager.entity.enums.ConfigExceptionEnum;
import com.dasoops.dasserver.plugin.webManager.entity.param.AddConfigParam;
import com.dasoops.dasserver.plugin.webManager.entity.param.DeleteConfigParam;
import com.dasoops.dasserver.plugin.webManager.entity.param.EditConfigParam;
import com.dasoops.dasserver.plugin.webManager.entity.param.GetConfigPageParam;
import com.dasoops.dasserver.plugin.webManager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webManager.mapper.ConfigWebMapper;
import com.dasoops.dasserver.plugin.webManager.service.ConfigWebService;
import com.dasoops.dasserver.plugin.webManager.util.WebAssert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
public class ConfigWebServiceImpl extends ServiceImpl<ConfigWebMapper, ConfigDo>
        implements ConfigWebService {

    private final ConfigWebMapper configWebMapper;
    private final ConfigCache configCache;

    @SuppressWarnings("all")
    public ConfigWebServiceImpl(ConfigWebMapper configWebMapper, ConfigCache configCache) {
        this.configWebMapper = configWebMapper;
        this.configCache = configCache;
    }

    @Override
    public IPage<ConfigDo> getConfigPageData(GetConfigPageParam param) {
        WebAssert.allMustNotNull(param);
        String keyword = param.getKeyword();
        String description = param.getDescription();

        IPage<ConfigDo> page = super.lambdaQuery()
                .like(keyword != null && !"".equals(keyword), ConfigDo::getKeyword, keyword)
                .like(description != null && !"".equals(description), ConfigDo::getDescription, description)
                .page(param.buildSelectPage());

        return page;
    }

    @Override
    public void editConfig(EditConfigParam param) {
        WebAssert.allMustNotNull(param, param.getKeyword(), param.getValue(), param.getDescription());

        String keyword = param.getKeyword();
        Long id = param.getId();

        //不同id是否有相同关键字
        Long count = super.lambdaQuery().eq(ConfigDo::getKeyword, keyword).ne(ConfigDo::getId, id).count();
        if (count > 0) {
            throw new WebLogicException(ConfigExceptionEnum.REPEAT_KEYWORD);
        }

        ConfigDo oldConfigDo = super.lambdaQuery().eq(ConfigDo::getId, id).one();
        if (oldConfigDo == null) {
            throw new WebLogicException(ConfigExceptionEnum.UNDEFINED_ID);
        }
        if (oldConfigDo.getCanEdit().equals(ConfigCanEditEnum.FALSE.getDbValue())) {
            throw new WebLogicException(ConfigExceptionEnum.CANT_EDIT);
        }

        ConfigDo newConfigDo = new ConfigDo();
        newConfigDo.setId(id);
        newConfigDo.setKeyword(keyword);
        newConfigDo.setValue(param.getValue());
        newConfigDo.setDescription(param.getDescription());

        super.updateById(newConfigDo);
        configCache.initOrUpdate();
    }

    @Override
    public GetNextIdVo getNextId() {
        Long id = configWebMapper.selectMaxId() + 1;
        GetNextIdVo getNextIdVo = new GetNextIdVo();
        getNextIdVo.setId(id);
        return getNextIdVo;
    }

    @Override
    public void addConfig(AddConfigParam param) {
        WebAssert.allMustNotNull(param, param.getKeyword(), param.getValue(), param.getDescription(), param.getCanEdit());

        String keyword = param.getKeyword();
        Long count = super.lambdaQuery().eq(ConfigDo::getKeyword, keyword).count();
        if (count > 0) {
            throw new WebLogicException(ConfigExceptionEnum.REPEAT_KEYWORD);
        }

        Integer canEdit = param.getCanEdit();
        if (!canEdit.equals(ConfigCanEditEnum.FALSE.getDbValue()) && !canEdit.equals(ConfigCanEditEnum.TRUE.getDbValue())) {
            throw new WebLogicException(ExceptionEnum.PARAMETER_OUT_OF_SCOPE);
        }

        ConfigDo configDo = new ConfigDo();
        configDo.setKeyword(keyword);
        configDo.setCanEdit(canEdit);
        configDo.setValue(param.getValue());
        configDo.setDescription(param.getDescription());

        super.save(configDo);
        configCache.initOrUpdate();
    }

    @Override
    public void deleteConfig(DeleteConfigParam param) {
        WebAssert.allMustNotNull(param, param.getId());

        Long id = param.getId();
        ConfigDo configDo = super.getById(id);
        if (configDo == null) {
            throw new WebLogicException(ConfigExceptionEnum.UNDEFINED_ID);
        }

        if (configDo.getCanEdit().equals(ConfigCanEditEnum.FALSE.getDbValue())) {
            throw new WebLogicException(ConfigExceptionEnum.CANT_EDIT);
        }

        super.removeById(id);
        configCache.initOrUpdate();
    }

    @Override
    public List<ExportConfigDto> exportAllConfig() {
        List<ConfigDo> doList = super.list();
        List<ExportConfigDto> resList = doList.stream().map(configDo -> {
            ExportConfigDto dto = new ExportConfigDto();
            dto.setId(configDo.getId());
            dto.setKeyword(configDo.getKeyword());
            dto.setValue(configDo.getValue());
            dto.setDescription(configDo.getDescription());
            dto.setCanEdit(configDo.getCanEdit().equals(ConfigCanEditEnum.TRUE.getDbValue()));
            return dto;
        }).collect(Collectors.toList());

        return resList;
    }
}