package com.dasoops.dasserver.plugin.webmanager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.cq.entity.enums.ConfigCanEditEnum;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportConfigDto;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerExceptionEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.param.AddConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.DeleteConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.EditConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.GetConfigPageParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetConfigVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.mapper.ConfigWebMapper;
import com.dasoops.dasserver.plugin.webmanager.service.ConfigWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
@RequiredArgsConstructor
public class ConfigWebServiceImpl extends ServiceImpl<ConfigWebMapper, ConfigDo>
        implements ConfigWebService {

    private final ConfigWebMapper configWebMapper;
    private final ConfigService configService;

    @Override
    public IPage<GetConfigVo> getConfigPageData(GetConfigPageParam param) {
        Assert.getInstance().allMustNotNull(param);
        String keyword = param.getKeyword();
        String description = param.getDescription();

        IPage<GetConfigVo> page = super.lambdaQuery()
                .like(keyword != null && !"".equals(keyword), ConfigDo::getKeyword, keyword)
                .like(description != null && !"".equals(description), ConfigDo::getDescription, description)
                .page(param.buildSelectPage())
                .convert(configDo -> {
                    GetConfigVo getConfigVo = new GetConfigVo();
                    getConfigVo.setRowId(configDo.getRowId());
                    BeanUtil.copyProperties(configDo, getConfigVo);
                    return getConfigVo;
                });

        return page;
    }

    @Override
    public void editConfig(EditConfigParam param) {
        Assert.getInstance().allMustNotNull(param, param.getKeyword(), param.getValue(), param.getDescription());

        String keyword = param.getKeyword();
        Long rowId = param.getRowId();

        //不同id是否有相同关键字
        Long count = super.lambdaQuery().eq(ConfigDo::getKeyword, keyword).ne(ConfigDo::getRowId, rowId).count();
        if (count > 0) {
            throw new LogicException(WebManagerExceptionEnum.REPEAT_KEYWORD);
        }

        ConfigDo oldConfigDo = super.lambdaQuery().eq(ConfigDo::getRowId, rowId).one();
        if (oldConfigDo == null) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_ID);
        }
        if (oldConfigDo.getCanEdit().equals(ConfigCanEditEnum.FALSE.getDbValue())) {
            throw new LogicException(WebManagerExceptionEnum.CANT_EDIT);
        }

        String value = param.getValue();
        ConfigDo newConfigDo = new ConfigDo();
        newConfigDo.setRowId(rowId);
        newConfigDo.setKeyword(keyword);
        newConfigDo.setValue(value);
        newConfigDo.setDescription(param.getDescription());

        super.updateById(newConfigDo);
        configService.initOrUpdateConfig();
    }

    @Override
    public GetNextIdVo getNextId() {
        Long id = configWebMapper.selectMaxId() + 1;
        GetNextIdVo getNextIdVo = new GetNextIdVo();
        getNextIdVo.setRowId(id);
        return getNextIdVo;
    }

    @Override
    public void addConfig(AddConfigParam param) {
        Assert.getInstance().allMustNotNull(param, param.getKeyword(), param.getValue(), param.getDescription(), param.getCanEdit());

        String keyword = param.getKeyword();
        Long count = super.lambdaQuery().eq(ConfigDo::getKeyword, keyword).count();
        if (count > 0) {
            throw new LogicException(WebManagerExceptionEnum.REPEAT_KEYWORD);
        }

        Integer canEdit = param.getCanEdit();
        if (!canEdit.equals(ConfigCanEditEnum.FALSE.getDbValue()) && !canEdit.equals(ConfigCanEditEnum.TRUE.getDbValue())) {
            throw new LogicException(ExceptionEnum.PARAMETER_OUT_OF_SCOPE);
        }

        ConfigDo configDo = new ConfigDo();
        configDo.setKeyword(keyword);
        configDo.setCanEdit(canEdit);
        configDo.setValue(param.getValue());
        configDo.setDescription(param.getDescription());

        super.save(configDo);
        configService.initOrUpdateConfig();
    }

    @Override
    public void deleteConfig(DeleteConfigParam param) {
        Assert.getInstance().allMustNotNull(param, param.getRowId());

        Long id = param.getRowId();
        ConfigDo configDo = super.getById(id);
        if (configDo == null) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_ID);
        }

        if (configDo.getCanEdit().equals(ConfigCanEditEnum.FALSE.getDbValue())) {
            throw new LogicException(WebManagerExceptionEnum.CANT_EDIT);
        }

        super.removeById(id);
        configService.initOrUpdateConfig();
    }

    @Override
    public List<ExportConfigDto> exportAllConfig() {
        List<ConfigDo> doList = super.list();
        List<ExportConfigDto> resList = doList.stream().map(configDo -> {
            ExportConfigDto dto = new ExportConfigDto();
            dto.setRowId(configDo.getRowId());
            dto.setKeyword(configDo.getKeyword());
            dto.setValue(configDo.getValue());
            dto.setDescription(configDo.getDescription());
            dto.setCanEdit(configDo.getCanEdit().equals(ConfigCanEditEnum.TRUE.getDbValue()));
            return dto;
        }).collect(Collectors.toList());

        return resList;
    }
}