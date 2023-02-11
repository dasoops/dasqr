package com.dasoops.dasserver.cq.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.enums.base.DbBooleanEnum;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.DbRecordCqPlugin;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.dasoops.dasserver.cq.entity.dto.PluginStatusDto;
import com.dasoops.dasserver.cq.entity.enums.PluginEnableEnum;
import com.dasoops.dasserver.cq.entity.enums.PluginStatusEnum;
import com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum;
import com.dasoops.dasserver.cq.mapper.PluginMapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.simplesql.PluginSimpleSql;
import com.dasoops.dasserver.cq.simplesql.RegisterMtmPluginSimpleSql;
import com.dasoops.dasserver.cq.simplesql.RegisterSimpleSql;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
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
@RequiredArgsConstructor
public class PluginServiceImpl implements PluginService {

    private final ApplicationContext applicationContext;

    private final PluginSimpleSql simpleSql;
    private final RegisterSimpleSql registerSimpleSql;
    private final RegisterMtmPluginSimpleSql registerMtmPluginSimpleSql;

    private final PluginMapper pluginMapper;

    @Override
    public List<PluginStatusDto> getAllPluginAndStatus() {
        //获取有记录的所有插件
        List<PluginDo> pluginDoList = simpleSql.list();
        //加载的插件
        Map<String, CqPlugin> loadPluginMap = applicationContext.getBeansOfType(CqPlugin.class);

        List<PluginStatusDto> pluginStatusDtoList = new ArrayList<>(pluginDoList.stream().map(pluginDo -> {
            //0为未启用, 1启用未加载, 2加载, 3加载但无记录(不启用)
            Integer enable = pluginDo.getEnable();
            int status;
            //未启用
            if (enable.equals(PluginEnableEnum.FALSE.getDbValue())) {
                status = PluginStatusEnum.UNABLE.getIntegerValue();
            } else {
                boolean isLoad = loadPluginMap.values().stream().anyMatch(cqPlugin -> cqPlugin.getRawPlugin().getClass().getName().equals(pluginDo.getClassPath()));
                status = isLoad ? PluginStatusEnum.LOAD.getIntegerValue() : PluginStatusEnum.ENABLE_UNLOAD.getIntegerValue();
            }
            PluginStatusDto pluginStatusDto = new PluginStatusDto();
            BeanUtil.copyProperties(pluginDo, pluginStatusDto);
            pluginStatusDto.setStatus(status);
            return pluginStatusDto;
        }).toList());

        //说明有加载了但无数据库记录的插件
        if (loadPluginMap.size() > pluginDoList.size()) {
            List<PluginStatusDto> noRecordPluginList = this.getAllNoRecordPlugin(pluginDoList, loadPluginMap);
            pluginStatusDtoList.addAll(noRecordPluginList);
        }
        return pluginStatusDtoList;
    }

    @Override
    public List<PluginStatusDto> getAllNoRecordPlugin() {
        //获取有记录的所有插件
        List<PluginDo> pluginDoList = simpleSql.list();
        //加载的插件
        Map<String, CqPlugin> loadPluginMap = applicationContext.getBeansOfType(CqPlugin.class);
        return this.getAllNoRecordPlugin(pluginDoList, loadPluginMap);
    }

    private List<PluginStatusDto> getAllNoRecordPlugin(List<PluginDo> pluginDoList, Map<String, CqPlugin> loadPluginMap) {
        List<String> pluginClassNameList = pluginDoList.stream().map(PluginDo::getClassPath).toList();
        List<CqPlugin> noRecordButLoadPluginList = loadPluginMap.values().stream()
                .filter(cqPlugin ->
                        !pluginClassNameList.contains(cqPlugin.getRawPlugin().getClass().getName())
                       ).toList();
        List<PluginStatusDto> noRecordPluginList = noRecordButLoadPluginList.stream().map(cqPlugin -> {
            PluginStatusDto pluginStatusDto = new PluginStatusDto();
            pluginStatusDto.setRowId(-1L);
            pluginStatusDto.setName("noRecord");
            pluginStatusDto.setClassPath(cqPlugin.getRawPlugin().getClass().getName());
            pluginStatusDto.setOrder(-1);
            pluginStatusDto.setLevel(-1);
            pluginStatusDto.setDescription("未知插件");
            pluginStatusDto.setEnable(0);
            pluginStatusDto.setStatus(PluginStatusEnum.NO_RECORD.getIntegerValue());
            return pluginStatusDto;
        }).toList();
        return noRecordPluginList;
    }

