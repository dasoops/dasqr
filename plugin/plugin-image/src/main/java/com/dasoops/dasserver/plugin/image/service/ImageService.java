package com.dasoops.dasserver.plugin.image.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import com.dasoops.dasserver.plugin.image.entity.dto.ExportImageInfoDto;
import com.dasoops.dasserver.plugin.image.entity.param.*;
import com.dasoops.dasserver.plugin.image.entity.vo.GetFantasyKeywordVo;
import com.dasoops.dasserver.plugin.image.entity.vo.GetImageVo;
import com.dasoops.dasserver.plugin.image.entity.vo.UploadImageVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
* @author Administrator
* @description 针对表【tb_plugin_image(图片信息)】的数据库操作Service
* @createDate 2022-11-07 15:23:49
*/
public interface ImageService {

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
    List<String> getFantasyKeyword(String keyword);

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
     * @return {@link ImageDo}
     */
    ImageDo getImageByKeyword(String keyword);

    /**
     * 根据关键词获取图片CqCode
     *
     * @param keyword 关键字
     * @return {@link Optional}<{@link String}>
     */
    Optional<String> getImageCqCode(String keyword);

    /**
     * 获取图片页面数据
     *
     * @param param param
     * @return {@link IPage}<{@link GetImageVo}>
     */
    IPage<GetImageVo> getImageInfoPage(GetImageInfoPageParam param);

    /**
     * 获取联想关键字 forCache
     *
     * @param param param
     * @return {@link GetFantasyKeywordVo}
     */
    GetFantasyKeywordVo getFantasyKeyword4Cache(GetFantasyKeywordParam param);

    /**
     * 获取联想关键字 forCache
     *
     * @param keyword 关键字
     * @return {@link List}<{@link String}>
     */
    List<String> getFantasyKeyword4Cache(String keyword);

    /**
     * 编辑图片信息
     *
     * @param param param
     */
    void editImageInfo(EditImageInfoParam param);

    /**
     * 获取下一个id
     *
     * @return {@link GetNextIdVo}
     */
    GetNextIdVo getNextId();

    /**
     * 添加图片
     *
     * @param param param
     */
    void addImage(AddImageParam param);

    /**
     * 删除图片
     *
     * @param param param
     */
    void deleteImage(DeleteImageParam param);

    /**
     * 导出所有图片信息
     *
     * @return {@link List}<{@link ExportImageInfoDto}>
     */
    List<ExportImageInfoDto> exportAllImageInfo();

    /**
     * 初始化或更新图片关键字集合
     */
    void initOrUpdateImageKeywordList();

    /**
     * 上传图片
     *
     * @param file 文件
     * @return {@link UploadImageVo}
     */
    UploadImageVo uploadImage(MultipartFile file);
}
