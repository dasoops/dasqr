package com.dasoops.dasq.core.image.service;

import com.dasoops.dasq.core.image.entity.po.ImageType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_IMAGE_TYPE】的数据库操作Service
 * @createDate 2022-10-07 21:46:50
 */
public interface ImageTypeService extends IService<ImageType> {

    /**
     * 初始化/更新 ImageType id-entityJson 数据至redis
     * 初始化/更新 ImageType innerCode-entityJson 数据至redis
     */
    void initOrUpdate();

    /**
     * 根据内部软编码从redis获取类型id
     *
     * @param innerCode 内部软编码
     * @return {@link Optional}<{@link Long}>
     */
    Optional<Long> getTypeIdByTypeInnerCode(String innerCode);
}
