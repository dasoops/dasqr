package com.dasoops.dasserver.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.RegisterCache;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.dasoops.dasserver.cq.entity.dto.cq.retdata.FriendData;
import com.dasoops.dasserver.cq.entity.dto.cq.retdata.GroupData;
import com.dasoops.dasserver.cq.entity.dto.cq.retdata.GroupMemberInfoData;
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum;
import com.dasoops.dasserver.cq.mapper.RegisterMapper;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.cq.util.RegisterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: RegisterServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.RegisterServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see RegisterService
 */
@Service
@Slf4j
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, RegisterDo>
        implements RegisterService {

    private final PluginService pluginService;
    private final RegisterMtmPluginService registerMtmPluginService;
    private final RegisterCache registerCache;

    public RegisterServiceImpl(@Lazy PluginService pluginService, @Lazy RegisterMtmPluginService registerMtmPluginService, RegisterCache registerCache) {
        this.pluginService = pluginService;
        this.registerMtmPluginService = registerMtmPluginService;
        this.registerCache = registerCache;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(RegisterDo registerPo) {
        Assert.getInstance().allMustNotNull(registerPo, registerPo.getRegisterId(), registerPo.getType(), registerPo.getLevel());
        Assert.getInstance().allMustNull(registerPo.getRowId());

        //存储注册对象
        Assert.getInstance().isTrue(super.save(registerPo));

        //插件对象Level <= 注册用户对象Level 赋予使用权限
        List<Long> pluginPoIdList = pluginService.getIdListByMinLevel(registerPo.getLevel());

        List<RegisterMtmPluginDo> rpList = pluginPoIdList.stream().map(pluginPoId -> {
            RegisterMtmPluginDo po = new RegisterMtmPluginDo();
            po.setPluginId(pluginPoId);
            po.setRegisterRowId(registerPo.getRowId());
            return po;
        }).collect(Collectors.toList());

        //持久化
        Assert.getInstance().isTrue(registerMtmPluginService.saveBatch(rpList));
        return true;
    }

    @Override
    public List<Long> getIdListByMaxLevel(Integer maxLevel) {
        return super.lambdaQuery().ge(RegisterDo::getLevel, maxLevel).list().stream().map(BaseDo::getRowId).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void initOrUpdateRegisterList(CqTemplate cqTemplate) {
        log.info("初始化/更新 注册用户集合 缓存");
        //全表扫描
        List<RegisterDo> registerDoList = super.list();
        //获取为注册用户集合
        List<RegisterDo> noExistRegisterDoList = new ArrayList<>();
        //已注册用户id集合
        List<Long> userIdList = new ArrayList<>();
        //已注册群组id集合
        List<Long> groupIdList = new ArrayList<>();
        registerDoList.forEach(registerDo -> {
            Long registerId = registerDo.getRegisterId();
            if (registerDo.getType().equals(RegisterTypeEnum.USER.getDbValue())) {
                userIdList.add(registerId);
            } else {
                groupIdList.add(registerId);
            }
        });

        //好友列表集合检查
        List<FriendData> friendDataList = cqTemplate.getFriendList().getData();
        friendDataList.forEach(friendData -> {
            long userId = friendData.getUserId();
            //不存在注册
            if (!userIdList.contains(userId)) {
                RegisterDo registerDo = RegisterUtil.buildNewRegisterDo(userId, RegisterTypeEnum.USER);
                userIdList.add(userId);
                noExistRegisterDoList.add(registerDo);
            }
        });

        //群组集合检查
        List<GroupData> groupDataList = cqTemplate.getGroupList().getData();
        groupDataList.forEach(groupData -> {
            long groupId = groupData.getGroupId();

            //不存在注册
            if (!groupIdList.contains(groupId)) {
                RegisterDo registerDo = RegisterUtil.buildNewRegisterDo(groupId, RegisterTypeEnum.GROUP);
                groupIdList.add(groupId);
                noExistRegisterDoList.add(registerDo);
            }

            //群组内用户集合检查
            List<GroupMemberInfoData> groupMemberListDataList = cqTemplate.getGroupMemberList(groupId).getData();
            groupMemberListDataList.forEach(groupMemberListData -> {
                long userId = groupMemberListData.getUserId();
                //不存在注册
                if (!userIdList.contains(userId)) {
                    RegisterDo registerDo = RegisterUtil.buildNewRegisterDo(userId, RegisterTypeEnum.USER);
                    userIdList.add(userId);
                    noExistRegisterDoList.add(registerDo);
                }
            });
        });

        //持久化
        super.saveBatch(noExistRegisterDoList);
    }

    @Override
    public Map<Long, Integer> getRegisterIdOtoTypeMap() {
        List<RegisterDo> registerDoList = super.list();
        Map<Long, Integer> map = registerDoList.stream().collect(Collectors.toMap(RegisterDo::getRowId, RegisterDo::getType));
        return map;
    }


    @Override
    public void initOrUpdateRegisterIdOtoTypeMap2Cache() {
        log.info("初始化/更新 注册表对象 单对单 注册表类型 缓存");
        Map<Long, Integer> registerIdOtoTypeMap = this.getRegisterIdOtoTypeMap();
        registerCache.setRegisterIdOtoTypeMap(registerIdOtoTypeMap);
    }

    @Override
    public void initOrUpdateRegisterTypeRegisterIdOtoId2Cache() {
        log.info("初始化/更新 初始化或更新 注册表类型 用户idid 单对单 注册表id  缓存");
        List<RegisterDo> registerDoList = super.list();
        Map<Integer, List<RegisterDo>> groupByTypeRegisterDoMap = registerDoList.stream().collect(Collectors.groupingBy(RegisterDo::getType));

        List<RegisterDo> userRegisterDoList = groupByTypeRegisterDoMap.get(RegisterTypeEnum.USER.getDbValue());
        Map<Long, Long> userValueMap = userRegisterDoList.stream().collect(Collectors.toMap(RegisterDo::getRegisterId, RegisterDo::getRowId));
        registerCache.setUserRegisterIdOtoRowIdMap(userValueMap);

        List<RegisterDo> groupRegisterDoList = groupByTypeRegisterDoMap.get(RegisterTypeEnum.GROUP.getDbValue());
        Map<Long, Long> groupValueMap = groupRegisterDoList.stream().collect(Collectors.toMap(RegisterDo::getRegisterId, RegisterDo::getRowId));
        registerCache.setGroupRegisterIdOtoRowIdMap(groupValueMap);
    }


    @Override
    public void initOrUpdateRegisterRowIdOtoNameMapAndRegisterUserIdOtoNameMap2Cache(CqTemplate cqTemplate) {
        log.info("初始化/更新 注册表rowId 单对单 插件集合 映射集合");
        Map<Long, String> registerIdOtoNameMap = new HashMap<>(16);
        Map<Long, String> registerRowIdOtoNameMap = new HashMap<>(16);

        //好友
        List<FriendData> friendDataList = cqTemplate.getFriendList().getData();
        friendDataList.forEach(friendData -> {
            registerRowIdOtoNameMap.put(registerCache.getUserRowIdByRegisterId(friendData.getUserId()), friendData.getNickname());
            registerIdOtoNameMap.put(friendData.getUserId(), friendData.getNickname());
        });


        //群组
        List<GroupData> groupDataList = cqTemplate.getGroupList().getData();
        groupDataList.stream()
                .mapToLong(GroupData::getGroupId)
                .mapToObj(groupId -> cqTemplate.getGroupMemberList(groupId).getData())
                .forEach(userInfoDataList -> userInfoDataList.forEach(userInfoData -> {
                    registerRowIdOtoNameMap.put(registerCache.getUserRowIdByRegisterId(userInfoData.getUserId()), userInfoData.getNickname());
                    registerIdOtoNameMap.put(userInfoData.getUserId(), userInfoData.getNickname());
                }));

        registerCache.removeRegisterRowIdOtoNameMap();
        registerCache.removeRegisterIdOtoNameMap();
        registerCache.setRegisterRowIdOtoNameMap(registerRowIdOtoNameMap);
        registerCache.setRegisterIdOtoNameMap(registerIdOtoNameMap);
    }
}




