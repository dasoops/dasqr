package com.dasoops.dasserver.plugin.webmanager.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.entity.enums.RegisterRedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Title: RegisterWebCache
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.cache.RegisterWebCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册web缓存
 */
@Component
@Slf4j
public class RegisterWebCache extends BaseCache {

    public RegisterWebCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
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
    public void removeRegisterRowIdOtoNameMap(){
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
    public void removeRegisterIdOtoNameMap(){
        super.remove(RegisterRedisKeyEnum.REGISTER_ID_OTO_NAME_MAP);
    }
}
