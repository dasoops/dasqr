package com.dasoops.dasserver.plugin.webmanager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.param.SortParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.QueryWrapperUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqPluginGlobal;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.dto.PluginStatusDto;
import com.dasoops.dasserver.cq.entity.enums.PluginStatusEnum;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportPluginDto;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.SortPluginInnerParam;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.CheckPluginRepeatEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.GetPluginSortColumnEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerExceptionEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.param.CheckPluginClassPathParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.DeletePluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.EditPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageSortParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginSortVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.PluginSortInnerVo;
import com.dasoops.dasserver.plugin.webmanager.mapper.PluginWebMapper;
import com.dasoops.dasserver.plugin.webmanager.service.PluginWebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
    private final RegisterService registerService;
    private final PluginService pluginService;
    private final ApplicationContext applicationContext;

    @Override
    public IPage<GetPluginVo> getPluginPageData(GetPluginPageSortParam param) {
        Assert.getInstance().allMustNotNull(param);
        QueryWrapper<PluginDo> wrapper = param.buildWrapper();
        List<SortParam<PluginDo>> sortParamList = param.getSortParamList();
        QueryWrapperUtil.addSortParam(wrapper, sortParamList, GetPluginSortColumnEnum.class);
        String keyword = param.getKeyword();
        if (keyword != null && !"".equals(keyword)) {
            wrapper.like("description", keyword).or().like("name", keyword);
        }

        //加载的插件
        Map<String, CqPlugin> loadPluginMap = applicationContext.getBeansOfType(CqPlugin.class);
        List<String> loadPluginClassPath = loadPluginMap.values().stream().map(cqPlugin -> cqPlugin.getClass().getName()).toList();

        List<PluginDo> pluginDoList = super.list(wrapper);
        List<GetPluginVo> getPluginVoList = new ArrayList<>(pluginDoList.stream().map(pluginDo -> {
            GetPluginVo getPluginVo = new GetPluginVo();
            BeanUtil.copyProperties(pluginDo, getPluginVo);
            boolean isLoad = loadPluginClassPath.contains(pluginDo.getClassPath());
            getPluginVo.setStatus(isLoad ? PluginStatusEnum.LOAD.getIntegerValue() : PluginStatusEnum.ENABLE_UNLOAD.getIntegerValue());
            return getPluginVo;
        }).toList());

        //过滤状态
        List<Integer> statusList = param.getStatusList();
        if (statusList != null && statusList.size() > 0) {
            getPluginVoList = new ArrayList<>(getPluginVoList.stream().filter(pluginVo -> statusList.contains(pluginVo.getStatus())).toList());
        }

        //构建返回参数
        Integer paramSize = param.getSize();
        Integer paramCurrent = param.getCurrent();
        Page<GetPluginVo> getPluginVoPage = new Page<>(paramCurrent, paramSize);

        //包含无记录加载插件 需要
        //null集合 || 空集合 需要
        boolean needNoRecord = (statusList == null || statusList.size() <= 0) || statusList.contains(PluginStatusEnum.NO_RECORD.getIntegerValue());
        //不需要 || 没有未加载插件
        List<PluginStatusDto> noRecordPluginList = pluginService.getAllNoRecordPlugin();
        if (noRecordPluginList.size() <= 0 || !needNoRecord) {
            getPluginVoPage.setTotal(getPluginVoList.size());
            getPluginVoPage.setRecords(getPluginVoList.subList((paramCurrent - 1) * paramSize, Math.min(paramCurrent * paramSize, getPluginVoList.size())));
            return getPluginVoPage;
        }

        //添加未加载插件
        List<GetPluginVo> noRecordPluginVoList = noRecordPluginList.stream().map(pluginDto -> {
            GetPluginVo getPluginVo = new GetPluginVo();
            BeanUtil.copyProperties(pluginDto, getPluginVo);
            return getPluginVo;
        }).toList();
        getPluginVoList.addAll(0, noRecordPluginVoList);
        getPluginVoPage.setTotal(getPluginVoList.size());
        getPluginVoPage.setRecords(getPluginVoList.subList((paramCurrent - 1) * paramSize, Math.min(paramCurrent * paramSize, getPluginVoList.size())));

        return getPluginVoPage;
    }

    @Override
    public void editPlugin(EditPluginParam param) {
        Assert.getInstance().allMustNotNull(param, param.getName(), param.getEnable(), param.getDescription(), param.getClassPath(), param.getLevel(), param.getRowId());

        //-1为未知插件,直接转添加
        if (param.getRowId().equals(-1L)) {
            AddPluginParam addPluginParam = new AddPluginParam();
            BeanUtil.copyProperties(param, addPluginParam);
            this.addPlugin(addPluginParam);
            return;
        }

        //检查类路径
        checkPluginClassPath(false, param.getClassPath());

        //检查id
        checkPluginRowId(param.getRowId());

        PluginDo pluginDo = param.buildDo();
        super.updateById(pluginDo);
        CqPluginGlobal.refresh();
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
        Assert.getInstance().allMustNotNull(param, param.getName(), param.getLevel(), param.getEnable(), param.getClassPath(), param.getDescription());
        //检查类路径
        checkPluginClassPath(true, param.getClassPath());

        Integer maxOrder = pluginWebMapper.selectMaxOrder();

        PluginDo pluginDo = param.buildDo();
        pluginDo.setOrder(maxOrder + 1);
        super.save(pluginDo);
        CqPluginGlobal.refresh();
    }

    @Override
    public void deletePlugin(DeletePluginParam param) {
        Assert.getInstance().allMustNotNull(param, param.getRowId());

        Long rowId = param.getRowId();
        PluginDo pluginDo = checkPluginRowId(rowId);

        //检查权限,需要当前用户有权限使用插件
        Integer level = pluginDo.getLevel();
        RegisterDo registerDo = registerService.lambdaQuery().eq(RegisterDo::getRegisterId, EventUtil.get().getAuthorId()).one();
        if (registerDo.getLevel() > level) {
            throw new LogicException(WebManagerExceptionEnum.NEED_HIGH_LEVEL);
        }

        super.removeById(rowId);
        CqPluginGlobal.refresh();
    }

    @Override
    public List<ExportPluginDto> exportAllPlugin() {
        List<PluginDo> list = super.list();
        return list.stream().map(pluginDo -> {
            ExportPluginDto exportPluginDto = new ExportPluginDto();
            BeanUtil.copyProperties(pluginDo, exportPluginDto);
            return exportPluginDto;
        }).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sortPlugin(com.dasoops.dasserver.plugin.webmanager.entity.param.SortPluginParam param) {
        List<SortPluginInnerParam> sortPluginParamList = param.getSortPluginParamList();
        List<Long> rowIdList = new ArrayList<>();
        List<Integer> orderList = new ArrayList<>();
        //检查是否有重复id
        sortPluginParamList.forEach(dto -> {
            Long rowId = dto.getRowId();
            if (rowIdList.contains(rowId)) {
                throw new LogicException(WebManagerExceptionEnum.REPEAT_ROW_ID);
            }

            Integer order = dto.getOrder();
            if (orderList.contains(order)) {
                throw new LogicException(WebManagerExceptionEnum.REPEAT_ORDER);
            }

            rowIdList.add(rowId);
            orderList.add(order);

        });

        if (super.list().size() < rowIdList.size()) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_ID);
        }

        List<PluginDo> pluginDoList = sortPluginParamList.stream().map(dto -> {
            PluginDo pluginDo = new PluginDo();
            pluginDo.setRowId(dto.getRowId());
            pluginDo.setOrder(dto.getOrder());
            return pluginDo;
        }).toList();

        pluginDoList.forEach(super::updateById);
        CqPluginGlobal.refresh();
    }

    @Override
    public GetPluginSortVo getSortPlugin() {
        List<PluginDo> list = super.list();
        List<PluginSortInnerVo> sortPluginDtoList = list.stream()
                .sorted(Comparator.comparingInt(PluginDo::getOrder))
                .map(pluginDo -> {
                    PluginSortInnerVo dto = new PluginSortInnerVo();
                    BeanUtil.copyProperties(pluginDo, dto);
                    return dto;
                }).toList();
        GetPluginSortVo getPluginSortVo = new GetPluginSortVo();
        getPluginSortVo.setPluginSortList(sortPluginDtoList);

        return getPluginSortVo;
    }

    @Override
    public void checkPluginClassPath(CheckPluginClassPathParam param) {
        Assert.getInstance().allMustNotNull(param, param.getClassPath(), param.getCheckRepeatClassPath());
        checkPluginClassPath(param.getCheckRepeatClassPath().equals(CheckPluginRepeatEnum.TRUE.getIntegerValue()), param.getClassPath());
    }

    /**
     * 检查插件类路径
     *
     * @param classPath            类路径
     * @param checkRepeatClassPath 检查重复类路径
     */
    private void checkPluginClassPath(boolean checkRepeatClassPath, String classPath) {
        try {
            Class<?> clazz = Class.forName(classPath);
            if (!CqPlugin.class.isAssignableFrom(clazz)) {
                throw new LogicException(WebManagerExceptionEnum.NO_CQ_PLUGIN);
            }
            if (checkRepeatClassPath) {
                Long count = super.lambdaQuery().eq(PluginDo::getClassPath, classPath).count();
                if (count > 0) {
                    throw new LogicException(WebManagerExceptionEnum.REPEAT_CLASS_PATH);
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_CLASS_PATH);
        }
    }

    /**
     * 检查插件行id
     *
     * @param rowId 行id
     */
    private PluginDo checkPluginRowId(Long rowId) {
        PluginDo byId = super.getById(rowId);
        if (byId == null) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_ID);
        }
        return byId;
    }

}