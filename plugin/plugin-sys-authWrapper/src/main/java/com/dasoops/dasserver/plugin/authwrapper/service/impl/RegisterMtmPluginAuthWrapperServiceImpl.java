package com.dasoops.dasserver.plugin.authwrapper.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.dasoops.dasserver.cq.mapper.RegisterMtmPluginMapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.cq.util.RegisterMtmPluginUtil;
import com.dasoops.dasserver.plugin.authwrapper.service.RegisterMtmPluginAuthWrapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: RegisterMtmPluginAuthWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.service.impl.RegisterMtmPluginAuthWrapperImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册mtm插件身份验证条件构造器impl
 * @see RegisterMtmPluginAuthWrapperService
 */
@Service
public class RegisterMtmPluginAuthWrapperServiceImpl extends ServiceImpl<RegisterMtmPluginMapper, RegisterMtmPluginDo>
        implements RegisterMtmPluginAuthWrapperService {

    private final RegisterService registerService;
    private final PluginService pluginService;

    public RegisterMtmPluginAuthWrapperServiceImpl(RegisterService registerService, PluginService pluginService) {
        this.registerService = registerService;
        this.pluginService = pluginService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void initOrUpdateRegisterMtmPluginList() {

        List<RegisterMtmPluginDo> noExistRegisterMtmPluginDoList = new ArrayList<>();

        List<RegisterMtmPluginDo> registerMtmPluginDoAllList = super.list();
        List<RegisterDo> registerDoList = registerService.list();
        List<PluginDo> pluginDoList = pluginService.list();

        //补全缺少记录
        //按注册用户分组
        Map<Long, List<RegisterMtmPluginDo>> groupByRegisterIdMap = registerMtmPluginDoAllList.stream().collect(Collectors.groupingBy(RegisterMtmPluginDo::getRegisterRowId));

        registerDoList.forEach(registerDo -> {
            List<RegisterMtmPluginDo> registerMtmPluginDoList = groupByRegisterIdMap.get(registerDo.getId());
            if (CollectionUtil.isEmpty(registerMtmPluginDoList)) {
                //全空,全补全
                noExistRegisterMtmPluginDoList.addAll(
                        pluginDoList.stream().map(pluginDo -> RegisterMtmPluginUtil.buildNewRegisterMtmPluginDo(registerDo, pluginDo)).toList()
                );
            } else {
                //缺多少补多少
                pluginDoList.forEach(pluginDo -> {
                    //是否有记录
                    boolean isExist = registerMtmPluginDoList.stream().anyMatch(mtmDo ->
                            mtmDo.getPluginId().equals(pluginDo.getId())
                    );
                    if (!isExist) {
                        noExistRegisterMtmPluginDoList.add(
                                RegisterMtmPluginUtil.buildNewRegisterMtmPluginDo(registerDo, pluginDo)
                        );
                    }
                });
            }
        });

        //持久化
        this.saveBatch(noExistRegisterMtmPluginDoList);

        //是否有未删除数据
        if (registerMtmPluginDoAllList.size() + noExistRegisterMtmPluginDoList.size() == registerDoList.size() * pluginDoList.size()) {
            return;
        }

        List<RegisterMtmPluginDo> registerMtmPluginDoAllNewList = super.list();

        //删除多余数据
        List<Long> superfluousIdList = new ArrayList<>();

        List<Long> pluginIdList = pluginDoList.stream().map(PluginDo::getId).toList();
        List<Long> registerIdList = registerDoList.stream().map(RegisterDo::getId).toList();

        //有插件/注册用户不存在(被删除)的即为多余数据
        for (RegisterMtmPluginDo mtmDo : registerMtmPluginDoAllNewList) {
            boolean isSuperfluous = !pluginIdList.contains(mtmDo.getPluginId()) || !registerIdList.contains(mtmDo.getRegisterRowId());
            if (isSuperfluous) {
                superfluousIdList.add(mtmDo.getId());
            }
        }

        this.removeBatchByIds(superfluousIdList);
    }
}
