package com.dasoops.minio;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: MinioExceptionEnum
 * @classPath com.dasoops.minio.MinioExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description minio异常枚举
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum MinioExceptionEnum implements IExceptionEnum {
    /**
     * eem快速生成
     */
    SAVE_ERROR("图片保存失败"),
    ;


    @Override
    public Integer getCode() {
        return 10000 + ordinal();
    }

    @Getter
    final String msg;

}
