package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: CqExceptionEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: cq异常枚举(100xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum CqExceptionEnum implements IExceptionEnum {

    /***/
    CQ_GLOBAL_EMPTY(10001, "cq连接池为空"),
    RESPONSE_ERROR(10002, "cq请求失败"), UNKNOWN_POST_TYPE(10003, "未知的postType"), PARAM_RESLOVE_ERROR(10004, "参数解析失败");

    final Integer code;
    final String msg;

}