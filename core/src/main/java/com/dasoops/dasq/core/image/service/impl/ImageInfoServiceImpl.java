package com.dasoops.dasq.core.image.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.image.entity.ImageInfo;
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

    public void saveImage(Long authorId, String desc, String keyword, String innerCode, String url) {

        Optional<String> urlOpt = minioTemplate.saveImage(url);
        ImageInfo imageInfo = ImageInfo.builder()
                .authorId(authorId)
                .desc(desc)
                .keyword(keyword)
                .typeId(imageTypeService.getTypeIdByTypeInnerCode(innerCode).orElse(null))
                .fileName(urlOpt.orElse(null))
                .build();


    }


}




