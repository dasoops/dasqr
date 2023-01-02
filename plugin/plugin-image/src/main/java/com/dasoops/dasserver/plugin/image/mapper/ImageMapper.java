package com.dasoops.dasserver.plugin.image.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_image(图片信息)】的数据库操作Mapper
 * @createDate 2022-11-07 15:23:49
 * @Entity com.dasoops.dasserver.plugin.image.entity.po.ImagePo
 */
public interface ImageMapper extends BaseMapper<ImageDo> {

    /**
     * 查询联想关键字
     *
     * @param keyword 关键字
     * @return {@link List}<{@link String}>
     */
    List<String> selectLikeKeyword(@Param("keyword") String keyword);

    /**
     * 查询最大id
     *
     * @return {@link Long}
     */
    Long selectMaxId();

    /**
     * 查询关键字集合
     *
     * @return {@link List}<{@link String}>
     */
    List<String> selectKeywordList();
}




