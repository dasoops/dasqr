package com.dasoops.dasserver.plugin.webManager.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.entity.retdata.FriendData;
import com.dasoops.dasserver.cq.entity.retdata.GroupData;
import com.dasoops.dasserver.entity.enums.RegisterRedisKeyEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: RegisterWebCache
 * @ClassPath com.dasoops.dasserver.plugin.webManager.cache.RegisterWebCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册web缓存
 */
@Component
public class RegisterWebCache extends BaseCache {

    public RegisterWebCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    /**
     * 设置 id名称 映射
     *
     * @param valueMap 值映射
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
     * 初始化或更新注册表 id单对单名称 to缓存
     *
     * @param cqTemplate cq模板
     */
    public void initOrUpdateRegisterIdOtoNameMap2Cache(CqTemplate cqTemplate) {
        Map<Long, String> registerIdOtoNameMap = new HashMap<>(16);

        //好友
        List<FriendData> friendDataList = cqTemplate.getFriendList().getData();
        friendDataList.forEach(friendData -> registerIdOtoNameMap.put(friendData.getUserId(), friendData.getNickname()));

        //群组
        List<GroupData> groupDataList = cqTemplate.getGroupList().getData();
        groupDataList.stream()
                .mapToLong(GroupData::getGroupId)
                .mapToObj(groupId -> cqTemplate.getGroupMemberList(groupId).getData())
                .forEach(userInfoDataList -> userInfoDataList.forEach(userInfoData -> registerIdOtoNameMap.put(userInfoData.getUserId(), userInfoData.getNickname())));

        this.setRegisterIdOtoNameMap(registerIdOtoNameMap);
    }
}
