package com.dasoops.dasserver.plugin.image.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo
import com.dasoops.dasserver.plugin.image.mapper.ImageMapper
import org.springframework.stereotype.Service

/**
 * @title: ImageSimpleSql
 * @classPath com.dasoops.dasserver.plugin.image.service.impl.ImageSimpleSql
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/11
 * @version 1.0.0
 * @description 图片简单sql
 * @see [ImageSimpleSql]
 */

@Service
open class ImageSimpleSql : ServiceImpl<ImageMapper, ImageDo>()