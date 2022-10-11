package com.dasoops.dasq.core.image.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.image.entity.pojo.ImageInfo;
import com.dasoops.dasq.core.image.service.ImageTypeService;
import com.dasoops.dasq.core.image.service.ImageInfoService;
import com.dasoops.dasq.core.image.mapper.ImageInfoMapper;
import com.dasoops.minio.util.MinioTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

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

    @Override
    public void saveImage(Long groupId, Long authorId, String desc, String keyword, String innerCode, String url) {
        Optional<String> filenameOpt = minioTemplate.saveImage(url);
        String filename = filenameOpt.orElseThrow(() -> new LogicException(ExceptionCodeEnum.IMAGE_SERVICE_ERROR));

        long typeId;
        if (!StrUtil.isBlank(innerCode)) {
            Optional<Long> typeIdOpt = imageTypeService.getTypeIdByTypeInnerCode(innerCode);
            typeId = typeIdOpt.orElse(-1L);
        } else {
            typeId = -1L;
        }

        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setKeyword(keyword);
        imageInfo.setFileName(filename);
        imageInfo.setTypeId(typeId);
        imageInfo.setGroupId(groupId == null ? -1L : groupId);
        imageInfo.setAuthorId(authorId);
        imageInfo.setDesc(desc == null ? "" : desc);

        //信息持久化
        this.save(imageInfo);
    }

    @Override
    public ImageInfo getImageInfoByKeyword(String keyword) {
        return this.lambdaQuery().eq(ImageInfo::getKeyword, keyword).one();
    }


}




