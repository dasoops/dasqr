package com.dasoops.dasserver.plugin.image.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.plugin.image.entity.enums.ImagePartSaveRedisKeyShamEnum;
import com.dasoops.dasserver.plugin.image.entity.enums.ImageRedisKeyEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Title: ImageCache
 * @ClassPath com.dasoops.dasserver.plugin.image.cache.ImageCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: 图像缓存
 * @see BaseCache
 */
@Component
public class ImageCache extends BaseCache {

    public ImageCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    /**
     * 设置图像关键字集合
     *
     * @param imageKeywordList 图像关键字集合
     */
    public void setImageKeywordList(List<String> imageKeywordList) {
        super.remove(ImageRedisKeyEnum.KEYWORD_LIST);
        super.lset(ImageRedisKeyEnum.KEYWORD_LIST, imageKeywordList);
    }

    /**
     * 获取图像关键字集合
     *
     * @return {@link List}<{@link String}>
     */
    public List<String> getImageKeywordList() {
        return super.lget(ImageRedisKeyEnum.KEYWORD_LIST);
    }

    /**
     * 设置 群组图片分片保存
     *
     * @param groupId 组id
     * @param userId  用户id
     * @param keyword 关键字
     */
    public void setGroupImagePartSave(Long groupId, Long userId, String keyword) {
        ImagePartSaveRedisKeyShamEnum redisKeyShamEnum = ImagePartSaveRedisKeyShamEnum.group(groupId);
        super.hset(redisKeyShamEnum, String.valueOf(userId), keyword);
    }

    /**
     * 设置 用户图片分片保存
     *
     * @param userId  用户id
     * @param keyword 关键字
     */
    public void setUserImagePartSave(Long userId, String keyword) {
        ImagePartSaveRedisKeyShamEnum redisKeyShamEnum = ImagePartSaveRedisKeyShamEnum.user(userId);
        super.set(redisKeyShamEnum, keyword);
    }

    /**
     * 设置 群组图片分片保存和过期时间
     *
     * @param groupId  群组id
     * @param userId   用户id
     * @param keyword  关键字
     * @param timeout  超时
     * @param timeUnit 时间单位
     */
    public void setGroupImagePartSaveAndExpire(Long groupId, Long userId, String keyword, Long timeout, TimeUnit timeUnit) {
        ImagePartSaveRedisKeyShamEnum redisKeyShamEnum = ImagePartSaveRedisKeyShamEnum.group(groupId);
        super.hset(redisKeyShamEnum, String.valueOf(userId), keyword);
        super.expire(redisKeyShamEnum, timeout, timeUnit);
    }

    /**
     * 设置用户图片分片保存和到期
     *
     * @param userId   用户id
     * @param keyword  关键字
     * @param timeout  超时
     * @param timeUnit 时间单位
     */
    public void setUserImagePartSaveAndExpire(Long userId, String keyword, Long timeout, TimeUnit timeUnit) {
        ImagePartSaveRedisKeyShamEnum redisKeyShamEnum = ImagePartSaveRedisKeyShamEnum.user(userId);
        super.set(redisKeyShamEnum, keyword);
        super.expire(redisKeyShamEnum, timeout, timeUnit);
    }

    /**
     * 设置图片分片保存
     *
     * @param cqMessageEvent cq消息事件
     * @param keyword        关键字
     */
    public void setImagePartSave(CqMessageEvent cqMessageEvent, String keyword) {
        if (cqMessageEvent instanceof CqGroupMessageEvent event) {
            this.setGroupImagePartSave(event.getGroupId(), event.getUserId(), keyword);
        } else if (cqMessageEvent instanceof CqPrivateMessageEvent event) {
            this.setUserImagePartSave(event.getUserId(), keyword);
        } else {
            throw new LogicException(ExceptionEnum.UN_EXPECTED);
        }
    }

    /**
     * 设置图片分片保存和到期
     *
     * @param cqMessageEvent cq消息事件
     * @param keyword        关键字
     * @param timeout        超时
     * @param timeUnit       时间单位
     */
    public void setImagePartSaveAndExpire(CqMessageEvent cqMessageEvent, String keyword, Long timeout, TimeUnit timeUnit) {
        if (cqMessageEvent instanceof CqGroupMessageEvent event) {
            this.setGroupImagePartSaveAndExpire(event.getGroupId(), event.getUserId(), keyword, timeout, timeUnit);
        } else if (cqMessageEvent instanceof CqPrivateMessageEvent event) {
            this.setUserImagePartSaveAndExpire(event.getUserId(), keyword, timeout, timeUnit);
        } else {
            throw new LogicException(ExceptionEnum.UN_EXPECTED);
        }
    }

    /**
     * 获取和删除图片分片保存flag
     *
     * @param userId 用户id
     * @return {@link String}
     */
    public String getAndDeleteImagePartSaveFlag(Long userId) {
        ImagePartSaveRedisKeyShamEnum redisKeyEnum = ImagePartSaveRedisKeyShamEnum.user(userId);
        return super.getAndDelete(redisKeyEnum);
    }

    /**
     * 获取和删除图片分片保存flag
     *
     * @param groupId 群组id
     * @param userId  用户id
     * @return {@link String}
     */
    public String hgetAndDeleteImagePartSaveFlag(Long groupId, Long userId) {
        ImagePartSaveRedisKeyShamEnum redisKeyEnum = ImagePartSaveRedisKeyShamEnum.group(groupId);
        return super.hgetAndDelete(redisKeyEnum, String.valueOf(userId));
    }

    public void removeImagePartSaveFlag(Long groupId, Long userId) {
        ImagePartSaveRedisKeyShamEnum redisKeyEnum = ImagePartSaveRedisKeyShamEnum.group(groupId);
        super.hdelete(redisKeyEnum, String.valueOf(userId));
    }

    public void removeImagePartSaveFlag(Long userId) {
        super.remove(ImagePartSaveRedisKeyShamEnum.user(userId));
    }

    public void removeImagePartSaveFlag(CqMessageEvent cqMessageEvent) {
        if (cqMessageEvent instanceof CqGroupMessageEvent event) {
            this.removeImagePartSaveFlag(event.getGroupId(), event.getUserId());
        } else if (cqMessageEvent instanceof CqPrivateMessageEvent event) {
            this.removeImagePartSaveFlag(event.getUserId());
        } else {
            throw new LogicException(ExceptionEnum.UN_EXPECTED);
        }
    }

    /**
     * 添加关键字
     *
     * @param keyword 关键字
     */
    public void addKeyword(String keyword) {
        super.lset(ImageRedisKeyEnum.KEYWORD_LIST, keyword);
    }
}
