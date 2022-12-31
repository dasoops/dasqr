package com.dasoops.dasserver.cq.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.entity.enums.RegisterRedisKeyEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RegisterCache extends BaseCache {

    private final RegisterService registerService;

    public RegisterCache(StringRedisTemplate stringRedisTemplate, RegisterService registerService) {
        super(stringRedisTemplate);
        this.registerService = registerService;
    }

    /**
     * 设置 id类型 映射
     *
     * @param valueMap 值映射
     */
    public void setRegisterIdOtoTypeMap(Map<Long, Integer> valueMap) {
        super.hset(RegisterRedisKeyEnum.REGISTER_ID_OTO_TYPE_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 通过id获取类型
     *
     * @param id id
     * @return {@link String}
     */
    public String getRegisterTypeById(Long id) {
        return super.hget(RegisterRedisKeyEnum.REGISTER_ID_OTO_TYPE_MAP, String.valueOf(id));
    }

    /**
     * 设置 用户注册表 id单对单类型 映射集合
     *
     * @param valueMap 值映射
     */
    public void setUserRegisterIdOtoRowIdMap(Map<Long, Long> valueMap) {
        super.hset(RegisterRedisKeyEnum.REGISTER_USER_ROW_ID_OTO_ID_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 设置 群组注册表 id单对单类型 映射集合
     *
     * @param valueMap 值映射
     */
    public void setGroupRegisterIdOtoRowIdMap(Map<Long, Long> valueMap) {
        super.hset(RegisterRedisKeyEnum.REGISTER_GROUP_ROW_ID_OTO_ID_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 根据用户id获取表id
     *
     * @param id id
     * @return {@link Long}
     */
    public Long getUserRowIdByRegisterId(Long id) {
        String rowId = super.hget(RegisterRedisKeyEnum.REGISTER_USER_ROW_ID_OTO_ID_MAP, String.valueOf(id));
        return Long.valueOf(rowId);
    }

    /**
     * 根据群组id获取表id
     *
     * @param id id
     * @return {@link Long}
     */
    public Long getGroupRowIdByRegisterId(Long id) {
        String rowId = super.hget(RegisterRedisKeyEnum.REGISTER_GROUP_ROW_ID_OTO_ID_MAP, String.valueOf(id));
        return Long.valueOf(rowId);
    }

    /**
     * 初始化或更新 注册 id类型映射表
     */
    public void initOrUpdateRegisterIdOtoTypeMap2Cache() {
        super.remove(RegisterRedisKeyEnum.REGISTER_ID_OTO_TYPE_MAP);
        Map<Long, Integer> registerIdOtoTypeMap = registerService.getRegisterIdOtoTypeMap();
        this.setRegisterIdOtoTypeMap(registerIdOtoTypeMap);
    }

    /**
     * 初始化或更新 注册表类型 注册表id 单对单 id toCache
     */
    public void initOrUpdateRegisterTypeRegisterIdOtoId2Cache() {
        super.remove(RegisterRedisKeyEnum.REGISTER_USER_ROW_ID_OTO_ID_MAP);
        super.remove(RegisterRedisKeyEnum.REGISTER_GROUP_ROW_ID_OTO_ID_MAP);

        List<RegisterDo> registerDoList = registerService.list();
        Map<Integer, List<RegisterDo>> groupByTypeRegisterDoMap = registerDoList.stream().collect(Collectors.groupingBy(RegisterDo::getType));

        List<RegisterDo> userRegisterDoList = groupByTypeRegisterDoMap.get(RegisterTypeEnum.USER.getDbValue());
        Map<Long, Long> userValueMap = userRegisterDoList.stream().collect(Collectors.toMap(RegisterDo::getRegisterId, RegisterDo::getId));
        this.setUserRegisterIdOtoRowIdMap(userValueMap);

        List<RegisterDo> groupRegisterDoList = groupByTypeRegisterDoMap.get(RegisterTypeEnum.GROUP.getDbValue());
        Map<Long, Long> groupValueMap = groupRegisterDoList.stream().collect(Collectors.toMap(RegisterDo::getRegisterId, RegisterDo::getId));
        this.setGroupRegisterIdOtoRowIdMap(groupValueMap);


    }
}
