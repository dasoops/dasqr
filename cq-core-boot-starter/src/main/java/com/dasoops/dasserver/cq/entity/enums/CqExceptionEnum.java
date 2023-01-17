package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: CqExceptionEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: cq异常枚举(101xx)
 * @see Enum
 * @see IExceptionEnum
 */
@AllArgsConstructor
@Getter
public enum CqExceptionEnum implements IExceptionEnum {
    /**
     * eem快速生成
     */
    CQ_GLOBAL_EMPTY("cq连接池为空"),
    RESPONSE_ERROR("cq请求失败"),
    UNKNOWN_POST_TYPE("未知的postType"),
    PARAM_RESLOVE_ERROR("参数解析失败"),
    REFLECT_INVOKE_ERROR("反射调用失败"),
    ;


    @Override
    public Integer getCode() {
        return 10100 + ordinal();
    }

    @Getter
    final String msg;


}