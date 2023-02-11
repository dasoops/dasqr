package com.dasoops.dasserver.plugin.image.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo
import com.dasoops.dasserver.plugin.image.mapper.ImageMapper
import org.springframework.stereotype.Service

/**
 * @Title: ImageSimpleSql
 * @ClassPath com.dasoops.dasserver.plugin.image.service.impl.ImageSimpleSql
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/11
 * @Version 1.0.0
 * @Description: 图片简单sql
 * @see [ImageSimpleSql]
 */

@Service
open class ImageSimpleSql : ServiceImpl<ImageMapper, ImageDo>()