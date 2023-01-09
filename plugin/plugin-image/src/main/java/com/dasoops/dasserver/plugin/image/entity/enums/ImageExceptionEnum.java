package com.dasoops.dasserver.plugin.image.entity.enums;

import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ImageExceptionEnum
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.enums.ImageExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/01
 * @Version 1.0.0
 * @Description: 图片异常枚举(105XX)
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum ImageExceptionEnum implements IExceptionEnum {
    /**
     *
     */
    KEYWORD_IS_REPEAT(10501, "图片关键词重复"),
    FILE_UPLOAD_ERROR(10502, "图片上传失败"),
    ID_NOT_FOUND(10503, "未找到对应id"),
    NO_AUTH(10504, "没有对应的权限"),
    IMAGE_SAVE_ERROR(10505, "图片存储异常"),
    ;
    final Integer code;
    final String msg;
}
