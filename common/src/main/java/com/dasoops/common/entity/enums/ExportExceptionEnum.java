package com.dasoops.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ExportExceptionEnum
 * @ClassPath com.dasoops.common.entity.enums.ExportExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 导出异常枚举(91xx)
 * @see IExceptionEnum
 */
@Getter
@AllArgsConstructor
public enum ExportExceptionEnum implements IExceptionEnum {
    /***/
    DATA_NULL(9101, "导出数据为空"),
    URL_ENCODER_ERROR(9102, "导出部分url转码错误"),
    DOWNLOAD_ERROR(9103, "文件下载失败,请重试"),

    ;

    /**
     * 错误代码
     */
    private final Integer code;

    /**
     * 错误描述
     */
    private final String msg;

}
