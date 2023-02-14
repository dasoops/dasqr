package com.dasoops.dasserver.plugin.image.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: ExportImageInfoDto
 * @classPath com.dasoops.dasserver.plugin.image.entity.dto.ExportImageInfoDto
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 导出图片信息dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExportImageInfoDto extends BaseDto {

    /**
     * rowId
     */
    @ExcelProperty(value = "rowId", index = 0)
    private Long rowId;

    /**
     * 关键词
     */
    @ExcelProperty(value = "关键词", index = 1)
    private String keyword;

    /**
     * 图片链接
     */
    @ExcelProperty(value = "图片链接", index = 2)
    private String filePath;

    /**
     * 上传用户id
     */
    @ExcelProperty(value = "上传用户id", index = 3)
    private Long authorId;

    /**
     * 上传用户名称
     */
    @ExcelProperty(value = "上传用户名称", index = 4)
    private String authorName;

    /**
     * 上传时间
     */
    @ExcelProperty(value = "上传时间", index = 5)
    private String createTime;

}
