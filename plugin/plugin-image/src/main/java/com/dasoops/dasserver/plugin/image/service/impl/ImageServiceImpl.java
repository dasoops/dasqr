package com.dasoops.dasserver.plugin.image.service.impl;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.EventUtil;
import com.dasoops.dasserver.plugin.image.cache.ImageCache;
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo;
import com.dasoops.dasserver.plugin.image.entity.dto.ExportImageInfoDto;
import com.dasoops.dasserver.plugin.image.entity.dto.FantastyUserDto;
import com.dasoops.dasserver.plugin.image.entity.enums.ImageCanEditEnum;
import com.dasoops.dasserver.plugin.image.entity.enums.ImageExceptionEnum;
import com.dasoops.dasserver.plugin.image.entity.param.*;
import com.dasoops.dasserver.plugin.image.entity.vo.GetFantastyKeywordVo;
import com.dasoops.dasserver.plugin.image.entity.vo.GetFantastyUserVo;
import com.dasoops.dasserver.plugin.image.entity.vo.GetImageVo;
import com.dasoops.dasserver.plugin.image.entity.vo.UploadImageVo;
import com.dasoops.dasserver.plugin.image.mapper.ImageMapper;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import com.dasoops.dasserver.plugin.webmanager.cache.RegisterWebCache;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.util.WebAssert;
import com.dasoops.minio.MinioTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Title: ImagePoServiceImpl
 * @ClassPath com.dasoops.dasserver.plugin.image.service.impl.ImagePoServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/07
 * @Version 1.0.0
 * @Description: 针对表【tb_plugin_image(图片信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see ImageService
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, ImageDo>
        implements ImageService {

    private final MinioTemplate minioTemplate;
    private final ImageMapper imageMapper;
    private final RegisterWebCache registerWebCache;
    private final ImageCache imageCache;

    @SuppressWarnings("all")
    public ImageServiceImpl(MinioTemplate minioTemplate, ImageMapper imageMapper, RegisterWebCache registerWebCache, ImageCache imageCache) {
        this.minioTemplate = minioTemplate;
        this.imageMapper = imageMapper;
        this.registerWebCache = registerWebCache;
        this.imageCache = imageCache;
    }

    @Override
    public boolean keywordIsRepeat(String keyword) {
        return super.lambdaQuery().eq(ImageDo::getKeyword, keyword).count() > 0;
    }

    private boolean keywordIsRepeat(String keyword, Long id) {
        return super.lambdaQuery().ne(ImageDo::getRowId, id).eq(ImageDo::getKeyword, keyword).count() > 0;
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
            throw new CqLogicException(ExceptionEnum.IMAGE_SAVE_ERROR);
        }


        ImageDo imagePo = new ImageDo();
        imagePo.setKeyword(keyword);
        imagePo.setFileName(filename);
        imagePo.setGroupId(groupId);
        imagePo.setAuthorId(authorId);

        //信息持久化
        imageCache.addKeyword(keyword);
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

    @Override
    public IPage<GetImageVo> getImageInfoPage(GetImageInfoPageParam param) {
        WebAssert.allMustNotNull(param);
        //根据更新时间判断(网页端有更新的需求实现,会导致关键词的覆盖)
        QueryWrapper<ImageDo> wrapper = param.buildTimeQueryWrapper("UPDATE_TIME");

        //拼接like参数
        wrapper.lambda()
                .like(param.getKeyword() != null && !"".equals(param.getKeyword()), ImageDo::getKeyword, param.getKeyword())
                .eq(param.getCreateUser() != null, ImageDo::getCreateUser, param.getCreateUser())
                .orderByDesc(ImageDo::getUpdateTime);

        Long authorId = EventUtil.get().getAuthorId();
        IPage<ImageDo> page = super.page(param.buildSelectPage(), wrapper);
        IPage<GetImageVo> resVoPage = page.convert(imageDo -> {
            Long registerId = imageDo.getAuthorId();
            String fileName = imageDo.getFileName();
            GetImageVo resVo = new GetImageVo();
            resVo.setId(imageDo.getRowId());
            resVo.setKeyword(imageDo.getKeyword());
            resVo.setFileName(fileName);
            resVo.setFilePath(minioTemplate.buildImagePath(fileName));
            resVo.setGroupId(imageDo.getGroupId());
            resVo.setAuthorId(registerId);
            resVo.setAuthorName(registerWebCache.getRegisterNameByRowId(registerId));
            resVo.setUpdateTime(DateUtil.format(imageDo.getUpdateTime(), DatePattern.NORM_DATETIME_FORMAT));
            resVo.setCanEdit(authorId.equals(registerId) ? ImageCanEditEnum.TRUE.getDbValue() : ImageCanEditEnum.FALSE.getDbValue());
            return resVo;
        });

        return resVoPage;
    }

    @Override
    public GetFantastyKeywordVo getFantasyKeyword4Cache(GetFantastyKeywordParam param) {
        Assert.allMustNotNull(param, param.getKeyword());
        List<String> keywordList = imageCache.getImageKeywordList();
        List<String> fantasyKeywordList = keywordList.stream().filter(keyword -> keyword.contains(param.getKeyword())).toList();
        GetFantastyKeywordVo vo = new GetFantastyKeywordVo();
        vo.setKeywordList(fantasyKeywordList);
        return vo;
    }

    @Override
    public List<String> getFantasyKeyword4Cache(String keyword) {
        GetFantastyKeywordParam getFantastyKeywordParam = new GetFantastyKeywordParam();
        getFantastyKeywordParam.setKeyword(keyword);
        GetFantastyKeywordVo keywordList = this.getFantasyKeyword4Cache(getFantastyKeywordParam);
        return keywordList.getKeywordList();
    }

    @Override
    public GetFantastyUserVo getFantasyUser(GetFantastyUserParam param) {
        WebAssert.allMustNotNull(param);

        Map<String, String> allRegisterUser = registerWebCache.getAllRegisterUser();

        List<FantastyUserDto> fantasyUserList = new ArrayList<>();

        //id或名称匹配
        String keyword;
        if (param.getKeyword() == null) {
            keyword = "";
        } else {
            keyword = param.getKeyword();
        }
        allRegisterUser.entrySet().stream()
                .filter(entry -> entry.getKey().contains(keyword) || entry.getValue().contains(keyword))
                .forEach(entry -> {
                    FantastyUserDto dto = new FantastyUserDto();
                    dto.setRegisterId(Long.valueOf(entry.getKey()));
                    dto.setName(entry.getValue());
                    fantasyUserList.add(dto);
                });
        GetFantastyUserVo getFantastyUserVo = new GetFantastyUserVo();
        final int maxReturnCount = 5;
        if (fantasyUserList.size() <= maxReturnCount) {
            getFantastyUserVo.setFantastyUserList(fantasyUserList);
        } else {
            getFantastyUserVo.setFantastyUserList(fantasyUserList.subList(0, 5));
        }
        return getFantastyUserVo;
    }

    @Override
    public void editImageInfo(EditImageInfoParam param) {
        WebAssert.allMustNotNull(param, param.getId(), param.getKeyword(), param.getFileName());

        String keyword = param.getKeyword();
        Long id = param.getId();

        Long authorId = EventUtil.get().getAuthorId();
        ImageDo imageDo = super.getById(id);
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
        super.updateById(newImageDo);

    }

    @Override
    public GetNextIdVo getNextId() {
        Long id = imageMapper.selectMaxId() + 1;
        GetNextIdVo getNextIdVo = new GetNextIdVo();
        getNextIdVo.setId(id);
        return getNextIdVo;
    }

    @Override
    public void addImage(AddImageParam param) {
        WebAssert.allMustNotNull(param);

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

        super.save(imageDo);
    }

    @Override
    public void deleteImage(DeleteImageParam param) {
        WebAssert.allMustNotNull(param, param.getId());

        Long id = param.getId();
        ImageDo imageDo = super.getById(id);

        if (imageDo == null) {
            throw new LogicException(ImageExceptionEnum.ID_NOT_FOUND);
        }

        Long authorId = imageDo.getAuthorId();
        if (!EventUtil.get().getAuthorId().equals(authorId)) {
            throw new LogicException(ImageExceptionEnum.NO_AUTH);
        }

        super.removeById(id);
    }

    @Override
    public List<ExportImageInfoDto> exportAllImageInfo() {
        List<ImageDo> imageDoList = super.list();
        return imageDoList.stream().map(imageDo -> {
            ExportImageInfoDto dto = new ExportImageInfoDto();
            dto.setId(imageDo.getRowId());
            dto.setKeyword(imageDo.getKeyword());
            dto.setFilePath(minioTemplate.buildImagePath(imageDo.getFileName()));
            Long authorId = imageDo.getAuthorId();
            dto.setAuthorId(authorId);
            dto.setAuthorName(registerWebCache.getRegisterNameByRowId(authorId));
            dto.setCreateTime(DateUtil.format(imageDo.getCreateTime(), DatePattern.NORM_DATETIME_FORMATTER));
            return dto;
        }).toList();
    }

    @Override
    public void initOrUpdateImageKeywordList() {
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