    @Override
    public List<DbRecordCqPlugin> getAllLoadDbCqPlugin() {
        //获取所有启用的类全路径
        List<PluginDo> pluginDoList = simpleSql.lambdaQuery().list();
        Map<String, PluginDo> classPathOtoPluginDoMap = pluginDoList.stream().collect(Collectors.toMap(PluginDo::getClassPath, pluginDo -> pluginDo));

        //加载的所有插件
        Collection<CqPlugin> loadPluginList = applicationContext.getBeansOfType(CqPlugin.class).values();
        List<DbRecordCqPlugin> dbRecordCqPluginList = loadPluginList.stream().map(cqPlugin -> {
            DbRecordCqPlugin dbRecordCqPlugin = new DbRecordCqPlugin(cqPlugin);
            dbRecordCqPlugin.setPluginDo(classPathOtoPluginDoMap.get(cqPlugin.getRawPlugin().getClass().getName()));
            return dbRecordCqPlugin;
        }).toList();

        //在数据库中有启用记录的才是需要加载的
        List<DbRecordCqPlugin> needloadPluginList = dbRecordCqPluginList.stream()
                //enable过滤
                .filter(cqPlugin -> {
                    PluginDo pluginDo = cqPlugin.getPluginDo();
                    if (pluginDo == null) {
                        log.error("存在未知插件({}),请及时添加数据库记录以加载该插件", cqPlugin.getRawPlugin().getClass().getName());
                        return false;
                    }
                    //未启用
                    if (pluginDo.getEnable().equals(DbBooleanEnum.FALSE.getDbValue())) {
                        log.info("未启用插件: {}", cqPlugin.getRawPlugin().getClass().getName());
                        return false;
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(cqPlugin -> cqPlugin.getPluginDo().getOrder())).toList();

        return needloadPluginList;
    }

    @Override
    public Optional<PluginDo> getByKeyWord(String keyWord) {
        return simpleSql.lambdaQuery().eq(PluginDo::getName, keyWord).oneOpt();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(PluginDo pluginPo) {
        Assert.getInstance().allMustNotNull(pluginPo, pluginPo.getName(), pluginPo.getClassPath(), pluginPo.getLevel(), pluginPo.getDescription(), pluginPo.getOrder());
        Assert.getInstance().allMustNull(pluginPo.getRowId());

        //默认启用,存储插件对象
        pluginPo.setEnable(1);
        simpleSql.save(pluginPo);

        //注册用户对象Level >= 插件对象Level 赋予使用权限
        List<RegisterDo> registerDoList = registerSimpleSql.list();

        //构建registerPo对象
        List<RegisterMtmPluginDo> resList = registerDoList.stream().map(registerDo -> {
            RegisterMtmPluginDo registerMtmPluginDo = new RegisterMtmPluginDo();
            registerMtmPluginDo.setPluginId(pluginPo.getRowId());
            registerMtmPluginDo.setRegisterRowId(registerDo.getRowId());

            registerMtmPluginDo.setIsPass(registerDo.getLevel() <= pluginPo.getLevel() ? RegisterMtmPluginIsPassEnum.TRUE.getDbValue() : RegisterMtmPluginIsPassEnum.FALSE.getDbValue());
            return registerMtmPluginDo;
        }).collect(Collectors.toList());

        //持久化
        registerMtmPluginSimpleSql.saveBatch(resList);
        return true;
    }

    @Override
    public boolean updateByKeyword(PluginDo pluginPo) {
        Assert.getInstance().isTrue(simpleSql.lambdaUpdate().eq(PluginDo::getName, pluginPo.getName()).update(pluginPo));
        return true;
    }

    @Override
    public List<Long> getIdListByMinLevel(Integer minLevel) {
        return simpleSql.lambdaQuery().le(PluginDo::getLevel, minLevel).list().stream().map(BaseDo::getRowId).collect(Collectors.toList());
    }

    @Override
    public Integer getMaxOrder() {
        return pluginMapper.getMaxOrder();
    }


}