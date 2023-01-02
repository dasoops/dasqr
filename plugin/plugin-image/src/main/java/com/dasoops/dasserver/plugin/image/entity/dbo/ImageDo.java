package com.dasoops.dasserver.plugin.image.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Title: ImagePo
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.po.ImagePo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/07
 * @Version 1.0.0
 * @Description: 图片信息
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_PLUGIN_IMAGE")
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