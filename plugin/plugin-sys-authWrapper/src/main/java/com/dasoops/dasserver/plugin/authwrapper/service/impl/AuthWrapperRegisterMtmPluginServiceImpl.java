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
import com.dasoops.dasserver.plugin.authwrapper.cache.AuthWrapperRegisterMtmPluginCache;
import com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperRegisterMtmPluginService;
import lombok.extern.slf4j.Slf4j;
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
 * @see AuthWrapperRegisterMtmPluginService
 */
@Service
@Slf4j
public class AuthWrapperRegisterMtmPluginServiceImpl extends ServiceImpl<RegisterMtmPluginMapper, RegisterMtmPluginDo>
        implements AuthWrapperRegisterMtmPluginService {

    private final RegisterService registerService;
    private final PluginService pluginService;
    private final AuthWrapperRegisterMtmPluginCache authWrapperRegisterMtmPluginCache;

    public AuthWrapperRegisterMtmPluginServiceImpl(RegisterService registerService, PluginService pluginService, AuthWrapperRegisterMtmPluginCache authWrapperRegisterMtmPluginCache) {
        this.registerService = registerService;
        this.pluginService = pluginService;
        this.authWrapperRegisterMtmPluginCache = authWrapperRegisterMtmPluginCache;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void initRegisterMtmPluginList() {
        List<RegisterMtmPluginDo> noExistRegisterMtmPluginDoList = new ArrayList<>();

        List<RegisterMtmPluginDo> registerMtmPluginDoAllList = super.list();
        List<RegisterDo> registerDoList = registerService.list();
        List<PluginDo> pluginDoList = pluginService.list();

        //补全缺少记录
        //按注册用户分组
        Map<Long, List<RegisterMtmPluginDo>> groupByRegisterIdMap = registerMtmPluginDoAllList.stream().collect(Collectors.groupingBy(RegisterMtmPluginDo::getRegisterRowId));

        registerDoList.forEach(registerDo -> {
            List<RegisterMtmPluginDo> registerMtmPluginDoList = groupByRegisterIdMap.get(registerDo.getRowId());
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
                            mtmDo.getPluginId().equals(pluginDo.getRowId())
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

        List<Long> pluginIdList = pluginDoList.stream().map(PluginDo::getRowId).toList();
        List<Long> registerIdList = registerDoList.stream().map(RegisterDo::getRowId).toList();

        //有插件/注册用户不存在(被删除)的即为多余数据
        for (RegisterMtmPluginDo mtmDo : registerMtmPluginDoAllNewList) {
            boolean isSuperfluous = !pluginIdList.contains(mtmDo.getPluginId()) || !registerIdList.contains(mtmDo.getRegisterRowId());
            if (isSuperfluous) {
                superfluousIdList.add(mtmDo.getRowId());
            }
        }

        this.removeBatchByIds(superfluousIdList);
    }

    @Override
    public void initOrUpdateAuthIdOtmIsPassMap2Cache() {
        log.info("初始化/更新 注册用户id 单对多 插件是否放行 映射集合");
        List<RegisterMtmPluginDo> registerMtmPluginDoAllList = super.list();
        //按注册角色id分组
        Map<Long, List<RegisterMtmPluginDo>> groupByRegisterIdMap = registerMtmPluginDoAllList.stream().collect(Collectors.groupingBy(RegisterMtmPluginDo::getRegisterRowId));
        //replace
        //遍历,缓存数据
        groupByRegisterIdMap.forEach((registerId, registerMtmPluginDoList) -> {
            Map<Long, Integer> pluginIdIsPassMap = registerMtmPluginDoList.stream().collect(Collectors.toMap(
                    RegisterMtmPluginDo::getPluginId,
                    RegisterMtmPluginDo::getIsPass
            ));
            authWrapperRegisterMtmPluginCache.setAuthMap(registerId, pluginIdIsPassMap);
        });
    }

}
