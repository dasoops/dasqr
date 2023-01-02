package com.dasoops.dasserver.cq.service;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @Title: RegisterService
 * @ClassPath com.dasoops.dasserver.cq.service.RegisterService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service
 * @see IService
 */
public interface RegisterService extends IService<RegisterDo> {

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
     * 获取注册表id 类型 映射集合
     *
     * @return {@link Map}<{@link Long}, {@link Integer}>
     */
    Map<Long, Integer> getRegisterIdOtoTypeMap();

    /**
     * 初始化或更新 注册 id类型映射表
     */
    void initOrUpdateRegisterIdOtoTypeMap2Cache();

    /**
     * 初始化或更新 注册表类型 注册表id 单对单 id toCache
     */
    void initOrUpdateRegisterTypeRegisterIdOtoId2Cache();
}
