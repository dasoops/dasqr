package com.dasoops.dasserver.plugin.image.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: UploadImageVo
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.vo.UploadImageVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/02
 * @Version 1.0.0
 * @Description: 上传图片vo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "上传图片vo", description = "上传图片vo")
public class UploadImageVo extends BaseVo {

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称", notes = "文件名称", example = "6c6323de-84aa-4a31-939f-eb4ca0d3f353.jpg", required = true)
    private String fileName;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径", notes = "文件路径", example = "http://106.13.5.29:9000/dasserver/6c6323de-84aa-4a31-939f-eb4ca0d3f353.jpg", required = true)
    private String filePath;

}
