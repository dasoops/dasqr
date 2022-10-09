package com.dasoops.dasq.core.image.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.image.entity.enums.ImageRedisKeyEnum;
import com.dasoops.dasq.core.image.service.ImageTypeService;
import com.dasoops.dasq.core.image.entity.pojo.ImageType;
import com.dasoops.dasq.core.image.mapper.ImageTypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_IMAGE_TYPE】的数据库操作Service实现
 * @createDate 2022-10-07 16:40:31
 */
@Service
@Slf4j
public class ImageTypeServiceImpl extends ServiceImpl<ImageTypeMapper, ImageType>
        implements ImageTypeService {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;

    @Override
    public void initOrUpdateImageType2Redis() {
        log.info("初始化/更新 ImageType 数据至redis");

        //清除旧数据
        redisTemplate.delete(ImageRedisKeyEnum.IMAGE_INNER_CODE_GET_IMAGE_JSON.name());
        redisTemplate.delete(ImageRedisKeyEnum.IMAGE_ID_GET_IMAGE_JSON.name());

        //查询数据库,构建集合
        List<ImageType> list = super.lambdaQuery().list();
        Map<String, String> innerCodeRes = list.stream().collect(Collectors.toMap(ImageType::getInnerCode, JSON::toJSONString));
        Map<String, String> idRes = list.stream().collect(Collectors.toMap(res -> String.valueOf(res.getId()), JSON::toJSONString));

        //存入
        redisTemplate.opsForHash().putAll(ImageRedisKeyEnum.IMAGE_INNER_CODE_GET_IMAGE_JSON.name(), innerCodeRes);
        redisTemplate.opsForHash().putAll(ImageRedisKeyEnum.IMAGE_ID_GET_IMAGE_JSON.name(), idRes);

        log.info("完成: 初始化/更新 ImageType 数据至redis,innerCodeData:{},idData:{}", JSON.toJSONString(innerCodeRes), JSON.toJSONString(idRes));
    }

    @Override
    public Optional<Long> getTypeIdByTypeInnerCode(String innerCode) {
        String resJson = (String) redisTemplate.opsForHash().get(ImageRedisKeyEnum.IMAGE_INNER_CODE_GET_IMAGE_JSON.name(), innerCode);
        ImageType imageType = JSON.parseObject(resJson, ImageType.class);
        if (imageType == null) {
            return Optional.empty();
        }
        return Optional.of(imageType.getId());
    }

}




