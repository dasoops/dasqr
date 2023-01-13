package com.dasoops.dasserver.cq.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.entity.enums.RegisterRedisKeyEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Title: RegisterCache
 * @ClassPath com.dasoops.dasserver.cq.cache.RegisterCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/03
 * @Version 1.0.0
 * @Description: 注册表缓存
 * @see BaseCache
 */
@Component
public class RegisterCache extends BaseCache {

    public RegisterCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    /**
     * 设置 id类型 映射
     *
     * @param valueMap 值映射
     */
    public void setRegisterIdOtoTypeMap(Map<Long, Integer> valueMap) {
        super.remove(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_TYPE_MAP);
        super.hset(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_TYPE_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 通过id获取类型
     *
     * @param id id
     * @return {@link String}
     */
    public String getRegisterTypeById(Long id) {
        return super.hget(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_TYPE_MAP, String.valueOf(id));
    }

    /**
     * 设置 用户注册表 id单对单类型 映射集合
     *
     * @param valueMap 值映射
     */
    public void setUserRegisterIdOtoRowIdMap(Map<Long, Long> valueMap) {
        super.remove(RegisterRedisKeyEnum.REGISTER_USER_REGISTER_ID_OTO_ROW_ID_MAP);
        super.hset(RegisterRedisKeyEnum.REGISTER_USER_REGISTER_ID_OTO_ROW_ID_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 设置 群组注册表 id单对单类型 映射集合
     *
     * @param valueMap 值映射
     */
    public void setGroupRegisterIdOtoRowIdMap(Map<Long, Long> valueMap) {
        super.remove(RegisterRedisKeyEnum.REGISTER_GROUP_REGISTER_ID_OTO_ROW_ID_MAP);
        super.hset(RegisterRedisKeyEnum.REGISTER_GROUP_REGISTER_ID_OTO_ROW_ID_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 根据用户id获取表id
     *
     * @param id id
     * @return {@link Long}
     */
    public Long getUserRowIdByRegisterId(Long id) {
        String rowId = super.hget(RegisterRedisKeyEnum.REGISTER_USER_REGISTER_ID_OTO_ROW_ID_MAP, String.valueOf(id));
        return Long.valueOf(rowId);
    }

    /**
     * 根据群组id获取表id
     *
     * @param id id
     * @return {@link Long}
     */
    public Long getGroupRowIdByRegisterId(Long id) {
        String rowId = super.hget(RegisterRedisKeyEnum.REGISTER_GROUP_REGISTER_ID_OTO_ROW_ID_MAP, String.valueOf(id));
        return Long.valueOf(rowId);
    }
}
