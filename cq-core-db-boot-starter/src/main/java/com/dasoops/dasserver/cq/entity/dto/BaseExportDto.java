package com.dasoops.dasserver.cq.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title BaseExportDto
 * @classPath com.dasoops.dasserver.cq.entity.dto.BaseExportDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 导出dto基类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseExportDto extends BaseDto {

    @ExcelProperty(value = "主键id",order = 0)
    private Long rowId;
}
