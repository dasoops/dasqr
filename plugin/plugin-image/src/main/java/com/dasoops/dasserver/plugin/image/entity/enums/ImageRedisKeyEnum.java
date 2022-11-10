package com.dasoops.dasserver.plugin.image.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import com.dasoops.dasserver.cq.bot.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @Title: ImageRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.enums.ImageRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/09
 * @Version 1.0.0
 * @Description: 图片RedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@Getter
@AllArgsConstructor
public enum ImageRedisKeyEnum implements IRedisKeyEnum {

    /**
     * 分片存图标记
     */
    PART_SAVE_IMAGE(PLUGIN + "image:" + "partFlag:");

    final String key;

    public String getPartSaveImageKeyByGroup(Long groupId) {
        return this.getKey() + "group:" + groupId;
    }

    public String getPartSaveImageKeyByPrivate(Long userId) {
        return this + "user:" + userId;
    }

    public String getPartSaveImageKey(CqMessageEvent event) {
        if (event instanceof CqGroupMessageEvent) {
            return this.getKey() + "group:" + ((CqGroupMessageEvent)event).getGroupId();
        } else {
            return this + "user:" + event.getUserId();
        }
    }

}
