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


    /**
     * 设置 rowId to 名称 映射
     *
     * @param valueMap 值映射
     */
    public void setRegisterRowIdOtoNameMap(Map<Long, String> valueMap) {
        super.hset(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_NAME_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 通过 id获取注册名字
     *
     * @param id id
     * @return {@link String}
     */
    public String getRegisterNameByRowId(Long id) {
        return super.hget(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_NAME_MAP, String.valueOf(id));
    }

    /**
     * 获取所有注册表用户
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    public Map<String, String> getAllRegisterRowIdOtoNameMap() {
        Map<String, String> entries = super.entries(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_NAME_MAP);
        return entries;
    }

    /**
     * 删除 注册表用户id oto 名称 集合
     */
    public void removeRegisterRowIdOtoNameMap() {
        super.remove(RegisterRedisKeyEnum.REGISTER_ROW_ID_OTO_NAME_MAP);
    }

    /**
     * 设置注册表用户id单对单名称映射集合
     *
     * @param valueMap 值映射集合
     */
    public void setRegisterIdOtoNameMap(Map<Long, String> valueMap) {
        super.hset(RegisterRedisKeyEnum.REGISTER_ID_OTO_NAME_MAP, Convert.toStrMap(valueMap));
    }

    /**
     * 通过id获取注册名字
     *
     * @param id id
     * @return {@link String}
     */
    public String getRegisterNameById(Long id) {
        return super.hget(RegisterRedisKeyEnum.REGISTER_ID_OTO_NAME_MAP, String.valueOf(id));
    }

    /**
     * 获取 注册表用户id oto 名称 集合
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    public Map<String, String> getAllRegisterIdOtoNameMap() {
        Map<String, String> entries = super.entries(RegisterRedisKeyEnum.REGISTER_ID_OTO_NAME_MAP);
        return entries;
    }

    /**
     * 删除 注册表用户id oto 名称 集合
     */
    public void removeRegisterIdOtoNameMap() {
        super.remove(RegisterRedisKeyEnum.REGISTER_ID_OTO_NAME_MAP);
    }
}
