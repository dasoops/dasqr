package com.dasoops.dasserver.plugin.webmanager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.param.base.SortDataParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.QueryWrapperUtil;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.SortPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportPluginDto;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.GetPluginSortColumnEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerExceptionEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.param.DeletePluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.EditPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginSortVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginVo;
import com.dasoops.dasserver.plugin.webmanager.mapper.PluginWebMapper;
import com.dasoops.dasserver.plugin.webmanager.service.PluginWebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: PluginServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.PluginServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_plugin(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Service实现
 * @see ServiceImpl
 * @see PluginService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PluginWebServiceImpl extends ServiceImpl<PluginWebMapper, PluginDo>
        implements PluginWebService {

    private final PluginWebMapper pluginWebMapper;

    @Override
    public IPage<GetPluginVo> getPluginPageData(GetPluginPageParam param) {
        Assert.getInstance().allMustNotNull(param);
        QueryWrapper<PluginDo> wrapper = param.buildWrapper();
        List<SortDataParam<PluginDo>> sortDataParamList = param.getSortDataParamList();
        QueryWrapperUtil.addSortParam(wrapper, sortDataParamList, GetPluginSortColumnEnum.class);

        IPage<PluginDo> page = super.page(param.buildSelectPage(), wrapper);
        IPage<GetPluginVo> getPluginVoPage = page.convert(pluginDo -> {
            GetPluginVo getPluginVo = new GetPluginVo();
            BeanUtil.copyProperties(pluginDo, getPluginVo);
            getPluginVo.setPluginName(StrUtil.format("{}({})", pluginDo.getName(), pluginDo.getDescription()));
            return getPluginVo;
        });

        return getPluginVoPage;
    }

    @Override
    public void editPlugin(EditPluginParam param) {
        Assert.getInstance().allMustNotNull(param, param.getName(), param.getEnable(), param.getDescription(), param.getClassPath(), param.getLevel(), param.getRowId());

        String classPath = param.getClassPath();
        try {
            Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_CLASS_PATH);
        }

        Long rowId = param.getRowId();
        PluginDo byId = super.getById(rowId);
        if (byId == null) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_ID);
        }

        PluginDo pluginDo = param.buildDo();
        super.updateById(pluginDo);
    }

    @Override
    public GetNextIdVo getNextId() {
        Long id = pluginWebMapper.selectMaxId() + 1;
        GetNextIdVo getNextIdVo = new GetNextIdVo();
        getNextIdVo.setRowId(id);
        return getNextIdVo;
    }

    @Override
    public void addPlugin(AddPluginParam param) {

    }

    @Override
    public void deletePlugin(DeletePluginParam param) {

    }

    @Override
    public List<ExportPluginDto> exportAllPlugin() {
        return null;
    }

    @Override
    public void sortPlugin(SortPluginParam param) {

    }

    @Override
    public GetPluginSortVo getSortPlugin() {
        return null;
    }
}