package com.dasoops.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.core.util.Assert;
import com.dasoops.cq.entity.po.BasePo;
import com.dasoops.cq.entity.po.RegisterMtmPluginPo;
import com.dasoops.cq.entity.po.RegisterPo;
import com.dasoops.cq.mapper.RegisterMapper;
import com.dasoops.cq.service.PluginService;
import com.dasoops.cq.service.RegisterMtmPluginService;
import com.dasoops.cq.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: RegisterServiceImpl
 * @ClassPath com.dasoops.cq.service.impl.RegisterServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_REGISTER(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see RegisterService
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, RegisterPo>
        implements RegisterService {

    @Autowired
    private PluginService pluginService;
    @Autowired
    private RegisterMtmPluginService registerMtmPluginService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(RegisterPo registerPo) {
        Assert.allNotNull(registerPo, registerPo.getRegisterId(), registerPo.getType(), registerPo.getLevel());
        Assert.allNull(registerPo.getId());

        //存储注册对象
        Assert.isTrue(super.save(registerPo));

        //插件对象Level <= 注册用户对象Level 赋予使用权限
        List<Integer> pluginPoIdList = pluginService.getIdListByMinLevel(registerPo.getLevel());

        List<RegisterMtmPluginPo> rpList = pluginPoIdList.stream().map(pluginPoId -> {
            RegisterMtmPluginPo po = new RegisterMtmPluginPo();
            po.setPluginId(pluginPoId);
            po.setRegisterId(registerPo.getId());
            return po;
        }).collect(Collectors.toList());

        //持久化
        Assert.isTrue(registerMtmPluginService.saveBatch(rpList));
        return true;
    }

    @Override
    public List<Integer> getIdListByMaxLevel(Integer maxLevel) {
        return this.lambdaQuery().ge(RegisterPo::getLevel, maxLevel).list().stream().map(BasePo::getId).collect(Collectors.toList());
    }

}




