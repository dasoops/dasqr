package com.dasoops.dasserver.plugin.loaj.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dasoops.dasserver.cq.entity.dto.BaseExportDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ExportReplyDto
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.dto.ExportReplyDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: 导出回复dto
 * @see BaseExportDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExportReplyDto extends BaseExportDto {

    /**
     * 触发关键词
     */
    @ExcelProperty(value = "触发关键词", order = 1)
    private String keyword;

    /**
     * 回复
     */
    @ExcelProperty(value = "回复", order = 2)
    private String reply;

    /**
     * 匹配类型
     */
    @ExcelProperty(value = "匹配类型", order = 3)
    private String matchType;

    /**
     * 忽略大小写
     */
    @ExcelProperty(value = "忽略大小写", order = 4)
    private Boolean ignoreCase;

    /**
     * 忽略全半角
     */
    @ExcelProperty(value = "忽略全半角", order = 5)
    private Boolean ignoreDbc;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用", order = 6)
    private Boolean enable;

}
