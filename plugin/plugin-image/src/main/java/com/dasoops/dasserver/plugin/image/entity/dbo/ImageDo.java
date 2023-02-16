package com.dasoops.dasserver.plugin.image.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @title ImagePo
 * @classPath com.dasoops.dasserver.plugin.image.entity.po.ImagePo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/07
 * @version 1.0.0
 * @description 图片信息
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="tb_plugin_image")
@Data
public class ImageDo extends BaseDo {

    /**
     * 存/取 关键词
     */
    private String keyword;

    /**
     * 存储文件名
     */
    private String fileName;

    /**
     * 群组ID,私聊存储为-1
     */
    private Long groupId;

    /**
     * 创建人ID
     */
    private Long authorId;
}