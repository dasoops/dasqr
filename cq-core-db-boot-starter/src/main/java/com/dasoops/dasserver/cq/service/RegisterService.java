package com.dasoops.dasserver.cq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;

import java.util.List;
import java.util.Map;

/**
 * @title RegisterService
 * @classPath com.dasoops.dasserver.cq.service.RegisterService
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service
 * @see IService
 */
public interface RegisterService {

    /**
     * 根据最高等级获取注册者id集合 maxLevel >= RegisterLevel
     *
     * @param maxLevel 最大水平
     * @return {@link List}<{@link Integer}>
     */
    List<Long> getIdListByMaxLevel(Integer maxLevel);

    /**
     * 初始化或更新 注册集合
     *
     * @param cqTemplate cqTemplate
     */
    void initOrUpdateRegisterList(CqTemplate cqTemplate);

    /**
     * 获取注册表Rowid 类型 映射集合
     *
     * @return {@link Map}<{@link Long}, {@link Integer}>
     */
    Map<Long, Integer> getRegisterRowIdOtoTypeMap();

    /**
     * 初始化或更新 注册表对象RowId 单对单 类型映射表
     */
    void initOrUpdateRegisterRowIdOtoTypeMap2Cache();

    /**
     * 初始化或更新 注册表类型 注册表id 单对单 id toCache
     */
    void initOrUpdateRegisterTypeRegisterIdOtoId2Cache();

    /**
     * 初始化或更新 注册表主键id 单对单 名称,注册表用户id 单对单 名称 to缓存
     *
     * @param cqTemplate cqTemplate
     */
    void initOrUpdateRegisterRowIdOtoNameMapAndRegisterIdOtoNameMap2Cache(CqTemplate cqTemplate);


    /**
     * 保存
     *
     * @param registerPo 注册对象
     * @return boolean
     */
    boolean save(RegisterDo registerPo);
}
