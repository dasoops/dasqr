package com.dasoops.dasserver.plugin.exceptionwrapper.entity.dbo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * @title: ExceptionPo
 * @classPath com.dasoops.dasserver.plugin.exceptionwrapper.ExceptionPo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/03
 * @version 1.0.0
 * @description 异常记录
 */
@Document("exception")
@Data
public class ExceptionDo {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private ObjectId id;
    /**
     * 时间戳
     */
    private Date time;

    /**
     * 堆栈信息
     */
    private String stackMessage;

    /**
     * 异常类型
     * (BaseCustomException为枚举类,Exception为异常类型)
     */
    private String type;
}
