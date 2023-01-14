package com.dasoops.dasserver.plugin.image.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ImageExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.enums.ImageExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: 图片异常枚举(104XX)
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum ImageExceptionEnum implements IExceptionEnum {
    /**
     * eem快速生成
     */
    KEYWORD_IS_REPEAT("图片关键词重复"),
    FILE_UPLOAD_ERROR("图片上传失败"),
    ID_NOT_FOUND("未找到对应id"),
    NO_AUTH("没有对应的权限"),
    IMAGE_SAVE_ERROR("图片存储异常"),
    ;


    @Override
    public Integer getCode() {
        return 10000 + ordinal();
    }

    @Getter
    final String msg;
}
