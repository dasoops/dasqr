package com.dasoops.dasserver.plugin.image.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.BaseCustomException;
import com.dasoops.common.util.ExceptionUtil;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.image.entity.po.ImageDo;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import com.dasoops.dasserver.plugin.image.mapper.ImageMapper;
import com.dasoops.minio.MinioTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Title: ImagePoServiceImpl
 * @ClassPath com.dasoops.dasserver.plugin.image.service.impl.ImagePoServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/07
 * @Version 1.0.0
 * @Description: 针对表【TB_PLUGIN_IMAGE(图片信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see ImageService
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, ImageDo>
        implements ImageService {

    private final MinioTemplate minioTemplate;
    private final ImageMapper imageMapper;

    @SuppressWarnings("all")
    public ImageServiceImpl(MinioTemplate minioTemplate, ImageMapper imageMapper) {
        this.minioTemplate = minioTemplate;
        this.imageMapper = imageMapper;
    }

    @Override
    public boolean keywordIsRepeat(String keyword) {
        return super.lambdaQuery().eq(ImageDo::getKeyword, keyword).count() > 0;
    }

    @Override
    public Optional<List<String>> getFantasyKeyword(String keyword) {
        List<String> list = imageMapper.selectLikeKeyword(keyword);
        if (list == null || list.size() <= 0) {
            return Optional.empty();
        }
        return Optional.of(imageMapper.selectLikeKeyword(keyword));
    }

    @Override
    public boolean saveImage(Long groupId, Long authorId, String keyword, String url) {
        //检查关键词是否重复
        if (keywordIsRepeat(keyword)) {
            return false;
        }

        Optional<String> filenameOpt = Optional.empty();
        try {
            filenameOpt = minioTemplate.saveImage(url);
        } catch (Exception e) {
            ExceptionUtil.buildImageSaveError();
        }
        String filename = filenameOpt.orElseThrow(() -> new BaseCustomException(ExceptionEnum.IMAGE_SAVE_ERROR));


        ImageDo imagePo = new ImageDo();
        imagePo.setKeyword(keyword);
        imagePo.setFileName(filename);
        imagePo.setGroupId(groupId);
        imagePo.setAuthorId(authorId);

        //信息持久化
        return save(imagePo);
    }

    @Override
    public boolean saveImage(Long authorId, String keyword, String url) {
        return saveImage(-1L, authorId, keyword, url);
    }

    @Override
    public boolean saveImage(CqMessageEvent event, String key, String url) {
        if (event instanceof CqGroupMessageEvent) {
            return saveImage(((CqGroupMessageEvent) event).getGroupId(), event.getUserId(), key, url);
        }
        return saveImage(event.getUserId(), key, url);
    }

    @Override
    public ImageDo getImageByKeyword(String keyword) {
        return super.lambdaQuery().eq(ImageDo::getKeyword, keyword).one();
    }

    @Override
    public Optional<String> getImageCqCode(String keyword) {
        ImageDo imageInfo = this.getImageByKeyword(keyword);
        if (imageInfo == null) {
            return Optional.empty();
        }
        String url = minioTemplate.buildImagePath(imageInfo.getFileName());
        return Optional.of(CqCodeUtil.image(url));
    }

}




