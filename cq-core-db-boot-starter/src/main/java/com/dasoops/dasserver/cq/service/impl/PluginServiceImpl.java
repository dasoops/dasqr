package com.dasoops.dasserver.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.ClassNameUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum;
import com.dasoops.dasserver.cq.mapper.PluginMapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
public class PluginServiceImpl extends ServiceImpl<PluginMapper, PluginDo>
        implements PluginService {

    private final PluginMapper pluginMapper;
    private final RegisterService registerService;
    private final RegisterMtmPluginService registerMtmPluginService;
    private final ApplicationContext applicationContext;

    public PluginServiceImpl(@Lazy @SuppressWarnings("all") PluginMapper pluginMapper, @Lazy RegisterService registerService, @Lazy RegisterMtmPluginService registerMtmPluginService, ApplicationContext applicationContext) {
        this.pluginMapper = pluginMapper;
        this.registerService = registerService;
        this.registerMtmPluginService = registerMtmPluginService;
        this.applicationContext = applicationContext;
    }

    @Override
    public List<CqPlugin> getAllLoadPlugin() {
        //获取所有启用的类全路径
        List<PluginDo> pluginDoList = super.list();
        Map<String, Integer> classPathOtoOrderMap = pluginDoList.stream().collect(Collectors.toMap(PluginDo::getClassPath, PluginDo::getOrder));
        List<String> allClassPathList = pluginDoList.stream().map(PluginDo::getClassPath).toList();

        //加载的所有插件
        Collection<CqPlugin> loadPluginList = applicationContext.getBeansOfType(CqPlugin.class).values();

        //在数据库中有启用记录的才是需要加载的
        List<CqPlugin> needloadPluginList = loadPluginList.stream()
                .filter(cqPlugin -> {
                    boolean needLoad = allClassPathList.stream().anyMatch(classPath -> ClassNameUtil.removeCglibSuffix(cqPlugin.getClass().getName()).equals(classPath));
                    Assert.getInstance().ifFalse(needLoad, () -> log.error("存在未知插件({}),请及时添加数据库记录以加载该插件", ClassNameUtil.removeCglibSuffix(cqPlugin.getClass().getName())));
                    return needLoad;
                })
                .sorted(Comparator.comparingInt(cqPlugin -> {
                    String classPath = ClassNameUtil.removeCglibSuffix(cqPlugin.getClass().getName());
                    return classPathOtoOrderMap.get(classPath);
                })).toList();

        return needloadPluginList;
    }

    @Override
    public Optional<PluginDo> getByKeyWord(String keyWord) {
        return super.lambdaQuery().eq(PluginDo::getKeyword, keyWord).oneOpt();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(PluginDo pluginPo) {
        Assert.getInstance().allMustNotNull(pluginPo, pluginPo.getKeyword(), pluginPo.getClassPath(), pluginPo.getLevel(), pluginPo.getDescription(), pluginPo.getOrder());
        Assert.getInstance().allMustNull(pluginPo.getRowId());

        //默认启用,存储插件对象
        pluginPo.setEnable(1);
        super.save(pluginPo);

        //注册用户对象Level >= 插件对象Level 赋予使用权限
        List<RegisterDo> registerDoList = registerService.list();

        //构建registerPo对象
        List<RegisterMtmPluginDo> resList = registerDoList.stream().map(registerDo -> {
            RegisterMtmPluginDo registerMtmPluginDo = new RegisterMtmPluginDo();
            registerMtmPluginDo.setPluginId(pluginPo.getRowId());
            registerMtmPluginDo.setRegisterRowId(registerDo.getRowId());
            registerMtmPluginDo.setIsPass(registerDo.getLevel() <= pluginPo.getLevel() ? RegisterMtmPluginIsPassEnum.TRUE.getDbValue() : RegisterMtmPluginIsPassEnum.FALSE.getDbValue());
            return registerMtmPluginDo;
        }).collect(Collectors.toList());

        //持久化
        registerMtmPluginService.saveBatch(resList);
        return true;
    }

    @Override
    public boolean updateByKeyword(PluginDo pluginPo) {
        Assert.getInstance().isTrue(super.lambdaUpdate().eq(PluginDo::getKeyword, pluginPo.getKeyword()).update(pluginPo));
        return true;
    }

    @Override
    public List<Long> getIdListByMinLevel(Integer minLevel) {
        return super.lambdaQuery().le(PluginDo::getLevel, minLevel).list().stream().map(BaseDo::getRowId).collect(Collectors.toList());
    }

    @Override
    public Integer getMaxOrder() {
        return pluginMapper.getMaxOrder();
    }


}