package com.dasoops.dasserver.plugin.image.plugin

import com.dasoops.dasserver.cq.CqPlugin
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum
import com.dasoops.dasserver.cq.utils.CqCodeUtil
import com.dasoops.dasserver.plugin.image.entity.dbo.ImageDo
import com.dasoops.dasserver.plugin.image.service.impl.ImageSimpleSql
import com.dasoops.minio.MinioTemplate
import org.springframework.stereotype.Component

/**
 * 随机图片插件
 * @title: RandomImagePlugin
 * @classPath com.dasoops.dasserver.plugin.image.plugin.RandomImagePlugin
 * @author DasoopsNicole@Gmail.com
 * @date 2023/03/09
 * @version 1.0.0
 * @see [RandomImagePlugin]
 */
@Component
class RandomImagePlugin(
    private val simpleSql: ImageSimpleSql,
    private val imageService: MinioTemplate
) : CqPlugin() {


    @MessageMapping(equal = ["randomImage", "随机取图"], type = MessageMappingTypeEnum.GROUP)
    fun randomImage(): String {
        val idList = simpleSql.ktQuery().select(ImageDo::rowId).list().map { it.rowId!! }.toList()
        val imagePath = imageService.buildImagePath(simpleSql.getById(idList.random()).fileName)
        return CqCodeUtil.image(imagePath)
    }
}