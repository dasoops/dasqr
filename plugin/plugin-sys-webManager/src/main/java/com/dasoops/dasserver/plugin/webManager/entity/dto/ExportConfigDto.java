package com.dasoops.dasserver.plugin.webManager.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ExportConfigDto
 * @ClassPath com.dasoops.dasserver.webManager.entity.dto.ExportConfigDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 出口配置dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExportConfigDto extends BaseDto {

    /**
     * id
     */
    @ExcelProperty(value = "id",index = 0)
    private Long id;

    /**
     * 关键字
     */
    @ExcelProperty(value = "关键字",index = 1)
    private String keyword;

    /**
     * 值
     */
    @ExcelProperty(value = "值",index = 2)
    private String value;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述",index = 3)
    private String description;

    /**
     * 是否可以编辑
     */
    @ExcelProperty(value = "是否可以编辑",index = 4)
    private boolean canEdit;

}
