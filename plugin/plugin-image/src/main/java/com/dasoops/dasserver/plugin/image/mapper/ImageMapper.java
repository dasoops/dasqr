package com.dasoops.dasserver.plugin.image.mapper;

import com.dasoops.dasserver.plugin.image.entity.po.ImageDo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【TB_PLUGIN_IMAGE(图片信息)】的数据库操作Mapper
* @createDate 2022-11-07 15:23:49
* @Entity com.dasoops.dasserver.plugin.image.entity.po.ImagePo
*/
public interface ImageMapper extends BaseMapper<ImageDo> {

    /**
     * 查询关联关键字
     *
     * @param keyword 关键字
     * @return {@link List}<{@link String}>
     */
    List<String> selectLikeKeyword(@Param("keyword") String keyword);
}




