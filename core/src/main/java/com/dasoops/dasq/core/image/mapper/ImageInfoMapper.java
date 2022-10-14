package com.dasoops.dasq.core.image.mapper;

import com.dasoops.dasq.core.image.entity.po.ImageInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_IMAGE_INFO(图片信息)】的数据库操作Mapper
 * @createDate 2022-10-07 16:40:31
 * @Entity com.dasoops.dasq.entify.ImageInfo
 */
public interface ImageInfoMapper extends BaseMapper<ImageInfo> {

    /**
     * 获取关键字列表
     *
     * @return {@link List}<{@link String}>
     */
    List<String> selectKeywordList();
}




