package com.dasoops.dasq.core.image.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.image.entity.enums.ImageRedisKeyEnum;
import com.dasoops.dasq.core.image.entity.po.ImageInfo;
import com.dasoops.dasq.core.image.service.ImageTypeService;
import com.dasoops.dasq.core.image.service.ImageInfoService;
import com.dasoops.dasq.core.image.mapper.ImageInfoMapper;
import com.dasoops.minio.MinioTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.dasoops.dasq.core.common.util.KeywordUtil.buildImageCqCode;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_IMAGE_INFO(图片信息)】的数据库操作Service实现
 * @createDate 2022-10-07 16:40:31
 */
@Service
public class ImageInfoServiceImpl extends ServiceImpl<ImageInfoMapper, ImageInfo>
        implements ImageInfoService {

    @Resource
    private MinioTemplate minioTemplate;
    @Resource
    private ImageTypeService imageTypeService;
    @Resource
    private ImageInfoMapper imageInfoMapper;
    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    StringRedisTemplate redisTemplate;

    @Override
    public void initOrUpdate() {
        initOrUpdateImageKeywordList();
    }

    private void initOrUpdateImageKeywordList() {
        List<String> keywordList = imageInfoMapper.selectKeywordList();
        redisTemplate.opsForValue().set(ImageRedisKeyEnum.KEYWORD_LIST.getRedisKey(), JSON.toJSONString(keywordList));
    }

    @Override
    public List<String> getImageKeywordList() {
        String jsonStr = redisTemplate.opsForValue().get(ImageRedisKeyEnum.KEYWORD_LIST.getRedisKey());
        if (jsonStr == null) {
            return new ArrayList<>();
        }
        return JSON.parseArray(jsonStr, String.class);
    }

    @Override
    public boolean keywordIsRepeat(String keyword) {
        return super.lambdaQuery().eq(ImageInfo::getKeyword, keyword).count() > 0;
    }

    @Override
    public boolean saveImage(Long groupId, Long authorId, String desc, String keyword, String innerCode, String url) {
        //检查关键词是否重复
        if (keywordIsRepeat(keyword)) {
            return false;
        }

        Optional<String> filenameOpt;
        try {
            filenameOpt = minioTemplate.saveImage(url);
        } catch (Exception e) {
            throw new LogicException(ExceptionCodeEnum.IMAGE_SERVICE_ERROR, e);
        }
        String filename = filenameOpt.orElseThrow(() -> new LogicException(ExceptionCodeEnum.IMAGE_SERVICE_ERROR));

        long typeId;
        if (!StrUtil.isBlank(innerCode)) {
            Optional<Long> typeIdOpt = imageTypeService.getTypeIdByTypeInnerCode(innerCode);
            typeId = typeIdOpt.orElse(0L);
        } else {
            typeId = 0L;
        }

        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setKeyword(keyword);
        imageInfo.setFileName(filename);
        imageInfo.setTypeId(typeId);
        imageInfo.setGroupId(groupId == null ? -1L : groupId);
        imageInfo.setAuthorId(authorId);
        imageInfo.setDescription(desc == null ? "" : desc);

        //信息持久化
        return this.save(imageInfo);
    }

    @Override
    public ImageInfo getImageInfoByKeyword(String keyword) {
        return this.lambdaQuery().eq(ImageInfo::getKeyword, keyword).one();
    }

    @Override
    public Optional<String> getImageCqCode(String keyword) {
        ImageInfo imageInfo = this.getImageInfoByKeyword(keyword);
        if (imageInfo == null) {
            return Optional.empty();
        }
        String url = minioTemplate.buildImagePath(imageInfo.getFileName());
        return Optional.of(buildImageCqCode(url));
    }

}




