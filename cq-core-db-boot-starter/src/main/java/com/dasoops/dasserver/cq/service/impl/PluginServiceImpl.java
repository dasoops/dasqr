package com.dasoops.dasserver.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.core.util.Assert;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.po.BasePo;
import com.dasoops.dasserver.cq.entity.po.PluginPo;
import com.dasoops.dasserver.cq.entity.po.RegisterMtmPluginPo;
import com.dasoops.dasserver.cq.mapper.PluginMapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Title: PluginServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.PluginServiceImpl
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
    private final RegisterService registerService;
    private final RegisterMtmPluginService registerMtmPluginService;

    public PluginServiceImpl(@Autowired(required = false) PluginMapper pluginMapper, @Lazy RegisterService registerService, RegisterMtmPluginService registerMtmPluginService) {
        this.pluginMapper = pluginMapper;
        this.registerService = registerService;
        this.registerMtmPluginService = registerMtmPluginService;
    }


    @Override
    @SuppressWarnings("unchecked")
    public Optional<List<Class<? extends CqPlugin>>> getAllPluginClass() {
        //获取所有类全路径
        Optional<List<String>> classPathListOpt = Optional.ofNullable(pluginMapper.selectAllClassPathOrderByOrder());

        if (classPathListOpt.isEmpty()) {
            return Optional.empty();
        }

        //根据类路径获取类对象
        List<String> classPathList = classPathListOpt.get();
        List<Class<? extends CqPlugin>> resList = new ArrayList<>(classPathList.size());
        classPathList.forEach(classPath -> {
            try {
                resList.add((Class<CqPlugin>) Class.forName(classPath));
            } catch (ClassNotFoundException e) {
                log.error("ClassNotFound,classPath: {}", classPath);
            }
        });

        return Optional.of(resList);
    }

    @Override
    public Optional<PluginPo> getByKeyWord(String keyWord) {
        return this.lambdaQuery().eq(PluginPo::getKeyword, keyWord).oneOpt();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(PluginPo pluginPo) {
        Assert.allNotNull(pluginPo, pluginPo.getKeyword(), pluginPo.getClassPath(), pluginPo.getLevel(), pluginPo.getDescription(), pluginPo.getOrder());
        Assert.allNull(pluginPo.getId());

        //默认启用,存储插件对象
        pluginPo.setEnable(1);
        Assert.isTrue(super.save(pluginPo));

        //注册用户对象Level >= 插件对象Level 赋予使用权限
        List<Integer> registerPoIdList = registerService.getIdListByMaxLevel(pluginPo.getLevel());

        //构建registerPo对象
        List<RegisterMtmPluginPo> rpList = registerPoIdList.stream().map(registerPoId -> {
            RegisterMtmPluginPo po = new RegisterMtmPluginPo();
            po.setPluginId(pluginPo.getId());
            po.setRegisterId(registerPoId);
            return po;
        }).collect(Collectors.toList());

        //持久化
        Assert.isTrue(registerMtmPluginService.saveBatch(rpList));
        return true;
    }

    @Override
    public boolean updateByKeyword(PluginPo pluginPo) {
        Assert.isTrue(super.lambdaUpdate().eq(PluginPo::getKeyword, pluginPo.getKeyword()).update(pluginPo));
        return true;
    }

    @Override
    public List<Integer> getIdListByMinLevel(Integer minLevel) {
        return this.lambdaQuery().le(PluginPo::getLevel, minLevel).list().stream().map(BasePo::getId).collect(Collectors.toList());
    }


}