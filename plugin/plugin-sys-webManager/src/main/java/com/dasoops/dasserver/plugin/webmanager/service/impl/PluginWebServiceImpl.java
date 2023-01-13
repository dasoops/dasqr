package com.dasoops.dasserver.plugin.webmanager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.SortRuleEnum;
import com.dasoops.common.entity.param.base.SortDataParam;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.GetPluginSortColumnEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginSortVo;
import com.dasoops.dasserver.plugin.webmanager.entity.SortPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportPluginDto;
import com.dasoops.dasserver.plugin.webmanager.entity.param.DeletePluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.EditPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginVo;
import com.dasoops.dasserver.plugin.webmanager.mapper.PluginWebMapper;
import com.dasoops.dasserver.plugin.webmanager.service.PluginWebService;
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
public class PluginWebServiceImpl extends ServiceImpl<PluginWebMapper, PluginDo>
        implements PluginWebService {

    @Override
    public IPage<GetPluginVo> getPluginPageData(GetPluginPageParam param) {
        Assert.getInstance().allMustNotNull(param);
        SortDataParam sortDataParam = param.getSortDataParam();
        SortRuleEnum sortRuleEnum = sortDataParam.buildRuleEnum();
        GetPluginSortColumnEnum columnEnum = sortDataParam.buildColumnEnum(GetPluginSortColumnEnum.class);
        

        return null;
    }

    @Override
    public void editPlugin(EditPluginParam param) {

    }

    @Override
    public GetNextIdVo getNextId() {
        return null;
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