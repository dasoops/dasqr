package com.dasoops.dasserver.cq.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BaseExportDto
 * @ClassPath com.dasoops.dasserver.cq.entity.dto.BaseExportDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 导出dto基类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseExportDto extends BaseDto {

    @ExcelProperty(value = "主键id",order = 0)
    private Long rowId;
}
