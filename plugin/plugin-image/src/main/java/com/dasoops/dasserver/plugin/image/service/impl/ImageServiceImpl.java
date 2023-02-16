package com.dasoops.dasserver.plugin.image.service.impl;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.cache.RegisterCache;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.image.cache.ImageCache;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import com.dasoops.dasserver.plugin.image.entity.dto.ExportImageInfoDto;
import com.dasoops.dasserver.plugin.image.entity.enums.ImageCanEditEnum;
import com.dasoops.dasserver.plugin.image.entity.enums.ImageExceptionEnum;
import com.dasoops.dasserver.plugin.image.entity.param.*;
import com.dasoops.dasserver.plugin.image.entity.vo.GetFantasyKeywordVo;
import com.dasoops.dasserver.plugin.image.entity.vo.GetImageVo;
import com.dasoops.dasserver.plugin.image.entity.vo.UploadImageVo;
import com.dasoops.dasserver.plugin.image.mapper.ImageMapper;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.minio.MinioTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * @title ImagePoServiceImpl
 * @classPath com.dasoops.dasserver.plugin.image.service.impl.ImagePoServiceImpl
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/07
 * @version 1.0.0
 * @description 针对表【tb_plugin_image(图片信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see ImageService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageSimpleSql simpleSql;
    private final MinioTemplate minioTemplate;
    private final ImageMapper imageMapper;
    private final RegisterCache registerCache;
    private final ImageCache imageCache;

    @Override
    public boolean keywordIsRepeat(String keyword) {
        return simpleSql.lambdaQuery().eq(ImageDo::getKeyword, keyword).count() > 0;
    }

    private boolean keywordIsRepeat(String keyword, Long id) {
        return simpleSql.lambdaQuery().ne(ImageDo::getRowId, id).eq(ImageDo::getKeyword, keyword).count() > 0;
    }

    @Override
    public List<String> getFantasyKeyword(String keyword) {
        return imageMapper.selectLikeKeyword(keyword);
    }

    @Override
    public boolean saveImage(Long groupId, Long authorId, String keyword, String url) {
        //检查关键词是否重复
        keyword = keyword.trim();
        if (keywordIsRepeat(keyword)) {
            return false;
        }

        String filename;
        try {
            filename = minioTemplate.saveImage(url);
        } catch (Exception e) {
            throw new CqLogicException(ImageExceptionEnum.IMAGE_SAVE_ERROR, e);
        }

        ImageDo imagePo = new ImageDo();
        imagePo.setKeyword(keyword);
        imagePo.setFileName(filename);
        imagePo.setGroupId(groupId);
        imagePo.setAuthorId(authorId);

        //信息持久化
        imageCache.addKeyword(keyword);
        return simpleSql.save(imagePo);
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
        return simpleSql.lambdaQuery().eq(ImageDo::getKeyword, keyword).one();
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

    @Override
    public IPage<GetImageVo> getImageInfoPage(GetImageInfoPageParam param) {
        Assert.getInstance().allMustNotNull(param);
        //根据更新时间判断(网页端有更新的需求实现,会导致关键词的覆盖)
        QueryWrapper<ImageDo> wrapper = param.buildWrapper("UPDATE_TIME");

        //拼接like参数
        wrapper.lambda()
                .like(param.getKeyword() != null && !"".equals(param.getKeyword()), ImageDo::getKeyword, param.getKeyword())
                .eq(param.getCreateUser() != null, ImageDo::getCreateUser, param.getCreateUser())
                .orderByDesc(ImageDo::getUpdateTime);

        Long authorId = EventUtil.get().getAuthorId();
        IPage<ImageDo> page = simpleSql.page(param.buildSelectPage(), wrapper);
        IPage<GetImageVo> resVoPage = page.convert(imageDo -> {
            Long registerId = imageDo.getAuthorId();
            String fileName = imageDo.getFileName();
            GetImageVo resVo = new GetImageVo();
            resVo.setRowId(imageDo.getRowId());
            resVo.setKeyword(imageDo.getKeyword());
            resVo.setFileName(fileName);
            resVo.setFilePath(minioTemplate.buildImagePath(fileName));
            resVo.setGroupId(imageDo.getGroupId());
            resVo.setAuthorId(registerId);
            resVo.setAuthorName(registerCache.getRegisterUserNameById(registerId));
            resVo.setUpdateTime(DateUtil.format(imageDo.getUpdateTime(), DatePattern.NORM_DATETIME_FORMAT));
            resVo.setCanEdit(authorId.equals(registerId) ? ImageCanEditEnum.TRUE.getDbValue() : ImageCanEditEnum.FALSE.getDbValue());
            return resVo;
        });

        return resVoPage;
    }

    @Override
    public GetFantasyKeywordVo getFantasyKeyword4Cache(GetFantasyKeywordParam param) {
        Assert.getInstance().allMustNotNull(param, param.getKeyword());
        List<String> keywordList = imageCache.getImageKeywordList();
        List<String> fantasyKeywordList = keywordList.stream().filter(keyword -> keyword.contains(param.getKeyword())).toList();
        GetFantasyKeywordVo vo = new GetFantasyKeywordVo();
        vo.setKeywordList(fantasyKeywordList);
        return vo;
    }

    @Override
    public List<String> getFantasyKeyword4Cache(String keyword) {
        GetFantasyKeywordParam getFantasyKeywordParam = new GetFantasyKeywordParam();
        getFantasyKeywordParam.setKeyword(keyword);
        GetFantasyKeywordVo keywordList = this.getFantasyKeyword4Cache(getFantasyKeywordParam);
        return keywordList.getKeywordList();
    }


    @Override
    public void editImageInfo(EditImageInfoParam param) {
        Assert.getInstance().allMustNotNull(param, param.getRowId(), param.getKeyword(), param.getFileName());

        String keyword = param.getKeyword();
        Long id = param.getRowId();

        Long authorId = EventUtil.get().getAuthorId();
        ImageDo imageDo = simpleSql.getById(id);
        if (!imageDo.getCreateUser().equals(authorId)) {
            throw new LogicException(ImageExceptionEnum.NO_AUTH);
        }

        if (this.keywordIsRepeat(keyword, id)) {
            throw new LogicException(ImageExceptionEnum.KEYWORD_IS_REPEAT);
        }

        String fileName = param.getFileName();
        boolean isExist = minioTemplate.checkFileIsExists(fileName);
        if (!isExist) {
            throw new LogicException(ImageExceptionEnum.FILE_UPLOAD_ERROR);
        }

        ImageDo newImageDo = new ImageDo();
        newImageDo.setRowId(id);
        newImageDo.setKeyword(keyword);
        newImageDo.setFileName(fileName);
        simpleSql.updateById(newImageDo);

    }

    @Override
    public GetNextIdVo getNextId() {
        Long id = imageMapper.selectMaxId() + 1;
        GetNextIdVo getNextIdVo = new GetNextIdVo();
        getNextIdVo.setRowId(id);
        return getNextIdVo;
    }

    @Override
    public void addImage(AddImageParam param) {
        Assert.getInstance().allMustNotNull(param);

        String keyword = param.getKeyword();
        if (this.keywordIsRepeat(keyword)) {
            throw new LogicException(ImageExceptionEnum.KEYWORD_IS_REPEAT);
        }

        String fileName = param.getFileName();
        boolean isExist = minioTemplate.checkFileIsExists(fileName);
        if (!isExist) {
            throw new LogicException(ImageExceptionEnum.FILE_UPLOAD_ERROR);
        }

        ImageDo imageDo = new ImageDo();
        imageDo.setKeyword(keyword);
        imageDo.setFileName(fileName);
        imageDo.setAuthorId(EventUtil.get().getAuthorId());
        imageDo.setGroupId(-1L);

        simpleSql.save(imageDo);
    }

    @Override
    public void deleteImage(DeleteImageParam param) {
        Assert.getInstance().allMustNotNull(param, param.getRowId());

        Long id = param.getRowId();
        ImageDo imageDo = simpleSql.getById(id);

        if (imageDo == null) {
            throw new LogicException(ImageExceptionEnum.ID_NOT_FOUND);
        }

        Long authorId = imageDo.getAuthorId();
        if (!EventUtil.get().getAuthorId().equals(authorId)) {
            throw new LogicException(ImageExceptionEnum.NO_AUTH);
        }

        simpleSql.removeById(id);
    }

    @Override
    public List<ExportImageInfoDto> exportAllImageInfo() {
        List<ImageDo> imageDoList = simpleSql.list();
        return imageDoList.stream().map(imageDo -> {
            ExportImageInfoDto dto = new ExportImageInfoDto();
            dto.setRowId(imageDo.getRowId());
            dto.setKeyword(imageDo.getKeyword());
            dto.setFilePath(minioTemplate.buildImagePath(imageDo.getFileName()));
            Long authorId = imageDo.getAuthorId();
            dto.setAuthorId(authorId);
            dto.setAuthorName(registerCache.getRegisterUserNameByRowId(registerCache.getUserRowIdByRegisterId(authorId)));
            dto.setCreateTime(DateUtil.format(imageDo.getCreateTime(), DatePattern.NORM_DATETIME_FORMATTER));
            return dto;
        }).toList();
    }

    @Override
    public void initOrUpdateImageKeywordList() {
        log.info("初始化/更新 图片关键词集合 缓存");
        List<String> keywordList = imageMapper.selectKeywordList();
        imageCache.setImageKeywordList(keywordList);
    }

    @Override
    public UploadImageVo uploadImage(MultipartFile file) {
        String fileName;
        try {
            fileName = minioTemplate.saveImage(file.getInputStream(), file.getContentType() == null ? "image/jpg" : file.getContentType());
        } catch (Exception e) {
            throw new LogicException(ImageExceptionEnum.FILE_UPLOAD_ERROR);
        }
        UploadImageVo uploadImageVo = new UploadImageVo();
        uploadImageVo.setFileName(fileName);
        uploadImageVo.setFilePath(minioTemplate.buildImagePath(fileName));
        return uploadImageVo;
    }
}




