package com.dasoops.dasserver.plugin.authwrapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.mapper.PluginMapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.plugin.authwrapper.cache.AuthWrapperPluginCache;
import com.dasoops.dasserver.plugin.authwrapper.service.AuthWrapperPluginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class AuthWrapperPluginServiceImpl extends ServiceImpl<PluginMapper, PluginDo>
        implements AuthWrapperPluginService {

    private final AuthWrapperPluginCache authWrapperPluginCache;

    public AuthWrapperPluginServiceImpl(AuthWrapperPluginCache authWrapperPluginCache) {
        this.authWrapperPluginCache = authWrapperPluginCache;
    }


    @Override
    public void initOrUpdatePluginClassNameOtoIdMap2Cache() {
        //全表
        List<PluginDo> pluginDoList = super.list();
        Map<String, Long> pluginClassPathIdMap = pluginDoList.stream().collect(Collectors.toMap(PluginDo::getClassPath, PluginDo::getId));

        //replace
        authWrapperPluginCache.setPluginClassPathIdMap(pluginClassPathIdMap);
    }

}