package com.dasoops.dasserver.plugin.image.service;

import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.plugin.image.entity.po.ImagePo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Optional;

/**
* @author Administrator
* @description 针对表【TB_PLUGIN_IMAGE(图片信息)】的数据库操作Service
* @createDate 2022-11-07 15:23:49
*/
public interface ImageService extends IService<ImagePo> {

    /**
     * 关键字是否重复
     *
     * @param keyword 关键字
     * @return boolean
     */
    boolean keywordIsRepeat(String keyword);

    /**
     * 获取联想关键字
     *
     * @param keyword 关键字
     * @return {@link List}<{@link String}>
     */
    Optional<List<String>> getFantasyKeyword(String keyword);


    /**
     * 保存图像
     *
     * @param groupId  组id
     * @param authorId 作者id
     * @param keyword  关键字
     * @param url      url
     * @return boolean
     * @See saveImage(Long groupId, Long authorId, String desc, String keyword, String url)
     */
    boolean saveImage(Long groupId, Long authorId, String keyword, String url);

    /**
     * 保存图像
     *
     * @param authorId 作者id
     * @param keyword  关键字
     * @param url      url
     * @return boolean
     * @See saveImage(Long groupId, Long authorId, String desc, String keyword, String url)
     */
    boolean saveImage(Long authorId, String keyword, String url);

    /**
     * 保存图像
     *
     * @param event 事件
     * @param key   关键
     * @param url   url
     * @return boolean
     */
    boolean saveImage(CqMessageEvent event, String key, String url);

    /**
     * 根据关键词获取图片
     *
     * @param keyword 关键字
     * @return {@link ImagePo}
     */
    ImagePo getImageByKeyword(String keyword);

    /**
     * 根据关键词获取图片CoCode
     *
     * @param keyword 关键字
     * @return {@link Optional}<{@link String}>
     */
    Optional<String> getImageCqCode(String keyword);
}
