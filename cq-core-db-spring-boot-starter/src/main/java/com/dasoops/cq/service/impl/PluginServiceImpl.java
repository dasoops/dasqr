package com.dasoops.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.cq.entity.po.PluginPo;
import com.dasoops.cq.service.PluginService;
import com.dasoops.cq.mapper.PluginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.dasoops.cq.CqPlugin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Title: PluginServiceImpl
 * @ClassPath com.dasoops.cq.service.impl.PluginServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_PLUGIN(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Service实现
 * @see ServiceImpl
 * @see PluginService
 */
@Service
@Slf4j
public class PluginServiceImpl extends ServiceImpl<PluginMapper, PluginPo>
        implements PluginService {

    private final PluginMapper pluginMapper;

    public PluginServiceImpl(PluginMapper pluginMapper) {
        this.pluginMapper = pluginMapper;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<List<? extends Class<CqPlugin>>> getAllPluginClass() {
        Optional<List<String>> classPathListOpt = pluginMapper.selectAllClassPath();

        List<? extends Class<CqPlugin>> resList;

        if (classPathListOpt.isEmpty()) {
            return Optional.empty();
        }

        resList = classPathListOpt.get().stream().map(classPath -> {
            try {
                return (Class<CqPlugin>) Class.forName(classPath);
            } catch (ClassNotFoundException e) {
                log.error("ClassNotFound,classPath: {}", classPath);
                return null;
            }
        }).collect(Collectors.toList());

        return Optional.of(resList);
    }

}




