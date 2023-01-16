package com.dasoops.dasserver.plugin.exceptionwrapper.entity.dbo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * @Title: ExceptionPo
 * @ClassPath com.dasoops.dasserver.plugin.exceptionwrapper.ExceptionPo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 异常记录
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
