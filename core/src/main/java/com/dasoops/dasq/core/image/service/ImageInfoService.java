package com.dasoops.dasq.core.image.service;

import com.dasoops.dasq.core.image.entity.pojo.ImageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_IMAGE_INFO(图片信息)】的数据库操作Service
 * @createDate 2022-10-07 16:40:31
 */
public interface ImageInfoService extends IService<ImageInfo> {

    /**
     * 保存图像
     *
     * @param groupId   组id
     * @param authorId  作者id
     * @param desc      描述
     * @param keyword   关键字
     * @param innerCode 类型软编号
     * @param url       图片url
     * @return boolean
     */
    boolean saveImage(Long groupId, Long authorId, String desc, String keyword, String innerCode, String url);

    /**
     * 按关键字获取图像信息
     *
     * @param keyword 关键字
     * @return {@link ImageInfo}
     */
    ImageInfo getImageInfoByKeyword(String keyword);

    /**
     * 得到图像cqCode
     *
     * @param keyword 关键字
     * @return {@link String}
     */
    String getImageCqCode(String keyword);
}
