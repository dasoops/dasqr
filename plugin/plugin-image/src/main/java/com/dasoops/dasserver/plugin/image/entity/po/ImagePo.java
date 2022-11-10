package com.dasoops.dasserver.plugin.image.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.dasoops.dasserver.cq.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ImagePo
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.po.ImagePo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/07
 * @Version 1.0.0
 * @Description: 图片信息
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_PLUGIN_IMAGE")
@Data
public class ImagePo extends BasePo implements Serializable {

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


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}