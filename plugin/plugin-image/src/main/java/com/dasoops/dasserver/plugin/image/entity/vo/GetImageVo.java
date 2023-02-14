package com.dasoops.dasserver.plugin.image.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: GetImageVo
 * @classPath com.dasoops.dasserver.plugin.image.entity.vo.GetImageVo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 获取图片vo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取图片vo", description = "获取图片vo")
public class GetImageVo extends BaseVo {

    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "10", required = true)
    private Long rowId;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "你好", required = true)
    private String keyword;

    /**
     * 图片名称
     */
    @ApiModelProperty(value = "图片名称", notes = "图片名称", example = "5efd9177-259c-4aee-b005-3343684da3df.jpg", required = true)
    private String fileName;

    /**
     * 图片路径
     */
    @ApiModelProperty(value = "图片路径", notes = "图片路径", example = "http://106.13.5.29:9000/dasserver/5efd9177-259c-4aee-b005-3343684da3df.jpg", required = true)
    private String filePath;

    /**
     * 上传群组id
     */
    @ApiModelProperty(value = "上传群组id", notes = "上传群组id", example = "673745932", required = false)
    private Long groupId;

    /**
     * 上传用户id
     */
    @ApiModelProperty(value = "上传用户id", notes = "上传用户id", example = "776465218", required = true)
    private Long authorId;

    /**
     * 上传用户名称
     */
    @ApiModelProperty(value = "上传用户名称", notes = "上传用户名称", example = "Das", required = true)
    private String authorName;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", notes = "更新时间", example = "2022-10-12 16:22:53", required = true)
    private String updateTime;

    /**
     * 是否可编辑
     */
    @ApiModelProperty(value = "是否可编辑", notes = "是否可编辑(0:false;1:true)", example = "1", required = true)
    private Integer canEdit;

}
